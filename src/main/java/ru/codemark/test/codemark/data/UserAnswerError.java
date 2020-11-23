package ru.codemark.test.codemark.data;

import java.util.ArrayList;
import java.util.List;

public class UserAnswerError extends UserAnswerSimple {

    List<String> errors;

    public UserAnswerError() {
        super(false);
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