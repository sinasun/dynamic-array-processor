import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from
 * Plagiarism.
 * 
 * This class contains the dynamically allocated array and its processing.
 * 
 * Student Name: Sina Khodaveisi
 * Student Number: 041066567
 * Section #: 300
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * 
 * @version 1.0
 * 
 * @since 2023/5/14
 * 
 */

public class DynamicArrayProcessor {

	/**
	 * This is the main method of the program. It allows the user to interactively
	 * perform various operations on an array of numbers.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {

			Boolean keepRunning = true;
			Numbers numbers = new Numbers();

			while (keepRunning) {

				int value = getInt(keyboard, "Please select one of the following:\r\n"
						+ "1: Initialize a default array\r\n" + "2: To specify the max size of the array\r\n"
						+ "3: Add value to the array\r\n" + "4: Display values in the array\r\n"
						+ "5: Display average of the values, minimum value, maximum value, max mod min, factorialMax \r\n"
						+ "6: To Exit", 0, 7);

				switch (value) {
				case 1: {
					numbers = new Numbers();
					break;
				}
				case 2: {
					numbers = new Numbers(getInt(keyboard, "Enter new size of array:", 0, Integer.MAX_VALUE));
					break;
				}
				case 3: {
					numbers.addValue(keyboard);
					break;
				}
				case 4: {
					System.out.println(numbers.toString());
					break;
				}
				case 5: {
					float[] minMaxMod = numbers.findMinMax();
					float average = numbers.calcAverage();
					System.out.printf(
							"Average is: %.2f, Minimum value is %.2f, Maximum value is %.2f, max mod min is %.2f and factorial of Max is %d\r\n",
							average, minMaxMod[0], minMaxMod[1], minMaxMod[2], numbers.getfactorialMax());

					break;
				}
				case 6: {
					keepRunning = false;
					break;
				}

				}
			}
		}

	}

	/**
	 * Reads an integer value from the user within the specified range.
	 * The method prompts the user with the given prompt string and validates the
	 * input.
	 * If the input is not within the specified range or is not an integer, the
	 * method
	 * continues to prompt until a valid input is provided.
	 *
	 * @param keyboard the Scanner object to use for input
	 * @param prompt   the prompt message to display to the user
	 * @param min      the minimum allowed value (exclusive)
	 * @param max      the maximum allowed value (exclusive)
	 * 
	 * @return the validated integer value entered by the user
	 */
	public static int getInt(Scanner keyboard, String prompt, int min, int max) {

		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0;

		while (isInputBad) {
			System.out.println(prompt);

			hasNextInt = keyboard.hasNextInt();
			if (hasNextInt) {
				value = keyboard.nextInt();
				if (value > min && value < max) {

					isInputBad = false; // break out of loop

				} else {
					System.out.println("Select a value in the range. ");

				}
			} else {
				System.out.println("Select an integer. ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;
	}

}
