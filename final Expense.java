package expenses;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Represents a single expense for a particular month.
 */
public class Expense {

	/**
	 * Number of month for expense.
	 */
	private int month;
	
	/**
	 * Amount of expense.
	 */
	private double amount;
	
	/**
	 * Creates Expense with given month number and amount.
	 * @param month for expense
	 * @param amount for expense
	 */
	public Expense(int month, double amount) {
		this.month = month;
		this.amount = amount;
	}
	
	/**
	 * Get month of expense.
	 * @return month
	 */
	public int getMonth() {
		// TODO Implement method
		
		return 0;
	}
	
	/**
	 * Get amount of expense.
	 * @return amount
	 */
	public double getAmount() {
		// TODO Implement method
		
		return 0.0;
	}
	
	/**
	 * Returns the month number and amount for expense.
	 */
	@Override 
	public String toString() {
		// TODO Implement method
		
		return "";
	}
	
	/**
	 * Compares two Expense objects for equality, based on the amounts.
	 * If the amounts are equal, the Expense objects are equal.
	 */
	@Override 
	public boolean equals(Object o) {
		// TODO Implement method
		
		return false;
	}
}