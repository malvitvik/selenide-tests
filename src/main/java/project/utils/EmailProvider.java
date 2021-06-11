package project.utils;

import java.util.Random;

import com.google.inject.Provider;
import org.apache.commons.lang3.RandomStringUtils;

public class EmailProvider implements Provider<String> {
	
	protected String domain = "@email.at";

	@Override 
	public String get() {
		return RandomStringUtils.randomAlphanumeric(10) + domain;
	}
}
