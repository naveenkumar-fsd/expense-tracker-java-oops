💰 Expense Tracker + Wallet System (Java OOPS Project)

A complete Expense Tracker Application built using Core Java with a fully functional Wallet Balance System, allowing users to track expenses, update/delete entries, and maintain real-time balance like a mini-GPay wallet.
This project strictly follows Object-Oriented Programming (OOPS) principles and is structured, modular, and interview-ready.

📌 Why Not Google Notes / Excel?

Many people use Notes or Excel for expense tracking, but they have major limitations:

❌ Problems with Excel / Notes

No automatic balance deduction

No validations (wrong amount/date gets added)

No update/delete tracking

No monthly summary

No password protection

Manual calculation every time

Not scalable or structured

✔ Advantages of This Java Expense Tracker

Wallet system manages balance automatically

Add, update, delete operations

Real-time balance like GPay

Monthly total report

Password-protected

No wrong inputs (strong validation)

100% OOPS-based clean backend

Easy to expand for future features

🛠 Technologies Used

Java 8+

OOPS Concepts

Encapsulation

Abstraction

Polymorphism

Modularity

Collections (ArrayList)

LocalDate API

Scanner (CLI Program)

🚀 Features Implemented (Updated)
💵 1. Wallet Balance System (NEW)

Your project now works like a mini-wallet app.

Start with initial balance (e.g., ₹40,000)

When you add an expense → balance reduces

When you delete an expense → amount added back

When you update an expense → balance auto-adjusts

Always shows remaining balance

This is the biggest NEW feature added to your project.

🔐 2. Password Protection

Before accessing the app, user must enter a valid password.

Prevents unauthorized access.

➕ 3. Add Expense

User enters:

Title

Amount

Date

Category (optional)

Validations include:

No negative amount

No empty fields

No spending more than wallet balance

Correct date format

✏ 4. Update Expense

Modify amount, description or date.

Wallet automatically re-adjusts difference.

❌ 5. Delete Expense

Remove an expense by ID.

Wallet refund system restores deleted amount.

📄 6. View All Expenses

Displays all saved expenses

Clean tabular format

Shows ID, Name, Amount, Date

📆 7. Monthly Summary Report

Get total expenses of any month

Count of expenses

Uses Polymorphism → Method Overloading

getMonthlyTotal(int month);
getMonthlyTotal(int month, int year);

🔥 OOPS Concepts Used (Updated for Wallet System)
Encapsulation

All fields in Expense are private

Wallet balance is private inside service class

Abstraction

ExpenseService hides business logic

Main class doesn’t know how wallet adjusts

Polymorphism

Monthly summary uses method overloading

Same method name → different parameters

Modularity

Classes split clearly:

Expense → model

ExpenseService → logic

Main → UI/runner

🧠 Step-by-Step Workflow (Updated With Wallet)

User enters password

Wallet balance displayed

Menu opens:

Add Expense

Update Expense

Delete Expense

View Expenses

Monthly Summary

Exit

Adding expense → wallet decreases

Deleting expense → wallet increases

Updating expense → wallet recalculates difference

Data stays until program exit

📈 Future Enhancements

CSV / JSON file storage

Login system with username & password

Mobile-style UI (JavaFX)

Export monthly report

Category analytics (Pie chart)

Database support (MySQL / SQLite)

REST API version (Spring Boot)

🙋 About the Project

This project helped me learn:

Real-world Java backend logic

How digital wallet systems work

OOPS implementation in actual projects

Collections & date handling

Clean coding & layered architecture

Perfect for:

Java students

Entry-level developers

Interview projects

Portfolio GitHub repository
