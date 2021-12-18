package com.hemebiotech.analytics;

import java.util.List;

/**
 * describe symptoms and count their occurrences
 * 
 * @author m700
 *
 */
public class AnalyticsCounter {

	private static final String PATH_INPUT_FILE = "Project02Eclipse\\symptoms.txt";

	public static void main(String[] args) throws Exception {

		// create an ordered list from symptoms.txt file and read all lines.
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(PATH_INPUT_FILE);
		List<String> symptoms = reader.getSymptoms();
	}
}
