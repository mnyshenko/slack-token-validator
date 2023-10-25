package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.client.SlackClient;
import org.example.client.SlackClientImpl;
import org.example.decoder.TokenDecoder;
import org.example.decoder.TokenDecoderImpl;
import org.example.dto.Response;
import org.example.dto.SlackTokenPayload;
import org.example.validator.TokenValidator;
import org.example.validator.TokenValidatorImpl;

public class TokenServiceImpl implements TokenService {

    private final TokenDecoder tokenDecoder = new TokenDecoderImpl();
    private final TokenValidator tokenValidator = new TokenValidatorImpl();
    private final SlackClient slackClient = new SlackClientImpl();


    @Override
    public Response process(String password) {
        String token = slackClient.retrieveToken(password);

        if (!tokenValidator.isValid(token)) {
            return Response.failed();
        }

        Response response;
        try {
            SlackTokenPayload payload = tokenDecoder.decode(token);
            response = Response.success(payload.getActions());
        } catch (JsonProcessingException exception) {
            System.err.println("Parsing of " + token + " token has failed");
            response = Response.failed();
        }

        return response;
    }
}
