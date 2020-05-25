package com.zzk.atcrowdfunding.exception;


/*
* 登录失败执行的异常
* */
public class LoginFailedException extends RuntimeException{

    public static final long SERIALVERSIONID = 1L;
    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
