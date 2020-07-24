package com.julianduru.security.exception;


/**
 * created by julian
 */
public class NoAuthenticatedUserException extends RuntimeException {


    public NoAuthenticatedUserException() {
    }

    public NoAuthenticatedUserException(String message) {
        super(message);
    }

    public NoAuthenticatedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAuthenticatedUserException(Throwable cause) {
        super(cause);
    }

    public NoAuthenticatedUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
