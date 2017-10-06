package lab7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Lab7_employee_kin {

	public static void main(String[] args) {

		try {
			// datasource
			MysqlDataSource mysqlDS = new MysqlDataSource();
			// Connection
			mysqlDS.setURL("jdbc:mysql://localhost:3306/employee_kin");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("");
			// create connection
			Connection conn = mysqlDS.getConnection();
			// create statement
			Statement myStmt = conn.createStatement();
			// Query
			String query = "Select e.ename, s.salary, k.nok_name "
					+ "From employee_table e "
					+ "Left join next_of_Kin_table k "
					+ "On e.NextOfKin = k.NOK_ID "
					+ "Left join salary s On s.eid = e.eid";
			// run query
			ResultSet rs = myStmt.executeQuery(query);
			while (rs.next()) {
				// code for getting table coloumns
				String Name = rs.getString("ename");
				String NOKName = rs.getString("nok_name");
				float salary = rs.getFloat(2);

				System.out.println("\nName = " + Name + ", Nok Name = " + NOKName + ", Salary = " + salary);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}
}
