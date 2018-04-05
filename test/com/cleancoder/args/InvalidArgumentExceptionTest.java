package com.cleancoder.args;

import static com.cleancoder.args.InvalidArgumentException.ErrorCode.INVALID_ARGUMENT_NAME;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.MALFORMED_MAP;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.MISSING_DOUBLE;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.MISSING_INTEGER;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.MISSING_MAP;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.MISSING_STRING;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.UNEXPECTED_ARGUMENT;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.INVALID_INTEGER;
import static com.cleancoder.args.InvalidArgumentException.ErrorCode.INVALID_DOUBLE;
import junit.framework.TestCase;

public class InvalidArgumentExceptionTest extends TestCase {
    public void testUnexpectedMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(UNEXPECTED_ARGUMENT, 'x');
        assertEquals("Argument -x unexpected.", e.errorMessage());
    }

    public void testMissingStringMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(MISSING_STRING, 'x');
        assertEquals("Could not find string parameter for -x.", e.errorMessage());
    }

    public void testMissingIntegerMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(MISSING_INTEGER, 'x');
        assertEquals("Could not find integer parameter for -x.", e.errorMessage());
    }

    public void testMissingDoubleMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(MISSING_DOUBLE, 'x');
        assertEquals("Could not find double parameter for -x.", e.errorMessage());
    }

    public void testMissingMapMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(MISSING_MAP, 'x');
        assertEquals("Could not find map string for -x.", e.errorMessage());
    }

    public void testMalformedMapMessage() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(MALFORMED_MAP, 'x');
        assertEquals("Map string for -x is not of form k1:v1,k2:v2...", e.errorMessage());
    }

    public void testInvalidArgumentName() throws Exception {
        final InvalidArgumentException e = new InvalidArgumentException(INVALID_ARGUMENT_NAME, '#');
        assertEquals("'#' is not a valid argument name.", e.errorMessage());
    }
    
    public void testInvalidIntegerMessage() throws Exception {
        InvalidArgumentException e = new InvalidArgumentException(INVALID_INTEGER, 'x');
        assertEquals("Argument -x must be an integer.", e.errorMessage());
    }

    public void testInvalidDoubleMessage() throws Exception {
        InvalidArgumentException e = new InvalidArgumentException(INVALID_DOUBLE, 'x');
        assertEquals("Argument -x must be an double.", e.errorMessage());
    }    
}
