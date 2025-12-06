package com.expense.model;

import java.time.LocalDate;

// Encapsulation used: all fields are private + accessed only through constructor/getters
public class Expense {

    private int id;
    private String name;
    private double amount;
    private LocalDate date;
    private String category;

    public Expense(int id, String name, double amount, LocalDate date, String category) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }

    public void setName(String name) { this.name = name; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
    	 return String.format("%d | %s | ₹%.2f | %s | %s", id, name, amount, date, category);
    }
}
