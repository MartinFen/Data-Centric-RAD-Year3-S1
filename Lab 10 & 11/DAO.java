package lab10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {

	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/employeesdb14";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public void deleteProduct(Product p) throws SQLException {
		// add pass through parameter to method for update insert & delete

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("delete from product where PRODID ='"+p.getProdid()+"' and DESCRIP ='"+p.getProddesc()+"'");
		//PreparedStatement myStmt = conn.prepareStatement("delete from product where PRODID =? and DESCRIP =?");

		myStmt.executeUpdate();
	}

	public void updateProduct(Product p) throws SQLException {
	 
	 Connection conn = mysqlDS.getConnection(); 
	 PreparedStatement myStmt = conn.prepareStatement("update product set DESCRIP ? where PRODID like ?");
	 
	 //preparedStatement.setString(1, "mkyong_new_value");
	 //preparedStatement.setInt(2, 1001);
	 myStmt.setInt(1, p.getProdid()); 
	 myStmt.setString(2, p.getProddesc());
	 
	 myStmt.executeUpdate();  
	}

	public void addProduct(Product p) throws SQLException {
		// add pass through parameter to method for update insert & delete

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO product values(?, ?)");

		myStmt.setInt(1, p.getProdid());
		myStmt.setString(2, p.getProddesc());

		myStmt.executeUpdate();
	}

	public ArrayList<Product> getProductDetails() throws Exception {

		ArrayList<Product> products = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select C.CUSTID, C.NAME, O.ORDID "
				+ "FROM Customer C "
				+ "Inner Join ORD O "
				+ "ON C.CUSTID = O.CUSTID; ");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("CUSTID");
			String pname = rs.getString("NAME");
			int ord = rs.getInt("ORDID");

			products.add(new Product(id, pname, ord));
		}

		return products;
	}

}
