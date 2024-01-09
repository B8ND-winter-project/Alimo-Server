package com.b1nd.alimoserver.global.infra.security;

import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public record CustomUserDetails(Member member) implements UserDetails {
    @Override
    public String getUsername() {
        return member.name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(() -> member.role().getKey());
        return collections;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
