package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jbdc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE todo (id INTEGER, task TEXT)");
        } catch (SQLException e) {
            
        }
    }
}