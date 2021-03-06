/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package controller;

/**
 * RejectException is an exception class for rejecting a request.
 *
 * @author Group 20
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
