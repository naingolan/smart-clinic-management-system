package com.nainggolan.smart_clinic_management_system.services;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public boolean validateToken(String token){
        return token !=null && !token.isEmpty();
    }
}
