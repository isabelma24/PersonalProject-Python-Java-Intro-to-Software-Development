package expenses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpensesTest {

	Expenses expenses;
	
	@BeforeEach
	void setUp() throws Exception {
		this.expenses = new Expenses();
		
		Expense expense = new Expense(12, 2.34);
		this.expenses.addExpense(expense);
		
		expense = new Expense(10, 98.34);
		this.expenses.addExpense(expense);
		
		expense = new Expense(2, 44.00);
		this.expenses.addExpense(expense);
		
		expense = new Expense(12, 12.01);
		this.expenses.addExpense(expense);
	}
		
	@Test
	void testExpenses() {
		//confirm size of monthly expenses
		assertEquals(4, this.expenses.getMonthlyExpenses().size());
		
		//confirm some abbreviations and month numbers
		assertEquals(12, this.expenses.getMonthlyMappings().get("dec"));
		assertEquals(10, this.expenses.getMonthlyMappings().get("oct"));
		assertEquals(2, this.expenses.getMonthlyMappings().get("feb"));
	}
	
	@Test
	void testAddExpenses() {
		
		List<Map<Integer, Double>> expenseList = new ArrayList<Map<Integer, Double>>();
		Map<Integer, Double> entry = new HashMap<Integer, Double>();
		entry.put(12, 2.34);
		expenseList.add(entry);
		this.expenses.addExpenses(expenseList);
		
		//confirm size of monthly expenses
		assertEquals(5, this.expenses.getMonthlyExpenses().size());
		
		
		// TODO Write more test cases
	}
	
	@Test
	void testGetMonthlyExpensesString() {
		
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get monthly expenses for oct
		List<Double> monthlyExpenses = this.expenses.getMonthlyExpenses("oct");
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		// TODO Write more test cases
	}
	
	@Test
	void testGetMonthlyExpensesInt() {
		
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get monthly expenses for oct (10)
		List<Double> monthlyExpenses = this.expenses.getMonthlyExpenses(10);
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		// TODO Write more test cases
	}
	
	@Test
	void testGetTotalMonthlyExpenses() {
		
		//get total monthly expenses for oct
		double totalMonthlyExpenses = this.expenses.getTotalMonthlyExpenses("oct");
		assertEquals(98.34, totalMonthlyExpenses);
				
		
		// TODO Write more test cases
	}
	
	@Test
	void testGetMostExpensiveMonth() {
		
		Expense mostExpensiveMonthCompare = new Expense(10, 98.34);
		Expense mostExpensiveMonth = this.expenses.getMostExpensiveMonth();
		assertEquals(mostExpensiveMonthCompare, mostExpensiveMonth);
		
		
		// TODO Write more test cases
	}

}
