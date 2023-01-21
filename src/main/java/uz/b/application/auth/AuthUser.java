package uz.b.application.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
public class AuthUser implements UserDetails {

    private final UUID uuid;
    private final String username;
    private final String password;
    private final Boolean finished;
    private final Boolean blocked;
    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser(UUID uuid,
                    String username,
                    String password,
                    Boolean finished,
                    Boolean blocked,
                    Collection<? extends GrantedAuthority> authorities)
    {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.finished = finished;
        this.blocked = blocked;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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
