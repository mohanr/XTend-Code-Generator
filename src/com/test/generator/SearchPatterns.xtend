package com.definition.builder

import java.util.regex.Matcher
import java.util.regex.Pattern
import org.apache.log4j.Logger

class SearchPatterns {
	
	 //static Logger log = null;// = Logger.getLogger(SearchPatterns.getName());

        new () {
        }

        /**
         * An search pattern
         *
         * @param pattern the expected pattern to be matched
         * @return the matched text
         */
        def static String locatePattern(String pattern, int noOfLines,  String text) {
            val patternMatch = [|
                val Pattern p = Pattern.compile( pattern + "(?:.*\n){1," + noOfLines + "}" )
                val Matcher m = p.matcher(text)
                if ( m.find() )
                	return m.group()
            ]
            return patternMatch.apply()
       }
	
	
}
