package ru.kpfu.testing.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static final String FILE_NAME = "src/test/resources/test.properties";

    private static String baseUrl;
    private static String login;
    private static String password;
    private static String accountUrl;
    private static String boardUrl;
    private static Properties properties;

    static {
        try {
            InputStream inputStream = new FileInputStream(FILE_NAME);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = properties.getProperty("base.url");
        }
        return baseUrl;
    }

    public static String getAccountUrl() {
        if (accountUrl == null) {
            accountUrl = properties.getProperty("account.url");
        }
        return accountUrl;
    }

    public static String getBoardUrl() {
        if (boardUrl == null) {
            boardUrl = properties.getProperty("board.url");
        }
        return boardUrl;
    }

    public static String getlogin() {
        if (login == null) {
            login = properties.getProperty("login");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = properties.getProperty("password");
        }
        return password;
    }
}
