package com.nrm.numbercaller.universe;

public interface INumberGenerator {
	
	public int[] generateNumbers(int count, int range);
	public void printNumbersWithDelay(int[] numbers, int delay);

}
