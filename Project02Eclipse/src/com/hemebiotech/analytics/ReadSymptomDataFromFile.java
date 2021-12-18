package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read each line of symptoms from a file
 *
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	BufferedReader reader = null;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filePath != null) {
			try {
				reader = new BufferedReader(new FileReader(filePath));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.err.println("Error while reading the file: " + e.getMessage());
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					System.err.println("Error while reading the file: " + e.getMessage());
				}
			}
		}
		return result;
	}
}




