package expenses.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Manages the loading and parsing of expense files.
 *
 */
public class ExpenseFileReader {

	/**
	 * Loads the given filename and adds each line to a list.
	 * Ignores lines with only whitespace.
	 * @param fileName to load
	 * @return list of lines from the file
	 */
	public static List<String> loadExpenses(String fileName) {
		// TODO Implement method
		// Hint: Read each line in the file
		// If the line only contains whitespace, ignore it
		
		return new ArrayList<String>();
	}
	
	/**
	 * Parses month and expense amount from given list of expenses (returned from loadExpenses).
	 * Each row has a month number, a delimiter, and an expense amount.
	 * Delimiters can include a comma (,), a colon (:), or multiple spaces ('    ').
	 * 
	 * Stores expenses in list of maps, each one consisting of a month number and an expense amount.
	 * For example:
	 *   [{1=57.38}, {5=5.06}, {10=456.99}, {5=3.99}, ...]
	 *   Where 1 is the month (for jan) and 57.38 is an expense for that month.  
	 *   5 is the month (for may) and 5.06 is an expense amount for that month.
	 *   3.99 is another expense amount for month 5.
	 * @param list of expenses to parse
	 * @return map of monthly expenses
	 */
	public static List<Map<Integer, Double>> parseExpenses(List<String> expenseList) {
		// TODO Implement method
		// Hint: Iterate over each line and split on the delimiters
		// Then get the month number and expense amount
		
		return new ArrayList<Map<Integer, Double>>();
	}
}