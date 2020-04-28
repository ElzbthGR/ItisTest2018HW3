package ru.kpfu.testing.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AccountData {

    private String login;
    private String password;
}
