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
            String name,
            //사용자가 어떤 권한을 가지고 있는지 나타내는 데이터 타입
            Collection<? extends GrantedAuthority> authorities
    ) {
        // 우리의 시나리오(REST API)에서는 이 객체의 비밀번호 필드를 활용할 일이 없다.
        super(username, "", authorities);
        this.id = id;
        this.name = name;
    }
}