package ru.codemark.test.codemark.data;

import lombok.Getter;

@Getter
public class UserAnswerSimple implements UserAnswer {

    private boolean success;

    public UserAnswerSimple() {
        this.success = true;
    }

}

