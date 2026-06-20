package com.back.global.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SecurityUser extends User {
    private final int id;
    private final String name;

    public SecurityUser(
            int id,
            String username,
            String password,
            String name,
            //사용자가 어떤 권한을 가지고 있는지 나타내는 데이터 타입
            Collection<? extends GrantedAuthority> authorities
    ) {
        super(username, password, authorities);
        this.id = id;
        this.name = name;
    }
}