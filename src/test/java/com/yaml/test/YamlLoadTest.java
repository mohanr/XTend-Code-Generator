package com.yaml.test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.definition.builder.EnvironmentSettings;

@DisplayName("Test to load the YAML configuration file from resources")
public class YamlLoadTest {
	
	@Test
	public void yamlLoad() {
		assertNotNull(EnvironmentSettings.Builder.build().getFile());
		assertTrue(EnvironmentSettings.Builder.build().getFile() instanceof Optional);
		//assertEquals(EnvironmentSettings.Builder.build().getFile().get(),"Data-Definition.csv");
	}

}
