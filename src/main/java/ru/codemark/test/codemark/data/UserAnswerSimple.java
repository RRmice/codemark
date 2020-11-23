package ru.codemark.test.codemark.data;

public class UserAnswerSimple implements UserAnswer{
    private boolean success;

    protected UserAnswerSimple(boolean success) {
        this.success = success;
    }

    public UserAnswerSimple(){
        this.success = true;
    }

    public boolean isSuccess(){
        return this.success;
    }

}

