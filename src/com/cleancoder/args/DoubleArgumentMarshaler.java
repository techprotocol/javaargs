package com.cleancoder.args;

import static com.cleancoder.args.InvalidArgumentException.ErrorCode.*;

import java.util.*;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
  private double doubleValue = 0;

  public void set(Iterator<String> argumentValue, final char argument) {
    String parameter = null;
    try {
      parameter = argumentValue.next();
      doubleValue = Double.parseDouble(parameter);
    } catch (NoSuchElementException e) {
      throw new InvalidArgumentException(MISSING_DOUBLE, argument);
    } catch (NumberFormatException e) {
      throw new InvalidArgumentException(INVALID_DOUBLE, argument);
    }
  }

  public static double getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof DoubleArgumentMarshaler)
      return ((DoubleArgumentMarshaler) am).doubleValue;
    else
      return 0.0;
  }
}
