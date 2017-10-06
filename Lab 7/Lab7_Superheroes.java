package lab7;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab7_Superheroes {

	public static void main(String[] args) {

		try {
			// datasource
			MysqlDataSource mysqlDS = new MysqlDataSource();
			// Connection
			mysqlDS.setURL("jdbc:mysql://localhost:3306/superheroes");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("");
			// create connection
			Connection conn = mysqlDS.getConnection();
			// create statement
			Statement myStmt = conn.createStatement();
			// Query
			String query = "select * from superhero_table";
			// run query
			ResultSet rs = myStmt.executeQuery(query);
			while (rs.next()) {
				// code for getting table coloumns
				String Name = rs.getString("Name");
				String FName = rs.getString("Real_First_Name");
				String SName = rs.getString("Real_Surname");
				Date dob = rs.getDate(4);
				float powers = rs.getFloat(5);

				System.out.println("\nName = " + Name + ", FName = " + FName + ", SName = " + SName + ", Dob = " + dob
						+ ", Powers = " + powers);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}

}
