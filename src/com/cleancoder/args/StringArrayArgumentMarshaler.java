package com.cleancoder.args;

import static com.cleancoder.args.InvalidArgumentException.ErrorCode.*;

import java.util.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
  private List<String> strings = new ArrayList<String>();

  public void set(Iterator<String> currentArgument, final char argument) {
    try {
      strings.add(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new InvalidArgumentException(MISSING_STRING, argument);
    }
  }

  public static String[] getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof StringArrayArgumentMarshaler)
      return ((StringArrayArgumentMarshaler) am).strings.toArray(new String[0]);
    else
      return new String[0];
  }
}
