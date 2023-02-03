package com.nrm.numbercaller.readandwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class WriteToFile {

	public void writeNumbersWithTimestamp(int[] numbers) {
		try {
			File file = new File("output.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			try (FileWriter writer = new FileWriter(file, true)) {
				writer.write(ZonedDateTime.now() + ": " + Arrays.toString(numbers) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
