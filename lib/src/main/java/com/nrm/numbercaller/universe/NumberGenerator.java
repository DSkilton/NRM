package com.nrm.numbercaller.universe;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import com.nrm.numbercaller.readandwrite.WriteToFile;

public class NumberGenerator implements INumberGenerator {
	WriteToFile writeToFile = new WriteToFile();
	
	public NumberGenerator() {} 

	public int[] generateNumbers(int count, int range) {
		Set<Integer> numbers = new LinkedHashSet<>();
		Random random = new Random();
		while (numbers.size() < count) {
			numbers.add(random.nextInt(range) + 1);
		}
		return numbers.stream().mapToInt(i -> i).toArray();
	}

	public void printNumbersWithDelay(int[] numbers, int delay) {
		for (int number : numbers) {
			System.out.print(number + "  ");
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		writeToFile.writeNumbersWithTimestamp(numbers);
	}

}
