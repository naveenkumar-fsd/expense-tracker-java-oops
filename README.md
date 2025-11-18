# Expense Tracker (Java OOPS Project)

A simple yet powerful **Expense Tracker Application** built using **Core Java** and **Object-Oriented Programming (OOPS)** principles.  
This project helps users record, update, delete, and view expenses efficiently. It also generates monthly summaries and ensures clean, modular, and maintainable code.

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


### Step-by-step Flow
1. User selects an action  
2. Program validates inputs  
3. Expense object created  
4. Data stored in List  
5. Service layer processes data  
6. Output shown to user (table format or report)

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





