/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author syst3m
 */
/**
 * <code>RejectException</code> is an exception class for rejecting a request.
 *
 *
 */
@SuppressWarnings("serial")
public class RejectException extends Exception {

    /**
     * Constructs an empty exception
     */
    public RejectException() {
    }

    /**
     * Constructs an exception with a message.
     *     
* @param message - The error message
     */
    public RejectException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with a cause
     *     
* @param cause - Cause of the error
     */
    public RejectException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an exception with a message and cause.
     *     
* @param message - The error message.
     * @param cause - The cause of the error
     */
    public RejectException(String message, Throwable cause) {
        super(message, cause);
    }
}
