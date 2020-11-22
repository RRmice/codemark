package ru.codemark.test.codemark.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserAnswer {
    private boolean success = true;
    List<String> errors = new ArrayList<>();

    public void setErrors(List<String> errors){
        errors.forEach(error -> this.errors.add(error));

        if (errors.size() > 0) {
            success = false;
        }

    }

    public void setError(String error){
       // errors.add()
    }
}