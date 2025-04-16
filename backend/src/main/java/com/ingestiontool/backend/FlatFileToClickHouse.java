package com.ingestiontool.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FlatFileToClickHouse {

    public void ingestDataToClickHouse(String filePath) {
        // ClickHouse JDBC URL
        String url = "jdbc:clickhouse://localhost:8123/test_data";  // Adjust port if needed
        String user = "default";  // ClickHouse user
        String password = "";     // Password if any

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Establishing connection to ClickHouse
            Connection connection = DriverManager.getConnection(url, user, password);
            String line;

            // Skip the header (if the CSV has one)
            reader.readLine(); 

            // Loop through each line of the CSV
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(","); // Assuming CSV is comma-separated

                // Prepare SQL INSERT statement
                String query = "INSERT INTO test_data (id, name, created_at) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                // Set values from CSV columns
                preparedStatement.setInt(1, Integer.parseInt(columns[0]));  // id
                preparedStatement.setString(2, columns[1]);                 // name
                preparedStatement.setString(3, columns[2]);                 // created_at (DateTime)

                // Execute the insert statement
                preparedStatement.executeUpdate();
            }

            System.out.println("Data from CSV inserted into ClickHouse successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FlatFileToClickHouse flatFileToClickHouse = new FlatFileToClickHouse();
        flatFileToClickHouse.ingestDataToClickHouse("C:\\Users\\HP\\Downloads\\test_data.csv");
    }
}
