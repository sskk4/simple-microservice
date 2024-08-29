package com.seba.jwt_security.config;

import com.seba.jwt_security.user.Role;
import com.seba.jwt_security.user.User;
import lombok.*;

import java.security.Principal;

@Data
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomPrincipal implements Principal {
    private String name; // email
    private Long userId;
    private Role role;

    @Override
    public String getName() {
        return name;
    }

    public CustomPrincipal(User user) {
        this.userId = user.getId();
        this.name = user.getEmail();
        this.role = user.getRole();
    }
}