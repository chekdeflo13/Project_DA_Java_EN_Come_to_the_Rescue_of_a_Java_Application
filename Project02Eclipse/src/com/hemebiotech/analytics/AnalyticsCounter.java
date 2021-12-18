package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * describe symptoms and count their occurrences
 * 
 * @author m700
 *
 */
public class AnalyticsCounter {

	private static final String PATH_INPUT_FILE = "Project02Eclipse\\symptoms.txt";
	private static final String PATH_RESULT_FILE = "Project02Eclipse\\result.out";

	public static void main(String[] args) throws Exception {

		// create an ordered list from symptoms.txt file and read all lines.
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(PATH_INPUT_FILE);
		List<String> symptoms = reader.getSymptoms();

		// count symptoms occurrences and ordered them into a list
		TreeMap<String, Long> orderedCount = new TreeMap<>();
		occurrenceCount(symptoms, orderedCount);

		// each symptom with number of occurrences in an ordered list
		List<String> finalLines = new ArrayList<>();
		for (String key : orderedCount.keySet()) {
			finalLines.add(key + ": " + orderedCount.get(key));
		}

		// then generate a new file
		OccurrenceWriter write = new OccurrenceWriter(PATH_RESULT_FILE, finalLines);
		write.writer();
	}

	/**
	 * count symptoms occurrences in this method.
	 * 
	 * @param symptoms     = List of symptoms
	 * @param orderedCount = Count occurrences and ordered them
	 */
	private static void occurrenceCount(List<String> symptoms, TreeMap<String, Long> orderedCount) {
		for (String line : symptoms) {
			if (orderedCount.containsKey(line)) {
				orderedCount.put(line, orderedCount.get(line) + 1);
			} else {
				orderedCount.put(line, (long) 1L);
			}
		}
	}
}
