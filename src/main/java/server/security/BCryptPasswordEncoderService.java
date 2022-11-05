package server.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.inject.Singleton;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Singleton
public class BCryptPasswordEncoderService implements PasswordEncoder {

    PasswordEncoder delegate = new BCryptPasswordEncoder();

    @Override
    public String encode(@NotBlank @NotNull CharSequence rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean matches(@NotBlank @NotNull CharSequence rawPassword,
                           @NotBlank @NotNull String encodedPassword) {
        return delegate.matches(rawPassword, encodedPassword);
    }
}