package ru.codemark.test.codemark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTORoles extends UserDto{

    private String[] name;

}