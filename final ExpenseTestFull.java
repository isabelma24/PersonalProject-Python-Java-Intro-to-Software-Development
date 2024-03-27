package expenses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseTestFull {

	@Test
	void testExpense() {
		
		Expense expense = new Expense(12, 2.34);
		
		//confirm month number and amount
		assertEquals(12, expense.getMonth());
		assertEquals(2.34, expense.getAmount());
		
		
		expense = new Expense(10, 98.34);
		
		//confirm month number and amount
		assertEquals(10, expense.getMonth());
		assertEquals(98.34, expense.getAmount());
				
		
		expense = new Expense(2, 44.00);
		
		//confirm month number and amount
		assertEquals(2, expense.getMonth());
		assertEquals(44.00, expense.getAmount());

	}

	@Test
	void testEquals() {

		Expense expense1 = new Expense(12, 2.34);
		Expense expense2 = new Expense(11, 2.34);
		
		assertEquals(expense1, expense2);
		
		
		expense1 = new Expense(2, 34.53);
		expense2 = new Expense(11, 34.54);
		
		assertNotEquals(expense1, expense2);
	}

}
