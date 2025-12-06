package com.expense.app;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.expense.model.Expense;
import com.expense.password.PasswordUtil;
import com.expense.service.ExpenseService;
import com.expense.service.WalletService.WalletService;
import com.expense.util.CSVUtil;

//Main handles only input/output and orchestration(the automated ordination of multiple systems,applications and services to execute a larger, complex work flow)
//Separation of concerns : Main handles only input/output, NOT business logic 
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ExpenseService expenseService= new ExpenseService();
		 WalletService wallet = new WalletService();
		
		//Abstraction : passwordUtil hides validation logic
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
				
		
		if(!PasswordUtil.validatePassword(pass)) {
			System.out.println("Incorrect Password! Exiting...");
			sc.close();
			return;
		}
		
		// Optional : Initialize wallet balance at start
		System.out.println("Do you want to add initial balance? (y/n): ");
		String init = sc.nextLine().trim().toLowerCase();
		if (init.equals("y")) {
			System.out.println("Enter initial amount: ");
			try {
				double initAmt = Double.parseDouble(sc.nextLine());
				if(wallet.deposit(initAmt)) {
					System.out.println("Initial balance set: ₹" + wallet.getBalance());
				}else {
					System.out.println("Invalid initial amount. Balance remains ₹" + wallet.getBalance());
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid amount input. Balance reamains ₹" + wallet.getBalance());
			}
			
		}
		
		int choice = -1;
		
		do {
			
			try {
				showMenu();
				choice = Integer.parseInt(sc.nextLine());
			
			
			switch(choice) {
			
			case 1: //Add Expense
				System.out.println("Enter name: ");
				String name= sc.nextLine();
				
				System.out.println("Enter amount: ");
				double amount= Double.parseDouble(sc.nextLine());
				
				if(amount <=0) {
					System.out.println("Amount must be positive!");
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
				
				// Wallet check before adding 
				if (!wallet.deduct(amount)) {
					System.out.println("Insufficient balance! Current Balance: ₹" + wallet.getBalance());
					System.out.println("Please deposit money first.");
					break;
				}
				
				Expense added = expenseService.addExpense(name, amount, date, category);
				System.out.println("Added! Expense (ID : "+ added.getId() +").Remaining Balance : ₹ " + wallet.getBalance());
				break;
				
			case 2: //View All Expenses
				 List<Expense> all = expenseService.getAllExpenses();
				
				if(all.isEmpty()) {
					System.out.println("No Expenses recorded.");
				}
				else {
				     System.out.println("All Expenses: ");
				     all.forEach(System.out::println);
				}
				break;
				
			 case 3: // Search Expense
                 System.out.print("Enter keyword to search in name: ");
                 String kw = sc.nextLine();
                 List<Expense> found = expenseService.searchByName(kw);
                 if (found.isEmpty()) System.out.println("No matches.");
                 else found.forEach(System.out::println);
                 break;
				
			case 4: //sort
				System.out.println("1. Sort by Amont");
				System.out.println("2. Sort by Date");
				System.out.println("Choose: ");
				int opt= Integer.parseInt(sc.nextLine());
				
				if(opt ==1)expenseService.sortByAmount();
				else if(opt ==2)expenseService.sortByDate();
				else System.out.println("Invalid Option");
				System.out.println("Sorting done.");
				break;
				
			case 5: // Export CSV
				CSVUtil.exportToCSV(expenseService.getAllExpenses());
				break;
				
			case 6:	//Delete expense
				System.out.println("Enter Expense ID to Delete: ");
				int delId = Integer.parseInt(sc.nextLine());
				Expense removed = expenseService.deleteExpenseById(delId);
				if(removed == null) {
					System.out.println("Expense not found.");
				}else {
					//refund the amount to wallet
					wallet.refund(removed.getAmount());
					System.out.println("Deleted expense and refunded ₹" + removed.getAmount() +".New Balance ₹" + wallet.getBalance());
					
				}
				break;
				
			case 7: // update expense
				System.out.println("Enter Expense ID to update: ");
				int upId= Integer.parseInt(sc.nextLine());
				
				System.out.println("New Name: ");
				String newName = sc.nextLine();
				
				System.out.println("New Amount: ");
				double newAmount = Integer.parseInt(sc.nextLine());
				if(newAmount <= 0) {
					System.out.println("Amount must be > 0");
					break;
				}
				
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
				
				 double previousAmount = expenseService.updateExpense(upId, newName, newAmount, newDate,newCategory);
                 if (previousAmount == -1) {
                     System.out.println("Expense not found.");
                 } else {
                     double diff = newAmount - previousAmount;
                     if (diff > 0) {
                         // need to deduct extra
                         if (!wallet.deduct(diff)) {
                             // rollback update: set back to previous values (simple rollback)
                             expenseService.updateExpense(upId, newName, previousAmount, newDate, newCategory);
                             System.out.println("Insufficient balance for increasing expense. Update rolled back. Current Balance: ₹" + wallet.getBalance());
                         } else {
                             System.out.println("Updated. Deducted additional ₹" + diff + ". New Balance: ₹" + wallet.getBalance());
                         }
					
					}else if(diff < 0) {
						//refund difference
						wallet.refund(-diff);
						 System.out.println("Updated. Refunded ₹" + (-diff) + ". New Balance: ₹" + wallet.getBalance());
                    } else {
                        System.out.println("Updated (amount unchanged). Balance: ₹" + wallet.getBalance());
					}
				}
				break;
				
				
			case 8: // Deposit / Add money
				System.out.println("Enter amount to deposit: ");
				double dep = Double.parseDouble(sc.nextLine());
				if(wallet.deposit(dep)) {
					 System.out.println("Deposited ₹" + dep + ". New Balance: ₹" + wallet.getBalance());
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
                
			case 9:// view balance
				System.out.println("Current Balance: ₹" + wallet.getBalance());
				break;
				
			 case 10: // Monthly Summary
                 System.out.print("Enter month (1-12): ");
                 int month = Integer.parseInt(sc.nextLine());
                 System.out.print("Enter year (e.g. 2025): ");
                 int year = Integer.parseInt(sc.nextLine());
                 double total = expenseService.getMonthlyTotal(month, year);
                 System.out.printf("Total for %02d/%d = ₹%.2f%n", month, year, total);
                 break;
				
				
			case 11:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Invalid option.Choose again.");
			}
			
			}catch(NumberFormatException | DateTimeParseException nfe) {
				System.out.println("Invalid input: " + nfe.getMessage());
			} catch (InputMismatchException ime) {
				System.out.println("Input Mismatch.");
				sc.nextLine();//clear
			}catch(Exception ex) {
				System.out.println("Error :" + ex.getMessage());
				
			}
		}while(choice !=11);
		
		
		sc.close();
	}
		
		private static void showMenu() {
	        System.out.println("\n====== EXPENSE TRACKER ======");
	        System.out.println("1. Add Expense");
	        System.out.println("2. View All Expenses");
	        System.out.println("3. Search Expense");
	        System.out.println("4. Sort Expenses");
	        System.out.println("5. Export to CSV");
	        System.out.println("6. Delete Expense");
	        System.out.println("7. Update Expense");
	        System.out.println("8. Deposit Money");
	        System.out.println("9. View Balance");
	        System.out.println("10. Monthly Summary");
	        System.out.println("11. Exit");
	        System.out.print("Enter choice: ");

        }
		
}
