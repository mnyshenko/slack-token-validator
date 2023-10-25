package org.example.decoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.SlackTokenPayload;

public interface TokenDecoder {
    SlackTokenPayload decode(String token) throws JsonProcessingException;
}
