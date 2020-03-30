package com.pattern.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.definition.builder.SearchPatterns;

@DisplayName("Pattern match Test with a CSV file")
class PatternTest {

	private String filter;
	
	private String text;
	
	private static Logger log = Logger.getLogger(PatternTest.class.getName());

	
	@BeforeEach
	public void setUp() {
		filter = "(.*)\\d{1,2}[a-zA-Z](.*)";
	    
	    text =  "Version:,1.2,,,,,,,,,,,,,\n" +
	    		"Date:,20 July 2015,,,,,,,,,,,,,\n" +
	    		"Blue,Green\n" +
	    		",,,,,,,,,,,,,,\n" +
	    		"Blue,Green\n" +
	    		",,,,,,,,,,,,,,\n" +
	    		"Blue,Green\n" +
				"1A to 4A,Option Strike,,OptionStrike,,,,,,,,,,,\n"+
				"1A,The currency in which the option strike is denominated,,,,currency,,,,,(Optional)Mon,,,,\n" +
				"2A,The price or level expressed as a percentage of the forward starting spot price.,,,,percentage,,,,,(Optional)Decimal,,,,\n" +
				"3A,Price,,,,(Optional)price,,,,,(Optional)Decimal,,,,\n"+
				"4A,Spread,,,,spread,,,,,(Optional)Decimal,,,,\n"+
	    		"Blue,Green\n" +
	    		"Blue,Green\n" +
	    		"Blue,Green\n" +
	    		"Blue,Green\n" +
	    		"Blue,Green\n";


	}
	
	
	@Test
	void pattern() {
	    Pattern p = Pattern.compile( "(.*)\\d{1,2}[a-zA-Z](.*)(?:.*){1,4}" );
	    Matcher m = p.matcher(text);
	    while ( m.find() )
            log.info(m.group());

	}

	
	@Test
	void locatePattern() {
		assertNotNull(SearchPatterns.locatePattern(filter, 4, text));
        log.info(SearchPatterns.locatePattern(filter, 4, text));
		assertEquals(SearchPatterns.locatePattern(filter, 4, text),
				String.format("1A to 4A,Option Strike,,OptionStrike,,,,,,,,,,,","%n") +
				String.format("1A,The currency in which the option strike is denominated,,,,currency,,,,,(Optional)Mon,,,,","%n") +
				String.format("2A,The price or level expressed as a percentage of the forward starting spot price.,,,,percentage,,,,,(Optional)Decimal,,,,","%n") +
				String.format("3A,Price,,,,(Optional)price,,,,,(Optional)Decimal,,,,","%n") +
				String.format("4A,Spread,,,,spread,,,,,(Optional)Decimal,,,,","%n"));
				     
	}

}
