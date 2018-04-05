package com.cleancoder.args;

import java.util.Iterator;

public interface ArgumentMarshaler {
  void set(Iterator<String> argumentValue, final char argument);
}
