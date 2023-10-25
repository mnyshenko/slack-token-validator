package org.example.validator;

public class TokenValidatorImpl implements TokenValidator {

    @Override
    public boolean isValid(String token) {
        return !token.isEmpty();
    }
}
