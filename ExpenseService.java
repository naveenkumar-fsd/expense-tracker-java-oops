package com.expense.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.expense.model.Expense;

//separation of concerns: business logic kept inside service layer
public class ExpenseService {
	
	//Encapsulation used : List is private and only accessible through methods
	private List<Expense> expenses;
	private int idCounter =1;
	
	public ExpenseService() {
		expenses = new ArrayList<>();
	}
	
	public Expense addExpense(String name,double amount, LocalDate date, String category) {
		Expense e= new Expense(idCounter++, name, amount, date, category);
		expenses.add(e);
		return e;
	}
	
	public boolean deleteExpense(int id) {
		return expenses.removeIf(e -> e.getId() == id);
	}
	
	public boolean updateExpense(int id, String name, double amount, LocalDate date, String category) {
		for(Expense e: expenses) {
			if(e.getId() == id) {
				e.setName(name);
				e.setAmount(amount);
				e.setDate(date);
				e.setCategory(category);
				return true;
			}
		}
		return false;
	}
	
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
	
	//Polymorphism used:comparator.comparingDouble internally uses functional polymorphism
	public void sortByAmount() {
		expenses.sort(Comparator.comparingDouble(Expense::getAmount));
	}
	
	//Polymorphism used:comparator. comparing uses method reference polymorphism
	public void sortByDate() {
		expenses.sort(Comparator.comparing(Expense::getDate));
	}
	
	//polymorphism NOT Used here: this method is a single implementation without overloading or overriding
	public double getMonthlyTotal(int year, int month) {
		YearMonth ym= YearMonth.of(year, month);
		double total =0;
		
		for(Expense e: expenses) {
			if(YearMonth.from(e.getDate()).equals(ym)) {
				total += e.getAmount();
			}
		}
		
		return total;
	}
	

}

