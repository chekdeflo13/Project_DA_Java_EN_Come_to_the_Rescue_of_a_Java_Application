package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Write symptoms occurrences into a file
 * 
 * @author m700
 *
 */
public class OccurrenceWriter implements IOccurrenceWriter {

	private String path;
	private List<String> finalLines;
	BufferedWriter writer = null;

	/**
	 * @param path       = path to a file with number of symptoms occurrence in it,
	 *                   one per line
	 * @param finalLines = List of symptoms with number of occurrences
	 */

	public OccurrenceWriter(String fileResult, List<String> finalLines) {
		this.path = fileResult;
		this.finalLines = finalLines;
	}

	@Override
	public void writer() {
		if (path != null && finalLines != null) {
			try {
				writer = new BufferedWriter(new FileWriter(path));
				for (String line : finalLines) {
					writer.write(line + "\n");
				}
			} catch (IOException e) {
				System.err.println("Error while writing into file: " + e.getMessage());
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					System.err.println("Error while writing into file: " + e.getMessage());
				}
			}
		}
	}
}
