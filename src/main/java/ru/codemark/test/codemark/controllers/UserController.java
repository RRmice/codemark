package ru.codemark.test.codemark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.codemark.test.codemark.data.UserAnswer;
import ru.codemark.test.codemark.dto.UserDto;
import ru.codemark.test.codemark.entities.User;
import ru.codemark.test.codemark.mappes.UserMapper;
import ru.codemark.test.codemark.services.UserService;
import ru.codemark.test.codemark.validators.UserValidator;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator){
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(UserMapper.MAPPER.fromUserList(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUser(@RequestParam("login") String login){
        return new ResponseEntity<>(userService.getUserByLogin(login), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@ModelAttribute(name = "user") User user, BindingResult result){

        HttpStatus httpStatus;
        UserAnswer userAnswer = new UserAnswer();

        userValidator.validate(user, result);
        if (result.hasErrors()){
           List<String> errors = new ArrayList<>();
            for (ObjectError oe: result.getAllErrors()) {
                errors.add(oe.getCode());
            }

            userAnswer.setErrors(errors);
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {

            try {
                userService.createNewUser(user);
                httpStatus = HttpStatus.CREATED;
            } catch (Exception e) {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                userAnswer.setError(e.toString());
            }
        }


        return new ResponseEntity<>(userAnswer, httpStatus);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("login") String login){
        userService.deleteUserByLogin(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateUser(@ModelAttribute(name = "user") User user){
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

}