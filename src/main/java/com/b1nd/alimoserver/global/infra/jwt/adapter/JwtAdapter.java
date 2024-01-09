package com.b1nd.alimoserver.global.infra.jwt.adapter;

import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberMapper;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import com.b1nd.alimoserver.global.error.custom.auth.ExpiredTokenException;
import com.b1nd.alimoserver.global.error.custom.auth.InvalidTokenException;
import com.b1nd.alimoserver.global.error.custom.user.MemberNotFoundException;
import com.b1nd.alimoserver.global.infra.jwt.port.out.ParseJwtTokenPort;
import com.b1nd.alimoserver.global.infra.jwt.port.out.ProvideJwtTokenPort;
import com.b1nd.alimoserver.global.infra.security.CustomUserDetails;
import com.b1nd.alimoserver.global.properties.JwtProperties;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Date;

@PersistenceAdapter
@RequiredArgsConstructor
public class JwtAdapter implements ProvideJwtTokenPort, ParseJwtTokenPort {
    private final JwtProperties jwtProperties;
    private final MemberJpaRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Token generateToken(Long id) {
        return new Token(generateAccessToken(id),generateRefreshToken(id));
    }

    @Override
    public String generateAccessToken(Long id) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "ACCESS")
                .setSubject(id.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExpire()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();    }

    @Override
    public String generateRefreshToken(Long id) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "REFRESH")
                .setSubject(id.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExpire()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    @Override
    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);

        Member member = memberMapper.mapToDomainEntity(memberRepository.findById(Long.valueOf(claims.getSubject()))
                .orElseThrow(()-> MemberNotFoundException.EXCEPTION));

        CustomUserDetails details = new CustomUserDetails(member);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());    }

    @Override
    public String resolveToken(HttpServletRequest request) {
        return null;
    }

    @Override
    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecret()).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e){
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
