package com.b1nd.alimoserver.global.infra.jwt.port.out;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface ParseJwtTokenPort {
    Authentication getAuthentication(String accessToken);
    String resolveToken(HttpServletRequest request);
    Claims getClaims(String token);
}
