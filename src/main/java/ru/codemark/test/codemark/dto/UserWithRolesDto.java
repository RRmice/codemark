package ru.codemark.test.codemark.dto;

import lombok.Data;
import ru.codemark.test.codemark.entities.Role;

import java.util.Collection;

@Data
public class UserWithRolesDto {

    private String login;
    private String name;
    private String password;
    private Collection<Role> roles;

}