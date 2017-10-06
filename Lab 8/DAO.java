package lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DAO {
	private MysqlDataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		this.mysqlDS = new MysqlDataSource();
		this.mysqlDS.setURL("jdbc:mysql://localhost:3306/superheroes");
		this.mysqlDS.setUser("root");
		this.mysqlDS.setPassword("");
	}

	/* ======================================================================================================
	 * Public Methods
	 * ====================================================================================================== */
	public ArrayList<Superhero> getSuperheroDetails(String name) throws Exception{
		ArrayList<Superhero> superheroes = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * " +
					 "from superhero_table " +
					 "where name = ? ");
		myStmt.setString(1, name);
		ResultSet rs = myStmt.executeQuery();
		
		while( rs.next() ) {
			name = rs.getString("name");
			String fName = rs.getString("real_first_name");
			String sName = rs.getString("real_surname");
			String dob = rs.getString("dob");
			double powers = rs.getDouble("powers");
			superheroes.add(new Superhero(name, fName, sName, dob, powers));
		}
		return superheroes;
	}
}
