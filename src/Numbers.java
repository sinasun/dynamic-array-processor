import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from
 * Plagiarism
 * 
 * 
 * This class represents a collection of numbers. It provides methods for adding
 * values, finding minimum and maximum values, calculating average, and more.
 * 
 * Student Name: Sina Khodaveisi
 * Student Number: 041066567
 * Section #: 300
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * 
 * @author/Professor James Mwangi PhD.
 * 
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] numbers;

	/**
	 * Max size of allowed numbers in Array.
	 */
	private int size;

	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * This is the default constructor for the Numbers class.
	 * It initializes an instance of Numbers with an empty array of Floats.
	 * The size of the array is set to -1 to indicate that it has infinite size.
	 */
	public Numbers() {
		this.size = -1;
		this.numItems = 0;
		numbers = new Float[0];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		this.size = size;
		this.numItems = 0;
		numbers = new Float[size];
	}

	/**
	 * Adds a value in the array
	 * 
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		boolean isInputBad = true;
		boolean hasNextFloat;
		float value = 0;

		while (isInputBad) {
			System.out.println("Enter value: ");

			hasNextFloat = keyboard.hasNextFloat();
			if (hasNextFloat) {
				value = keyboard.nextFloat();
				isInputBad = false; // break out of loop

			} else {
				System.out.println("Please enter a float");
			}
			keyboard.nextLine(); // clean up input stream
		}

		// When numItems is bigger than maximum size it means the size is -1, therefore
		// we don't have any maximum size
		if (numItems > size) {
			Float[] tmpNumbers = numbers;
			numbers = new Float[numItems + 1];
			for (int i = 0; i < tmpNumbers.length; i++) {
				numbers[i] = tmpNumbers[i];
			}

		} else if (numItems == size) {
			// it already has the maximum size so it shouldn't add the value
			System.out.println("Array has reached it maximum allowed numbers");
			return;
		}
		numbers[numItems++] = value;

	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * If the array is empty, it returns 0.
	 *
	 * @return the average value as a float
	 */
	public float calcAverage() {
		if (numItems == 0) {
			return 0;
		}
		float sum = 0.0f;
		for (int i = 0; i < numItems; i++) {
			sum += numbers[i];
		}

		float average = sum / numbers.length;

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String formattedAverage = decimalFormat.format(average);

		return Float.parseFloat(formattedAverage);
	}

	/**
	 * This method finds the minimum value, maximum value, and modulo result in the
	 * array of numbers.
	 * If the array is empty, it returns an array with all values set to 0.
	 *
	 * @return an array of floats containing the minimum value, maximum value, and
	 *         modulo result in that order
	 */
	public float[] findMinMax() {
		if (numItems == 0) {
			return new float[] { 0, 0, 0 };
		}

		float minValue = Float.MAX_VALUE;
		float maxValue = Float.MIN_VALUE;

		for (int i = 0; i < numItems; i++) {
			float number = numbers[i];
			if (number < minValue) {
				minValue = number;
			}

			if (number > maxValue) {
				maxValue = number;
			}

		}
		float moduloResult;
		if (minValue == 0) {
			moduloResult = 0;
		} else {
			moduloResult = maxValue % minValue;
		}

		return new float[] { minValue, maxValue, moduloResult };
	}

	/**
	 * Calculates the factorial of the maximum value in the numbers array.
	 * If the array is empty, it returns 0.
	 * If the maximum value is greater than or equal to 17, it returns
	 * Integer.MAX_VALUE
	 *
	 * @return the factorial of the maximum value as an integer
	 */
	public int getfactorialMax() {
		if (numItems == 0) {
			return 0;
		}
		int max = (int) findMinMax()[1];
		if (max >= 17) {
			return Integer.MAX_VALUE;
		}
		int ans = 1;
		for (int i = 2; i <= max; i++) {
			ans = ans * i;
		}
		return ans;
	}

	/**
	 * Returns a string representation of the Numbers object.
	 * The string includes each number in the array, separated by a newline
	 * character.
	 *
	 * @return a string representation of the Numbers object
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Numbers are:\n");
		for (int i = 0; i < numItems; i++) {
			output.append(numbers[i]).append("\n");
		}
		return output.toString();
	}

}
