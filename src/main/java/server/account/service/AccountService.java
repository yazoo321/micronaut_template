package server.account.service;

import com.org.mmo_server.repository.model.tables.pojos.Users;
import server.account.dto.Account;
import server.account.repository.AccountRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public Account fetchAccount(String username) {
        Users user = accountRepository.fetchByUsername(username);

        if (null == user) {
            return new Account();
        }
        return new Account(user.getUsername(), user.getEmail());
    }
}
