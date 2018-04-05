package com.cleancoder.args;

import java.util.Objects;

/**
 * This exception is thrown when the arguments are invalid.
 */
public class InvalidArgumentException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final char argument;
    private final ErrorCode errorCode;
    
    public char getArgument() {
        return argument;
    }    
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }    

    public InvalidArgumentException(final ErrorCode errorCode, final char argument) {
        Objects.requireNonNull(errorCode);
        this.errorCode = errorCode;
        this.argument = argument;
    }
    
    public String errorMessage() {
        return String.format(errorCode.getErrorMessage(), argument);

    }    
    
    public enum ErrorCode {
        UNEXPECTED_ARGUMENT("Argument -%c unexpected."),
        INVALID_ARGUMENT_NAME("'%c' is not a valid argument name."),
        MISSING_STRING("Could not find string parameter for -%c."),
        MISSING_INTEGER("Could not find integer parameter for -%c."),
        MISSING_DOUBLE("Could not find double parameter for -%c."),
        MALFORMED_MAP("Map string for -%c is not of form k1:v1,k2:v2..."),
        MISSING_MAP("Could not find map string for -%c."),
        INVALID_INTEGER("Argument -%c must be an integer."),
        INVALID_DOUBLE("Argument -%c must be an double.");
        
        private String errorMessage;
        
        ErrorCode(final String errorMessage) {
            this.errorMessage = errorMessage;
        }
        
        public String getErrorMessage() {
            return this.errorMessage;
        }
    }    
}
