package com.ingestiontool.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClickHouseClient {

    // Method to connect and fetch data from ClickHouse
    public ResultSet fetchDataFromClickHouse() {
        String url = "jdbc:clickhouse://localhost:8123/test_data"; // Replace with your actual URL
        String user = "default"; // Replace with your ClickHouse username
        String password = ""; // Replace with your ClickHouse password or token

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();

            String query = "SELECT * FROM test_data"; // Replace with your table
            ResultSet resultSet = stmt.executeQuery(query);

            System.out.println("Connected to ClickHouse and fetched data successfully!");
            return resultSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
