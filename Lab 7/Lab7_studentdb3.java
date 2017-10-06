package lab7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Lab7_studentdb3 {

	public static void main(String[] args) {

		try {
			// datasource
			MysqlDataSource mysqlDS = new MysqlDataSource();
			// Connection
			mysqlDS.setURL("jdbc:mysql://localhost:3306/studentdb3");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("");
			// create connection
			Connection conn = mysqlDS.getConnection();
			// create statement
			Statement myStmt = conn.createStatement();
			// Query
			String query = "Select s.student_name, c.course_name, col.college_name, col.county, co.county_name "
					+ "From student_table s " 
					+ "Inner join course_table c " 
					+ "ON s.course_id = c.course_id "
					+ "Inner join college_table col " 
					+ "On c.college_id = col.college_id " 
					+ "Inner join county_table co "
					+ "On col.county = co.county_name";
			// run query
			ResultSet rs = myStmt.executeQuery(query);
			while (rs.next()) {
				// code for getting table coloumns
				String sName = rs.getString("student_name");
				String cName = rs.getString("course_name");
				String colName = rs.getString("college_name");
				String coName1 = rs.getString("county");
				String coName2 = rs.getString("county_name");

				System.out.println("\n " + sName + ", " + cName + ", " + colName + ", " + coName1 + ", " + coName2);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}

}
