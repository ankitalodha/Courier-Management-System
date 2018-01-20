package application;

import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.stage.Window;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PlaceOrderDAO extends DataSource{

	public String findCostBySrcDest(String sourceState, String sourceCity, String destCity, String destState) {
		String cost = null;
		String query = "SELECT * FROM ratechart WHERE sourceState ='"+sourceState+"' AND sourceCity ='"+sourceCity+"' AND destState ='"+destState+"' AND destCity ='"+destCity+"'";
	      Statement st = null;
	      System.out.println(query);
		try {
			st = connection.createStatement();
	      // execute the query, and get a java resultset
	      ResultSet rs = null;
			rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(6));
			  	cost = rs.getString("cost");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return cost;
    }
}
