package expenses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpensesTestFull {

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
		
		//create and add list of expenses
		List<Map<Integer, Double>> expenseList = new ArrayList<Map<Integer, Double>>();
		Map<Integer, Double> entry = new HashMap<Integer, Double>();
		entry.put(12, 2.34);
		expenseList.add(entry);
		this.expenses.addExpenses(expenseList);
		
		//confirm size of monthly expenses
		assertEquals(5, this.expenses.getMonthlyExpenses().size());
		
		
		expenseList = new ArrayList<Map<Integer, Double>>();
		entry = new HashMap<Integer, Double>();
		entry.put(10, 98.34);
		expenseList.add(entry);
		this.expenses.addExpenses(expenseList);
		
		//confirm size of monthly expenses
		assertEquals(6, this.expenses.getMonthlyExpenses().size());
		
		
		expenseList = new ArrayList<Map<Integer, Double>>();
		entry = new HashMap<Integer, Double>();
		entry.put(2, 44.00);
		expenseList.add(entry);
		this.expenses.addExpenses(expenseList);
		
		//confirm size of monthly expenses
		assertEquals(7, this.expenses.getMonthlyExpenses().size());
		
	}
	
	@Test
	void testGetMonthlyExpensesString() {
		
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get monthly expenses for oct
		List<Double> monthlyExpenses = this.expenses.getMonthlyExpenses("oct");
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(2.34);
		monthlyExpensesExpected.add(12.01);
		
		//get monthly expenses for dec
		monthlyExpenses = this.expenses.getMonthlyExpenses("dec");
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(44.00);
		
		//get monthly expenses for feb
		monthlyExpenses = this.expenses.getMonthlyExpenses("feb");
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
	}
	
	@Test
	void testGetMonthlyExpensesInt() {
		
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get monthly expenses for oct (10)
		List<Double> monthlyExpenses = this.expenses.getMonthlyExpenses(10);
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(2.34);
		monthlyExpensesExpected.add(12.01);
		
		//get monthly expenses for dec (12)
		monthlyExpenses = this.expenses.getMonthlyExpenses(12);
		assertEquals(monthlyExpensesExpected, monthlyExpenses);
		
		
		monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(44.00);
		
		//get monthly expenses for feb (2)
		monthlyExpenses = this.expenses.getMonthlyExpenses(2);
		assertEquals(monthlyExpensesExpected, monthlyExpenses);

	}
	
	@Test
	void testGetTotalMonthlyExpenses() {
		
		//get total monthly expenses for oct
		double totalMonthlyExpenses = this.expenses.getTotalMonthlyExpenses("oct");
		assertEquals(98.34, totalMonthlyExpenses);
		
		
		//get total monthly expenses for dec
		totalMonthlyExpenses = this.expenses.getTotalMonthlyExpenses("dec");
		assertEquals(14.35, totalMonthlyExpenses);
		
		
		//get total monthly expenses for feb
		totalMonthlyExpenses = this.expenses.getTotalMonthlyExpenses("feb");
		assertEquals(44.00, totalMonthlyExpenses);
	}
	
	@Test
	void testGetMostExpensiveMonth() {
		
		Expense mostExpensiveMonthCompare = new Expense(10, 98.34);
		Expense mostExpensiveMonth = this.expenses.getMostExpensiveMonth();
		assertEquals(mostExpensiveMonthCompare, mostExpensiveMonth);
		
		
		//add another expense to dec (12)
		this.expenses.addExpense(new Expense(12, 1000.01));
		mostExpensiveMonthCompare = new Expense(12, 1014.36);
		mostExpensiveMonth = this.expenses.getMostExpensiveMonth();
		assertEquals(mostExpensiveMonthCompare, mostExpensiveMonth);
	}

}
