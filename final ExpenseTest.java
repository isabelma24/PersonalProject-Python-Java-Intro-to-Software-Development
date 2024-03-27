package expenses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseTest {

	@Test
	void testExpense() {
		
		Expense expense = new Expense(12, 2.34);
		
		//confirm month number and amount
		assertEquals(12, expense.getMonth());
		assertEquals(2.34, expense.getAmount());
		
		
		// TODO Write more test cases
	}

	@Test
	void testEquals() {
		
		Expense expense1 = new Expense(12, 2.34);
		Expense expense2 = new Expense(11, 2.34);
		
		assertEquals(expense1, expense2);
		
		
		// TODO Write more test cases
	}

}
