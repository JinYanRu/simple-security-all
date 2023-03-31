package com.raza.simplesecurity.core;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/27
 */
public class AuthenticationException extends RuntimeException{

    public AuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public AuthenticationException(String msg) {
        super(msg);
    }
}
