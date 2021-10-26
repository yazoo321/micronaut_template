package server.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
public class HelloWorldController {
    // This is a simple test controller which is unsecured
    // have a look at `AccountController` for a secured example

    @Get("/hello-world")
    public String getAccountByUsername() {
        // to call this method, make a GET API request to: localhost:8081/hello-world

        return "Hello world!";
    }

}
