package com.definition.builder;

import com.definition.builder.IteratorBuilder;
import com.google.common.collect.AbstractIterator;
import com.google.common.io.LineReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class DefinitionBuilder {
  private final String filterRootObject = "(.*)\\d{1,2}[a-zA-Z](.*) to(.*)\\d{1,2}[a-zA-Z](.*),(?:.*\n){1,9}";
  
  private Pattern pattern = Pattern.compile(this.filterRootObject);
  
  private IteratorBuilder builder = null;
  
  private static String line = null;
  
  public DefinitionBuilder buildFileIterator() {
    try {
      final FileReader reader = new FileReader("D:/eclipse-jee-2019-12-M1-win32-x86_64/Data-Definition.csv");
      final LineReader lineReader = new LineReader(reader);
      final AbstractIterator<String> _function = new AbstractIterator<String>() {
        @Override
        protected String computeNext() {
          try {
            String _xblockexpression = null;
            {
              final String result = lineReader.readLine();
              String _xifexpression = null;
              if ((result != null)) {
                final Matcher m = DefinitionBuilder.this.pattern.matcher(result);
                while (m.find()) {
                  return m.group();
                }
              } else {
                _xifexpression = this.endOfData();
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final AbstractIterator<String> lineIterator = _function;
      Optional<AbstractIterator<String>> _of = Optional.<AbstractIterator<String>>of(lineIterator);
      IteratorBuilder _iteratorBuilder = new IteratorBuilder(_of);
      this.builder = _iteratorBuilder;
      return this;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String next() {
    return this.builder.next();
  }
  
  public static void main(final String[] args) {
    final DefinitionBuilder definitionBuilder = new DefinitionBuilder();
    final DefinitionBuilder dataIterator = definitionBuilder.buildFileIterator();
    do {
      {
        DefinitionBuilder.line = dataIterator.next();
        InputOutput.<String>println((("File contents [" + DefinitionBuilder.line) + "]"));
      }
    } while((DefinitionBuilder.line != null));
  }
}
