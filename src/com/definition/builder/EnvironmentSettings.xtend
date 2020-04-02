package com.definition.builder

import java.util.Map
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.util.Optional
import org.apache.log4j.Logger

class EnvironmentSettings {

 		val static log = Logger::getLogger(EnvironmentSettings.getName());
        
 
        new  () {
        }

		static Map<String, String> value

        def Optional<String> getFile(){
            return Optional.ofNullable(value.get("file")) ;
        }

         static class Builder{
									
	
         def static EnvironmentSettings build(){
	            val EnvironmentSettings settings = new EnvironmentSettings()
	                        
	  			val yaml = new Yaml(new Constructor());	
	  			try(val stream = EnvironmentSettings.getClassLoader().getResourceAsStream("config.yaml")){
	  				 value =  yaml.load(stream) as Map<String, String>
                     log.info( value)
	  			}
	            
	            return settings
	        }
    }
}
