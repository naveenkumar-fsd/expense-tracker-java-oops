package com.expense.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.expense.model.Expense;

public class CSVUtil {
	
	//CSV:Comma Separated Values-it is a file used by Excel,Google sheets,Data Analysis Tools....
	
	//Abstraction used : CSV export logic hidden in one reusable util method.

    public static void exportToCSV(List<Expense> expenses) {
        String fileName = "expenses.csv";

        try (FileWriter writer = new FileWriter(fileName)) {

            // Writing table headings
            writer.write("ID,Name,Amount,Date,Category\n");

            // Write each expense as a CSV row
            for (Expense e : expenses) {
            	
            	//naive CSV - for production escape commas & quotes
            	
                writer.write(
                	e.getId() + ","+	
                    e.getName() + "," +
                    e.getAmount() + "," +
                    e.getDate() + "," +
                    e.getCategory() + "\n"
                );
            }

            System.out.println("CSV Export Successful ->" + fileName);

        } catch (IOException ex) {
            System.out.println("Error writing CSV: " + ex.getMessage());
        }
    }
    
    private static String escape(String field) {
        if (field == null) return "";
        if (field.contains(",") || field.contains("\"")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}
