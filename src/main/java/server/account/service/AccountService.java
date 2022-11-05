package server.account.service;

import com.org.micronaut_template.repository.model.tables.pojos.Users;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import server.account.dto.Account;
import server.account.dto.RegisterDto;
import server.account.repository.AccountRepository;
import server.security.BCryptPasswordEncoderService;

import java.time.LocalDateTime;

@Singleton
public class AccountService {

    @Inject
    BCryptPasswordEncoderService bCryptPasswordEncoderService;

    @Inject
    AccountRepository accountRepository;

    public Account fetchAccount(String username) {
        Users user = accountRepository.fetchByUsername(username);

        if (null == user) {
            return new Account();
        }
        return new Account(user.getUsername(), user.getEmail());
    }


    public Account registerUser(RegisterDto registerDto) {
        try {
            String encodedPassword = bCryptPasswordEncoderService.encode(registerDto.getPassword());

            LocalDateTime now = LocalDateTime.now();
            Users user = new Users();
            user.setEmail(registerDto.getEmail());
            user.setUsername(registerDto.getUsername());
            // ensure password is encoded. Can be done on repo level instead.
            user.setPassword(encodedPassword);
            user.setEnabled(true);
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            user.setLastLoggedInAt(now);

            accountRepository.createUser(user);

            Account account = new Account();
            account.setEmail(user.getEmail());
            account.setUsername(user.getUsername());

            return account;
        } catch (Exception e) {
            // log exception in future
            return new Account();
        }

    }
}
