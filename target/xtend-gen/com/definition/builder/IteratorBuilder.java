package com.definition.builder;

import com.google.common.collect.AbstractIterator;
import java.util.Optional;

@SuppressWarnings("all")
public class IteratorBuilder {
  private AbstractIterator<String> lineIterator = null;
  
  public IteratorBuilder(final Optional<AbstractIterator<String>> fileIterator) {
    this.lineIterator = fileIterator.get();
  }
  
  public String next() {
    boolean _hasNext = this.lineIterator.hasNext();
    if (_hasNext) {
      return this.lineIterator.next();
    }
    return null;
  }
}
