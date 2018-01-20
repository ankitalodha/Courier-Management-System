package application;

import java.sql.*;

public class DataSource {

	protected Connection connection;
    private static String url = "jdbc:mysql://127.0.0.1:3306/cms";
    private static String username = "root";
    private static String password = "";
    
    public DataSource() {
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }
    
	public void close() {
    	try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
	}
}
