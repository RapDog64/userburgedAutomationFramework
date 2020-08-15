package ru.userbugred.service;

import ru.userbugred.config.DataEnvironmentManager;
import ru.userbugred.model.User;

public class UserManager {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    public static User withFullCredentials() {
        return new User(DataEnvironmentManager.getTestData(NAME),
                DataEnvironmentManager.getTestData(EMAIL),
                DataEnvironmentManager.getTestData(PASSWORD));
    }
}
