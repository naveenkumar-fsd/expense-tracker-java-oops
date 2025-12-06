package com.expense.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.expense.model.Expense;

//separation of concerns: business logic kept inside service layer
//Encapsulation: expenses list is private and only modifiable via methods.
//Polymorphism used: getMonthlyTotal() is overloaded (month) and (month, year)

public class ExpenseService {
	
	//Encapsulation used : List is private and only accessible through methods
	private List<Expense> expenses;
	private int idCounter =1;
	
	public ExpenseService() {
		expenses = new ArrayList<>();
	}
	
	//create
	
	public Expense addExpense(String name,double amount, LocalDate date, String category) {
		Expense e= new Expense(idCounter++, name, amount, date, category);
		expenses.add(e);
		return e;
	}
	
	// Delete by id - returns removed Expense for wallet refund handling (or null if not found)
	
	  public Expense deleteExpenseById(int id) {
	        for (int i = 0; i < expenses.size(); i++) {
	            if (expenses.get(i).getId() == id) {
	                return expenses.remove(i);
	            }
	        }
	        return null;
	    }

	
	  // Update: returns previous amount on success, -1 if not found
	    public double updateExpense(int id, String newName, double newAmount, LocalDate newDate, String newCategory) {
	        for (Expense e : expenses) {
	            if (e.getId() == id) {
	                double previousAmount = e.getAmount();
	                e.setName(newName);
	                e.setAmount(newAmount);
	                e.setDate(newDate);
	                e.setCategory(newCategory);
	                return previousAmount;
	            }
	        }
	        return -1;
	    }
	
	//Read
	    
	public List<Expense> getAllExpenses() {
        return expenses;
    }
	
	public List <Expense> searchByName(String keyword){
		List<Expense> result= new ArrayList<>();
		
		for(Expense e: expenses) {
			if(e.getName().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(e);
			}
		}
		return result;
	}
	
	
	// Sorting - uses method reference (polymorphism concept via functional interfaces)
	//Polymorphism used:comparator.comparingDouble internally uses functional polymorphism
	public void sortByAmount() {
		expenses.sort(Comparator.comparingDouble(Expense::getAmount));
	}
	
	//Polymorphism used:comparator. comparing uses method reference polymorphism
	public void sortByDate() {
		expenses.sort(Comparator.comparing(Expense::getDate));
	}
	
	  // Polymorphism (method overloading) - two versions:
     // 1) getMonthlyTotal(month) -> current year
	
    public double getMonthlyTotal(int month) {
        int currentYear = LocalDate.now().getYear();
        return getMonthlyTotal(month, currentYear);
    }

    // 2) getMonthlyTotal(month, year)
    public double getMonthlyTotal(int month, int year) {
        YearMonth ym = YearMonth.of(year, month);
        double total = 0;
        for (Expense e : expenses) {
            if (YearMonth.from(e.getDate()).equals(ym)) {
                total += e.getAmount();
            }
        }
        return total;
    }

	

}

