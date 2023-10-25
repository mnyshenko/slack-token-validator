package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.example.dto.Action;
import org.example.dto.Response;
import org.example.service.TokenService;
import org.example.service.TokenServiceImpl;
import static org.example.dto.Action.INVITE;
import static org.example.dto.Action.SEND_MESSAGE;

public class SlackTokenValidatorApp {

    private static final Map<String, Response> passwordToActions = Map.of(
            "123", Response.success(List.of(INVITE, SEND_MESSAGE)),
            "1234", Response.success(List.of(INVITE)),
            "12345", Response.success(List.of(Action.values())),
            "123456", Response.success(Collections.emptyList()),
            "1234567", Response.failed(), //invalid token under this password
            "12345678", Response.failed()); //no token for this password

    private static final TokenService tokenService = new TokenServiceImpl();

    public static void main(String[] args) {
        boolean allTestsPassed = passwordToActions.entrySet().stream()
                .allMatch(SlackTokenValidatorApp::test);

        System.out.println("\nallTestsPassed: " + allTestsPassed);
    }

    private static boolean test(Map.Entry<String, Response> entry) {
        String password = entry.getKey();
        Response expectedResponse = entry.getValue();

        Response actualResponse = tokenService.process(password);
        boolean equalityResult = expectedResponse.equals(actualResponse);

        printTestResults(password, actualResponse, expectedResponse, equalityResult);

        return equalityResult;
    }

    private static void printTestResults(String password, Response actualResponse, Response expectedResponse, boolean equalityResult) {
        System.out.println("password: " + password);
        System.out.println("expectedResponse: " + expectedResponse);
        System.out.println("actualResponse: " + actualResponse);
        System.out.println("equalityResult: " + equalityResult);
        System.out.println("------------------------------");
    }
}
