# Expense Tracker (Java OOPS Project)

A complete Expense Tracker Application built using Core Java with a fully functional Wallet Balance System, allowing users to track expenses, update/delete entries, and maintain real-time balance like a mini-GPay wallet.
This project strictly follows Object-Oriented Programming (OOPS) principles and is structured, modular, and interview-ready.
---

## 📌 Why Not Google Notes / Excel?

Most people track expenses in **Google Notes** or **Excel**, but they face limitations:

### ❌ Excel / Notes Problems
- No automatic validations (wrong data entries)
- No structure or categorization
- No delete/update history
- No summary reports
- No real-time calculation logic
- Manual work every time
- Hard to maintain long-term data

### ✔ Our Expense Tracker Advantages
- Programmatic validation (invalid amount/date prevented)
- Clean OOPS structure (Scalable for future features)
- Add, update, delete operations
- Automatic category & date handling
- Monthly summary report
- Stored in program memory for fast access
- Fully Java-based — no manual work

---

## 🛠 Technologies Used
- **Java 8+**
- **OOPS concepts**
  - Encapsulation
  - Abstraction
  - Inheritance
  - Polymorphism
- **Collections (List, Map)**
- **LocalDate API**
- **Scanner input (CLI Application)**


---

## 🚀 Features Implemented

###💵 Wallet Balance System (NEW)

- Your project now works like a mini-wallet app.

- Start with initial balance (e.g., ₹40,000)

- When you add an expense → balance reduces

- When you delete an expense → amount added back

- When you update an expense → balance auto-adjusts

- Always shows remaining balance

- This is the biggest NEW feature added to your project.

###🔐 Password Protection

- Before accessing the app, user must enter a valid password.

- Prevents unauthorized access.

### ✔ Add Expense  
Allows users to add an expense with:
- Amount  
- Description  
- Category  
- Date (LocalDate)

### ✔ Update Expense  
Modify existing expense details.

### ✔ Delete Expense  
Remove an expense using ID.

### ✔ View All Expenses  
Displays all expenses in a clean, readable format.

### ✔ Monthly Summary Report  
Generates:
- Total expenses of the month  
- Count of entries  
- Category-wise expense breakdown  

### ✔ Validations Added
- Negative/zero amount check  
- Empty description check  
- Invalid date check  
- Category validation  

---

## 🔥 What I Have Used (OOPS Breakdown)

### **Encapsulation**  
All expense fields are private with getters/setters.

### **Abstraction**  
Service layer hides the internal logic from main class.

### **Inheritance**  
(Not mandatory but used if extended classes are added in future like FixedExpense, VariableExpense)

### **Polymorphism**  
Method overloading/overriding used in service classes.

---

🔥 OOPS Concepts Used (Updated for Wallet System)
Encapsulation

- All fields in Expense are private

- Wallet balance is private inside service class

Abstraction

- ExpenseService hides business logic

- Main class doesn’t know how wallet adjusts

Polymorphism

- Monthly summary uses method overloading

- Same method name → different parameters

Modularity

- Classes split clearly:

   - Expense → model

   - ExpenseService → logic

Main → UI/runne

---

### Step-by-step Flow
 1. User enters password

 2. Wallet balance displayed

 3. Menu opens:

   -Add Expense

   -Update Expense

   -Delete Expense

   -View Expenses

   -Monthly Summary

   -Exit

 4. Adding expense → wallet decreases

 5. Deleting expense → wallet increases

 6. Updating expense → wallet recalculates difference

 7. Data stays until program exit

---

## 📈 Future Enhancements
- File-based storage (JSON / CSV)
- Login & authentication
- GUI / Web interface
- Export monthly reports
- Category analytics (Pie Chart)

---

## 🙋 About the Project

This project helped me practice:
- Real-time problem solving  
- Clean coding principles  
- OOPS concepts in real scenarios  
- Using Java Collections effectively  
- Building realistic, interview-ready applications  

---

## 🗺️ Roadmap (Upcoming Improvements)

### 🔹 Phase 1 (In Progress)
- Improve validations
- More clean console UI
- Code documentation with JavaDoc

### 🔹 Phase 2
- Add file-based storage (CSV/JSON)
- Export monthly report to file
- Add category statistics (min, max, average)

### 🔹 Phase 3
- Add login/authentication
- Convert to GUI using Swing/JavaFX
- Convert this into a full Spring Boot web application

### 🔹 Phase 4
- Graphical expense charts
- Database support (MySQL / SQLite)
- REST API version


## 🤝 Contribution
Feel free to fork and improve the project!

---

## 📬 Contact
If you like my project, let's connect on LinkedIn or GitHub.  
Happy Coding! 🚀
