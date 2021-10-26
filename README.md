## Micronaut + Postgres (on docker) + Jooq + Flyway + Lombok template

Postgres, Jooq and Flyway described and shown in YouTube tutorial here:
https://www.youtube.com/watch?v=PF_Bg6CgMts&t=16s

JWT Authentication described here on YouTube tutorial here:
https://www.youtube.com/watch?v=acAFcDWuxhI&t=8s

## Getting started

In order to build the project run:
`./gradlew build`

In order to remove the docker container and its database, run
`docker rm -f -v <container_name>`

This project is a base template for getting started with 
micronaut + postgres + jooq + flyway + lombok.

It contains a very simple migration file (`resources/db/postgres/V1__create_user_table.sql`) 
to create a base users table and 
an entry with a user. Modify this based on your requirements.

### Authentication
In order to register you can make a `POST` API request to `{{api_url}}/register`
with body of 
```$xslt
{
    "username": "username",
    "email": "email@test.com",
    "password": "password"
}
```
where the `{{api_url}}` can be set to `localhost:8081`.
The port can be configured in `application.yml` configuration file.

This functionality is configured in `UnsecuredAccountController`

In order to sign in, make a `POST` request to `{{api_url}}/login` with body of:
```$xslt
{
    "username": "username",
    "password": "password"
}
```

This functionality comes directly from Micronaut, it can be configured in `application.yml`

## Test controllers
- There's a very basic `HelloWorldController` which simply demonstrates micronaut controller
- There's also a `@Secured` controller which is the `AccountController`
- There's also unsecured controller which is the `UnsecuredAccountController` to handle things like register

## Micronaut 2.4.1 Documentation

- [User Guide](https://docs.micronaut.io/2.4.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.4.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.4.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)
