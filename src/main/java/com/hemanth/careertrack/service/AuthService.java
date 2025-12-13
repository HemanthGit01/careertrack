package com.hemanth.careertrack.service;

import com.hemanth.careertrack.dto.AuthRequest;
import com.hemanth.careertrack.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
