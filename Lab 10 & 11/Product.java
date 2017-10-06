package lab10;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Product {
	//Variables--------------------------------------------
	private int prodid;
	private String proddesc;
	
	//constructors-----------------------------------------
	public Product() {
	}

	public Product(int prodid, String proddesc) {
		super();
		this.prodid = prodid;
		this.proddesc = proddesc;
	}

	//Accessors--------------------------------------------
	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProddesc() {
		return proddesc;
	}

	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	
	
	//Extra------------------------------------------------
	private int custid;
	
	public Product(int custid, String cname, int ord) 
	{
		super();
		this.custid = custid;
		this.cname = cname;
		this.ordid = ord;
	}

	private String cname;
	private int ordid;

	/**
	 * @return the custid
	 */
	public int getCustid() {
		return custid;
	}

	/**
	 * @param custid the custid to set
	 */
	public void setCustid(int custid) {
		this.custid = custid;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the ordid
	 */
	public int getOrdid() {
		return ordid;
	}

	/**
	 * @param ordid the ordid to set
	 */
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}

}
