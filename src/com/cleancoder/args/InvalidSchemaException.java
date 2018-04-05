package com.cleancoder.args;

import java.util.Objects;

/**
 * This exception is thrown when the schema is invalid.
 */
public class InvalidSchemaException extends RuntimeException {
    private static final long serialVersionUID = 1L;    
    private final ErrorCode errorCode;
    private final char argument;    
    private final String schemaTail;
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public char getArgument() {
        return argument;
    }

    public String getSchemaTail() {
        return schemaTail;
    }

    public InvalidSchemaException(final ErrorCode errorCode, final char argument, final String schemaTail) {
        Objects.requireNonNull(errorCode);
        Objects.requireNonNull(schemaTail);
        this.errorCode = errorCode;
        this.argument = argument;
        this.schemaTail = schemaTail;
    }
    
    public String errorMessage() {
        return String.format(errorCode.getErrorMessage(), argument, schemaTail);
    }
    
    public enum ErrorCode {
        UNSUPPORTED_SCHEMA_TYPE("Argument -%c has an invalid schema type '%s'.");
        
        private String errorMessage;
        
        ErrorCode(final String errorMessage) {
            this.errorMessage = errorMessage;
        }
        
        public String getErrorMessage() {
            return this.errorMessage;
        }
    } 
}
