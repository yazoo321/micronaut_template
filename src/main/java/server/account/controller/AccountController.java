package server.account.controller;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import server.account.dto.Account;
import server.account.service.AccountService;

import javax.inject.Inject;

@Controller("/account")
public class AccountController {

    @Inject
    AccountService accountService;

    @Get("/get-user")
    public Account getAccountByUsername(@Parameter String username) {
        return accountService.fetchAccount(username);
    }
}
