package expenses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import expenses.file.ExpenseFileReader;

/**
 * Keeps track of expense information for different months.
 * @author <insert pennkey>
 */
public class Expenses {

	/**
	 * List of monthly expense objects.
	 */	
	private List<Expense> monthlyExpenses;
	
	/**
	 * Mappings to match a month abbreviation with a month number.
	 * For example, the map should look like this:
	 *   {"jan"=1, "feb"=2, ...}
	 */
	private Map<String, Integer> monthlyMappings;
	
	/**
	 * Creates Expenses for storing and managing individual monthly expenses.
	 * Initializes list of monthly expenses and creates mappings to match a month abbreviation with a month number.
	 */
	public Expenses() {
		
		//initialize list of expenses
		this.monthlyExpenses = new ArrayList<Expense>();
		
		//initialize map of month abbreviations to month numbers
		this.monthlyMappings = new HashMap<String, Integer>();
		
		//create String array of month abbreviations
		String[] months = {"jan", "feb", "march",  "april", "may", "june", 
				"july", "aug", "sept", "oct", "nov", "dec"};
		
		//populate monthlyMappings with String array 
		int monthCount = 1;
		for (String month : months) {
			this.monthlyMappings.put(month, monthCount++);
		}
	}
	
	/**
	 * Gets list of monthly expenses.
	 * @return list of expenses
	 */
	public List<Expense> getMonthlyExpenses() {
		// TODO Implement method
		
		return new ArrayList<Expense>();
	}
	
	/**
	 * Gets mappings to match a month abbreviation with a month number.
	 * @return map of month names and month numbers
	 */
	public Map<String, Integer> getMonthlyMappings() {
		// TODO Implement method
		
		return new HashMap<String, Integer>();
	}
	
	/**
	 * Converts each expense in the given list to an Expense object,
	 * and adds it to the internal list of monthly expenses.
	 * @param expenses to add
	 */
	public void addExpenses(List<Map<Integer, Double>> expenses) {
		// TODO Implement method
		// Hint: Iterate over given list of expenses and create Expense object for each
		// based on key (month) and value (amount)
	}
	
	/**
	 * Adds given Expense object to the internal list of monthly expense objects.
	 * @param expense to add
	 */
	public void addExpense(Expense expense) {
		// TODO Implement method
	}
	
	/**
	 * Gets list of expenses for given month number.
	 * @param month to look up
	 * @return list of expenses for given month
	 */
	public List<Double> getMonthlyExpenses(int month) {
		// TODO Implement method
		// Hint: Iterate over list of expenses and find those for given month
		
		return new ArrayList<Double>();
	}
	
	/**
	 * Gets list of expenses for given month abbreviation.
	 * Maps given month name to month number.
	 * @param month to look up
	 * @return list of expenses for given month
	 */
	public List<Double> getMonthlyExpenses(String month) {
		// TODO Implement method
		// Hint: Get the number of month
		// Hint: Iterate over list of expenses and find those for given month
		
		return new ArrayList<Double>();
	}

	/**
	 * Gets total amount of expenses for given month abbreviation.
	 * @param month to look up
	 * @return total expenses for given month
	 */
	public double getTotalMonthlyExpenses(String month) {
		// TODO Implement method
		// Hint: Get monthly expenses for given month
		// Then calculate the sum of all expense amounts
		
		return 0.0;
	}
	
	/**
	 * Identifies the month with the highest expenses.
	 * @return Expense object with information for most expensive month
	 */
	public Expense getMostExpensiveMonth() {
		// TODO Implement method
		// Hint: Iterate over each month and get the total expenses for each
		// Then determine the greatest
		
		return null;
	}
	
	public static void main(String[] args) {
		
		//load expense file into list of strings
		List<String> expenseList = ExpenseFileReader.loadExpenses("expenses.txt");
		
		//parse list of strings into list of maps
		List<Map<Integer, Double>> monthlyExpenses = ExpenseFileReader.parseExpenses(expenseList);
				
		//create instance of expenses class
		Expenses expenses = new Expenses();
				
		//add list of maps to internal list of expense objects
		expenses.addExpenses(monthlyExpenses);
		
		//get list of expenses for oct
		List<Double> octMonthlyExpenses = expenses.getMonthlyExpenses("oct");
		System.out.println("Oct. Expenses: " + octMonthlyExpenses);
		
		System.out.println();
		
		//get list of expenses for jan
		List<Double> janMonthlyExpenses = expenses.getMonthlyExpenses("jan");
		System.out.println("Jan. Expenses: " + janMonthlyExpenses);
		
		//get total expenses for jan
		double totalJanMonthlyExpenses = expenses.getTotalMonthlyExpenses("jan");
		System.out.println("Total: " + totalJanMonthlyExpenses);
				
		System.out.println();
		
		//get list of expenses for 2 (feb)
		List<Double> febMonthlyExpenses = expenses.getMonthlyExpenses(2);
		System.out.println("Feb. Expenses: " + febMonthlyExpenses);
		
		//get total expenses for feb
		double totalFebMonthlyExpenses = expenses.getTotalMonthlyExpenses("feb");
		System.out.println("Total: " + totalFebMonthlyExpenses);
		
		System.out.println();
		
		//get highest expense
		Expense mostExpensiveMonth = expenses.getMostExpensiveMonth();
		System.out.println("Most Expensive Month: " + mostExpensiveMonth);
		
	}
}
