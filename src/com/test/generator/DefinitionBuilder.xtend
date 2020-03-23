package com.test.generator

import com.google.common.collect.AbstractIterator
import com.google.common.io.LineReader
import java.io.FileReader
import java.util.Optional
import java.util.regex.Pattern

class DefinitionBuilder {
  
  val filterRootObject = "(.*)\\d{1,2}[a-zA-Z](.*),(.*)"
	
  Pattern pattern = Pattern.compile(filterRootObject);
  
  IteratorBuilder builder = null
  
  static String line = null
  
  
  def DefinitionBuilder buildFileIterator(){
  	
//  	try(		
  	    val reader = new FileReader('D:/eclipse-jee-2019-12-M1-win32-x86_64/Data-Definition.csv')//){
        val lineReader = new LineReader(reader);
        val AbstractIterator<String> lineIterator = [|
			val result = lineReader.readLine 
			if( result !== null ){
				val m =pattern.matcher(result)
				if(m.matches()){
					return result
				}	
				
			}else
			    self.endOfData 
		  ]
  	     builder = new IteratorBuilder(Optional.of(lineIterator));
//  	    }  		
  	    return this
  }
  
  def String next(){
  		return builder.next();
  }
  
  	def static void main(String[] args) {
		val definitionBuilder = new DefinitionBuilder
		val dataIterator = definitionBuilder.buildFileIterator()
		do {
			line = dataIterator.next()
 		    println('File contents [' + line + ']')
		}while( line !== null )
  
    }
}
   class IteratorBuilder{
  	
   var AbstractIterator<String> lineIterator = null;
  	
  	new ( Optional<AbstractIterator<String>> fileIterator ){
  		this.lineIterator = fileIterator.get();
  	}
  	
  	 def String next(){
  	 	if( lineIterator.hasNext()){
  	 		
	  	   return lineIterator.next()
  	 	}
  	}
				
  }
