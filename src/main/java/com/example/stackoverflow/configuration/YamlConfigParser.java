package com.example.stackoverflow.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Component
public class YamlConfigParser {

	public static StackoverflowConfiguration yamlParser(@NonNull final File file)
			throws IOException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		if (!file.exists()) {
			throw new FileNotFoundException("Could not file config file at " + file);
		}
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		return mapper.readValue(file, StackoverflowConfiguration.class);
	}

	public static void writeConfig(@NonNull final File file,
			@NonNull final StackoverflowConfiguration config) throws IOException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.writeValue(file, config);
	}

}
