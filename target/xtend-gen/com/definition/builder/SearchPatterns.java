package com.definition.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class SearchPatterns {
  private static final Logger log = Logger.getLogger(SearchPatterns.class.getName());
  
  public SearchPatterns() {
  }
  
  /**
   * A search pattern
   * 
   * @param pattern the expected pattern to be matched
   * @return the matched text
   */
  public static String locatePattern(final String pattern, final int noOfLines, final String text) {
    SearchPatterns.log.info((((pattern + "(?:.*\n){1,") + Integer.valueOf(noOfLines)) + "}"));
    final Function0<String> _function = () -> {
      final Pattern p = Pattern.compile((((pattern + "(?:.*){1,") + Integer.valueOf(noOfLines)) + "}"));
      final Matcher m = p.matcher(text);
      final StringBuilder sb = new StringBuilder();
      while (m.find()) {
        sb.append(String.format(m.group(), "%n"));
      }
      return sb.toString();
    };
    final Function0<String> patternMatch = _function;
    return patternMatch.apply();
  }
}
