package com.definition.builder

import java.util.regex.Matcher
import java.util.regex.Pattern
import org.apache.log4j.Logger


class SearchPatterns {
	
	val static log = Logger::getLogger(SearchPatterns.getName());

        new () {
        }

        /**
         * A search pattern
         *
         * @param pattern the expected pattern to be matched
         * @return the matched text
         */
        def static String locatePattern(String pattern, int noOfLines,  String text) {
            log.info(pattern + "(?:.*\n){1," + noOfLines + "}")
            val patternMatch = [|
                val Pattern p = Pattern.compile( pattern + "(?:.*){1," + noOfLines + "}" )
                val Matcher m = p.matcher(text)
                val sb = new StringBuilder();
                while ( m.find() )
                	sb.append(String.format(m.group(),"%n")  ) 
                return sb.toString()
            ]
            return patternMatch.apply()
       }
	
	
}
