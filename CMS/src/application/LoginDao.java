package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.User;

//import application.User;

//	import dao.DataSource;
//	import model.User;

	public class LoginDao extends DataSource {
		
		public User findByUsername(String userID, String password) {
			User user = null;
			String query = "SELECT * FROM customer_T WHERE userID = ? AND password = ?;";
	        try(PreparedStatement statement = connection.prepareStatement(query)){
	            statement.setString(1, userID);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();
	            if(resultSet.next()) {
	            	user = new User(
	            			//resultSet.getInt("id"),
	            			resultSet.getString("userID"),
	            			resultSet.getString("password")
	            			);
	            }
	        } catch(SQLException e){
	            System.out.println("Error Finding User by Username: " + e);
	        }
	        return user;
	    }
	}
