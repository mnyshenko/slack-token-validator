package org.example.service;

import org.example.dto.Response;

public interface TokenService {

    Response process(String password);
}
