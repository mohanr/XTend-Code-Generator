package com.test.generator

import com.google.common.collect.AbstractIterator
import com.google.common.io.LineReader
import java.io.FileReader
import java.util.Optional

class DefinitionBuilderTest {
   
  IteratorBuilderTest builder = null
  
  static String line = null
  
  
  def DefinitionBuilderTest buildFileIterator(){
  	
  	//try(		
  	    val reader = new FileReader('D:/eclipse-jee-2019-12-M1-win32-x86_64/text.txt')//){

        val AbstractIterator<String> lineIterator = [|
        val lineReader = new LineReader(reader)
			val result = lineReader.readLine 
			if (result === null)
				self.endOfData
			return result
		  ]
  	     builder = new IteratorBuilderTest(Optional.of(lineIterator));
  	    //}  		
  	    return this
  }
  
  def String next(){
  		return builder.next();
  }
  
  	def static void main(String[] args) {
		val definitionBuilder = new DefinitionBuilderTest
		val dataIterator = definitionBuilder.buildFileIterator()
		do {
			line = dataIterator.next()
 		    println('File contents [' + line + ']')
		}while( line !== null )
  
    }
 }
    

   class IteratorBuilderTest{
  	
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
