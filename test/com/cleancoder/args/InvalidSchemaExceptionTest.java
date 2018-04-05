package com.cleancoder.args;

import static com.cleancoder.args.InvalidSchemaException.ErrorCode.UNSUPPORTED_SCHEMA_TYPE;

import junit.framework.TestCase;

public class InvalidSchemaExceptionTest extends TestCase {

    public void testInvalidFormat() throws Exception {
        InvalidSchemaException e = new InvalidSchemaException(UNSUPPORTED_SCHEMA_TYPE, 'x', "$");
        assertEquals("Argument -x has an invalid schema type '$'.", e.errorMessage());
        System.out.println(e.errorMessage());
    }
}
