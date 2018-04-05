package com.cleancoder.args;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.cleancoder.args.InvalidArgumentException.ErrorCode.*;

public class MapArgumentMarshaler implements ArgumentMarshaler {
  private Map<String, String> map = new HashMap<>();

  public void set(Iterator<String> argumentValue, final char argument) {
    try {
      String[] mapEntries = argumentValue.next().split(",");
      for (String entry : mapEntries) {
        String[] entryComponents = entry.split(":");
        if (entryComponents.length != 2)
          throw new InvalidArgumentException(MALFORMED_MAP, argument);
        map.put(entryComponents[0], entryComponents[1]);
      }
    } catch (NoSuchElementException e) {
      throw new InvalidArgumentException(MISSING_MAP, argument);
    }
  }

  public static Map<String, String> getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof MapArgumentMarshaler)
      return ((MapArgumentMarshaler) am).map;
    else
      return new HashMap<>();
  }
}
