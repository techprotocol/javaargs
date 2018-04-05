package com.cleancoder.args;

import static com.cleancoder.args.InvalidArgumentException.ErrorCode.*;

import java.util.*;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
  private int intValue = 0;

  public void set(Iterator<String> argumentValue, final char argument) {
    String parameter = null;
    try {
      parameter = argumentValue.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new InvalidArgumentException(MISSING_INTEGER, argument);
    } catch (NumberFormatException e) {
      throw new InvalidArgumentException(INVALID_INTEGER, argument);
    }
  }

  public static int getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof IntegerArgumentMarshaler)
      return ((IntegerArgumentMarshaler) am).intValue;
    else
      return 0;
  }
}
