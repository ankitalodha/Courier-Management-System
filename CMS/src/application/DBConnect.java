package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author me
 */

public class DBConnect { 

	//Connection object
	private static Connection connection;
	//Database connection parameters
    private static String url = "jdbc:mysql://127.0.0.1:3306/cms";
    private static String username = "root";
    private static String password = "";

  
    
	public static Connection connect() throws SQLException{
		connection = DriverManager.getConnection(url,username,password);
        return connection;
		// TODO Auto-generated method stub
		
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(connection !=null && !connection.isClosed())
            return connection;
        connect();
        return connection;

    }
}