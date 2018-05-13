package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	private static final String VALID_NAME_REGEX ="^[A-Za-z0-9 /]{3,25}$";
	private static final String VALID_NAME_SEARCH_REGEX ="^[A-Za-z0-9 /]{3,25}$";
	private static final String VALID_TEXT_SIZE_REGEX = "^[A-Za-z @.]{1,40}$";
	private static final String VALID_ID_REGEX ="^[0-9]{1,7}$";
	private static final String VALID_CREDENTIALS_REGEX ="^[A-Za-z0-9.-]{4,18}$";
	private static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,12}$";
	private static final String VALID_YEAR_REGEX = "^(19[6789]\\d|20[01]\\d)";
	private static final String VALID_SONG_NUM_REGEX = "^[1-9]{1,2}";
	
	public static boolean isValidName(String credentials){
		Pattern credentialsPattern = Pattern.compile(VALID_NAME_REGEX);
		Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
		return credentialsMatcher.find();
	}
	public static boolean isValidSongNumb(String credentials){
		Pattern credentialsPattern = Pattern.compile(VALID_SONG_NUM_REGEX);
		Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
		return credentialsMatcher.find();
	}
	public static boolean isValidYear(String credentials){
		Pattern credentialsPattern = Pattern.compile(VALID_YEAR_REGEX);
		Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
		return credentialsMatcher.find();
	}
	public static boolean isValidSearch(String credentials){
		Pattern credentialsPattern = Pattern.compile(VALID_NAME_SEARCH_REGEX);
		Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
		return credentialsMatcher.find();
	}
	public static boolean isValidTextSize(String size){
		Pattern sizePattern = Pattern.compile(VALID_TEXT_SIZE_REGEX);
		Matcher sizeMatcher = sizePattern.matcher(size);
		return sizeMatcher.find();
	}
	public static boolean isValidID(String ID){
		Pattern IDPattern = Pattern.compile(VALID_ID_REGEX);
		Matcher IDMatcher = IDPattern.matcher(ID);
		return IDMatcher.find();
	}

	public static boolean isValidCredentials(String credentials){
		Pattern credentialsPattern = Pattern.compile(VALID_CREDENTIALS_REGEX);
		Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
		return credentialsMatcher.find();
	}
	public static boolean isValidEmail(String email){
		Pattern emailPattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email);
		return emailMatcher.find();
	}
}
