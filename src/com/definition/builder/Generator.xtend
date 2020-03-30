package com.definition.builder

class Generator {

 	static String line
	
	def generateBody(String name, String body) '''
		/* body of «name» */
		«body»
	'''

	def generateMethod(String name, String body) '''
		public void «name»() {
			«generateBody(name, body)»
		}
	'''
	def static void main(String[] args) {
		val definitionBuilder = new DefinitionBuilder
		val dataIterator = definitionBuilder.buildFileIterator()
		do {
			line = dataIterator.next()
 		    println('File contents [' + line + ']')
		}while( line !== null )
		
		val generator = new Generator
		println(generator.generateMethod("m",
			'''
				return;
			'''
		))
	}
	
}