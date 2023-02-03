package com.nrm.numbercaller;

import java.util.Scanner;

import com.nrm.numbercaller.readandwrite.ReadFromFile;
import com.nrm.numbercaller.readandwrite.WriteToFile;
import com.nrm.numbercaller.universe.INumberGenerator;
import com.nrm.numbercaller.universe.NumberGenerator;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private INumberGenerator numberGenerator = new NumberGenerator();
	
	public Menu() {
	}

	public void welcome() {
		System.out.println("""
				Welcome to NMR's Number Universe
				""");
	}

	public void topLevelMenu() {
		ReadFromFile readFromFile = new ReadFromFile();
		System.out.println("""
				Main menu:
				1. Preset options
				2. Custom options
				9. Read previous games from file
				0. Exit
				""");

		int choice = getValidIntInput();

		switch (choice) {
		case 1:
			presetMenu();
			break;

		case 2:
			customMenu();
			break;
			
		case 9:
			readFromFile.readPreviousGamesFromFile();
			break;

		case 0:
			System.exit(0);

		default:
			System.out.println("unknown option, please try again");
			topLevelMenu();
		}
	}
	
	public int getValidIntInput() {
		while(!scanner.hasNextInt()) {
			System.out.println("Invalid input, please enter an integer");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public void presetMenu() {
		System.out.println("""
				Main menu:
				1. 36 from 49
				2. 49 from 90
				3. 1 from 2
				0. Previous menu
				""");

		int choice = getValidIntInput();

		switch (choice) {

		case 1:
			numberGenerator.printNumbersWithDelay(numberGenerator.generateNumbers(36, 49), 2000);
			break;

		case 2:
			numberGenerator.printNumbersWithDelay(numberGenerator.generateNumbers(49, 90), 2000);
			break;

		case 3:
			numberGenerator.printNumbersWithDelay(numberGenerator.generateNumbers(1, 2), 2000);
			break;

		case 0:
			topLevelMenu();
			break;

		default:
			System.out.println("unknown option, please try again");
			presetMenu();
		}
		
		presetMenu();
	}

	public void customMenu() {
		System.out.println("""
				Main menu:
				1. Enter custom game 
				0. Previous menu
				""");

		int choice = getValidIntInput();

		switch (choice) {

		case 1:
		    System.out.println("Enter the lower range: ");
		    int lower = getValidIntInput();

		    System.out.println("Enter the upper range: ");
		    int upper = getValidIntInput();

		    NumberGenerator numberGenerator = new NumberGenerator();
		    numberGenerator.printNumbersWithDelay(numberGenerator.generateNumbers(lower, upper), 2000);
			break;

		case 0:
			customMenu();
			break;

		default:
			System.out.println("unknown option, please try again");
			presetMenu();
		}
	}
}
