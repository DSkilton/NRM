package com.nrm.numbercaller.readandwrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

	public void readPreviousGamesFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
