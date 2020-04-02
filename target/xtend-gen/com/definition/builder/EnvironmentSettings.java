package com.definition.builder;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

@SuppressWarnings("all")
public class EnvironmentSettings {
  public static class Builder {
    public static EnvironmentSettings build() {
      try {
        final EnvironmentSettings settings = new EnvironmentSettings();
        Constructor _constructor = new Constructor();
        final Yaml yaml = new Yaml(_constructor);
        try (final InputStream stream = EnvironmentSettings.class.getClassLoader().getResourceAsStream("config.yaml")) {
          Object _load = yaml.<Object>load(stream);
          EnvironmentSettings.value = ((Map<String, String>) _load);
          EnvironmentSettings.log.info(EnvironmentSettings.value);
        }
        return settings;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  private static final Logger log = Logger.getLogger(EnvironmentSettings.class.getName());
  
  public EnvironmentSettings() {
  }
  
  private static Map<String, String> value;
  
  public Optional<String> getFile() {
    return Optional.<String>ofNullable(EnvironmentSettings.value.get("file"));
  }
}
