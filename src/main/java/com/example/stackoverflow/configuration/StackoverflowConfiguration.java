package com.example.stackoverflow.configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StackoverflowConfiguration{

	@NotEmpty
    private String baseUrl;

    @NotEmpty
    private Integer suffixNumber;
    
    @NotEmpty
    private Integer readingStep;

    @JsonProperty
	public String getBaseUrl() {
		return baseUrl;
	}

    @JsonProperty
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

    @JsonProperty
	public Integer getSuffixNumber() {
		return suffixNumber;
	}

    @JsonProperty
	public void setSuffixNumber(Integer suffixNumber) {
		this.suffixNumber = suffixNumber;
	}

    @JsonProperty
	public Integer getReadingStep() {
		return readingStep;
	}

    @JsonProperty
	public void setReadingStep(Integer readingStep) {
		this.readingStep = readingStep;
	}
    
    


}
