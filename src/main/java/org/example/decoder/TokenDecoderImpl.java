package org.example.decoder;

import java.util.Base64;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.SlackTokenPayload;

public class TokenDecoderImpl implements TokenDecoder {

    private static final String JWT_SPLIT_REGEX = "\\.";
    private static final int PAYLOAD_INDEX = 1;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SlackTokenPayload decode(String token) throws JsonProcessingException {
        byte[] decodedPayloadBytes = Base64.getUrlDecoder().decode(token.split(JWT_SPLIT_REGEX)[PAYLOAD_INDEX]);
        String payload = new String(decodedPayloadBytes);

        return objectMapper.readValue(payload, SlackTokenPayload.class);
    }
}
