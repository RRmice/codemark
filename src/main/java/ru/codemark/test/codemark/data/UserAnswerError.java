package ru.codemark.test.codemark.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserAnswerError implements UserAnswer {

    private boolean success;
    private List<String> errors;

    public UserAnswerError() {
        success = false;
        errors = new ArrayList<>();
    }

    public UserAnswerError setErrors(List<String> errors){
        this.errors = errors;
        return this;
    }

    public UserAnswerError setError(String error){
        errors.add(error);
        return this;
    }
}