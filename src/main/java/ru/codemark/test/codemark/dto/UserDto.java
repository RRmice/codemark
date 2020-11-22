package ru.codemark.test.codemark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

        private String login;
        private String name;
        private String password;

}
