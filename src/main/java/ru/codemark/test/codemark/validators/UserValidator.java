package ru.codemark.test.codemark.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.codemark.test.codemark.entities.User;


@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,50}";
        if (!user.getPassword().matches(pattern)) {
            errors.reject("404","password is not corrected");
        }

        if (user.getLogin().length() < 3 || user.getLogin().length() > 50){
            errors.reject("404","user name is not corrected");
        }

        if (user.getLogin().length() < 3 || user.getLogin().length() > 50){
            errors.reject("404","user name is not corrected");
        }

    }
}