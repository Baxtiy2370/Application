package uz.b.application.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


public class AuthUserFactory {

    public static AuthUser create(UUID uuid,
                                  String username,
                                  String password,
                                  Boolean finished,
                                  Boolean blocked,
                                  Set<String> permissions) {
        return new AuthUser(
                uuid,
                username,
                password,
                finished,
                blocked,
                mapToGrantedAuthorities(permissions)
        );
    }


    private static Collection<GrantedAuthority> mapToGrantedAuthorities(Set<String> permissions) {
        return permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
