package com.expense.app;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.expense.model.Expense;
import com.expense.password.PasswordUtil;
import com.expense.service.ExpenseService;
import com.expense.util.CSVUtil;

//Separation of concerns : Main handles only input/output, NOT business logic 
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ExpenseService service= new ExpenseService();
		
		//Abstraction : passwordUtil hides validation logic
		System.out.println("Enter Password: ");
		
		if(!PasswordUtil.validatePassword(sc.nextLine())) {
			System.out.println("Incorrect Password! Exiting...");
			return;
		}
		int choice;
		
		do {
			System.out.println("\n======EXPENSE TRACKER=====");
			System.out.println("1. Add Expense");
			System.out.println("2. View All Expenses");
			System.out.println("3. Search Expense");
			System.out.println("4. Sort Expenses");
			System.out.println("5. Export to CSV");
			System.out.println("6. Delete Expense");
			System.out.println("7. Update Expense");
			System.out.println("8. Monthly Summary");
			System.out.println("9. Exit");
			System.out.print("Enter choice: ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter name: ");
				String name= sc.nextLine();
				
				System.out.println("Enter amount: ");
				double amount= sc.nextDouble();
				sc.nextLine();
				
				if(amount <=0) {
					System.out.println("Amount must br positive!");
					break;
				}
				
				System.out.println("Enter date(YYYY-MM-DD): ");
				LocalDate date;
				try {
					date = LocalDate.parse(sc.nextLine());
				} catch(DateTimeParseException e) {
					System.out.println("Invalid Date Format!");
					break;
					
				}
				
				System.out.println("Enter category: ");
				String category= sc.nextLine();
				
				Expense e = service.addExpense(name, amount, date, category);
				
				System.out.println("Added! Expense ID = "+ e.getId());
				break;
				
			case 2:
				 List<Expense> all = service.getAllExpenses();
				
				if(all.isEmpty())System.out.println("No Expenses found.");
				else all.forEach(System.out::println);
				break;
				
			case 3:
				System.out.println("Enter name to search: ");
				String key =sc.nextLine();
				
				List<Expense> results= service.searchByName(key);
				
				if(results.isEmpty())System.out.println("No matching expenses.");
				else results.forEach(System.out::println);
				break;
				
			case 4:
				System.out.println("1. Sort by Amont");
				System.out.println("2. Sort by Date");
				int opt= sc.nextInt();
				
				
				if(opt ==1)service.sortByAmount();
				else if(opt ==2)service.sortByDate();
				else System.out.println("Invalid Option");
				
				break;
				
			case 5:
				CSVUtil.exportToCSV(service.getAllExpenses());
				break;
				
			case 6:	
				System.out.println("Enter Expense ID to Delete: ");
				int delId = sc.nextInt();
				if(service.deleteExpense(delId)) {
					System.out.println("Deleted Successfully!");
				} else {
					System.out.println("Expense not found.");
				}
				break;
				
			case 7:
				System.out.println("Enter Expense ID to update: ");
				int upId= sc.nextInt();
				sc.nextLine();
				
				System.out.println("New Name: ");
				String newName = sc.nextLine();
				
				System.out.println("New Amount: ");
				double newAmount = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("New Date(YYYY-MM-DD): ");
				LocalDate newDate;
				try {
					newDate = LocalDate.parse(sc.nextLine());
				} catch (DateTimeParseException ex2){
					System.out.println("Invalid date format!");
					break;
				}
				
				System.out.println("New Category: ");
				String newCategory = sc.nextLine();
				
				if(service.updateExpense(upId, newName, newAmount, newDate, newCategory)) {
					System.out.println("Updated Successfully!");
				}else {
					System.out.println("Expense not found.");
				}
				break;
				
			case 8:
				System.out.println("Enter Year(YYYY): ");
				int year = sc.nextInt();
				System.out.println("Enter Month(1-12): ");
				int month = sc.nextInt();
				
				double total= service.getMonthlyTotal(year, month);
				System.out.println("Total Expense for " + month + "/" + year + ": ₹" + total);
				break;
				
				
			case 9:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Invalid option.");
			}
		}while(choice !=9);
		
		
		sc.close();
	}

}
