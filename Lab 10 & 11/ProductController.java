package lab10;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
public class ProductController {
	
	//#{p.prodid}
	//#{p.proddesc}
	//FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
	//FacesContext.getCurrentInstance().addMessage(null, message);

	private ArrayList<Product> products;
	private DAO dao;

	public ProductController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void loadProducts() throws Exception {
		products = dao.getProductDetails();
	}

	public String addProduct(Product p) throws Exception {
		try 
		{
			dao.addProduct(p);
			//return "hello";
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
		

	}

	public String updateProduct(Product p) throws Exception {
		try {
			dao.updateProduct(p);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String deleteProduct(Product p) throws Exception {

		try {
			dao.deleteProduct(p);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}
}
