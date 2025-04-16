package com.ingestiontool.backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

public class FlatFileWriter {

    // Method to write data from ResultSet to a CSV file
    public static void writeToCSV(ResultSet resultSet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {
            // Write headers (adjust these based on your actual table's columns)
            writer.write("id,name,created_at");  // Adjust the column names based on your table schema
            writer.newLine();

            // Write data rows
            while (resultSet.next()) {
                String column1 = resultSet.getString("id");  // Replace with actual column names from your query
                String column2 = resultSet.getString("name");
                String column3 = resultSet.getString("created_at");

                writer.write(column1 + "," + column2 + "," + column3);
                writer.newLine();
            }

            System.out.println("Data written to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error processing ResultSet: " + e.getMessage());
        }
    }
}
