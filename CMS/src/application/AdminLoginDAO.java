package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.User;

//import application.User;

//    import dao.DataSource;
//    import model.User;

    public class AdminLoginDAO extends DataSource {
        
        public User adminFinder(String adminID, String password) {
            User user = null;
            String query = "SELECT * FROM admin_T WHERE adminID = ? AND password = ?;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, adminID);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()) {
                    user = new User(
                            //resultSet.getInt("id"),
                            resultSet.getString("adminID"),
                            resultSet.getString("password")
                            );
                }
            } catch(SQLException e){
                System.out.println("Error Finding Admin by Admin ID: " + e);
            }
            return user;
        }
    }