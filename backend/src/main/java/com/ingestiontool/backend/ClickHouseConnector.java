package com.ingestiontool.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClickHouseConnector {

    public static ResultSet fetchData() {
        try {
            // 1. Connect to ClickHouse (Change these to your DB details)
            String url = "jdbc:clickhouse://localhost:8123/test_data";  // Change URL, port, database name
            String user = "default";  // Your ClickHouse username
            String password = "";     // Your ClickHouse password (if any)

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();

            // 2. Sample Query to Fetch Data
            String query = "SELECT id, name, created_at FROM test_data"; // change table + column names
            ResultSet resultSet = stmt.executeQuery(query);

            System.out.println("Data fetched from ClickHouse.");
            return resultSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
