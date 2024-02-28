package com.example.skincare_backend.service;

import com.example.skincare_backend.dto.AuthenticateRequest;
import com.example.skincare_backend.dto.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
