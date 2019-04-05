package com.training.bean;

public class LoginBean {
	// private String userName;
	// private String password;
	private String productname;
	private String Metatagtitle;
	private String Model;
	private String price;
	private String Quantity;
	private String Categories;

	public LoginBean() {
	}

	public LoginBean(String productname, String Metatagtitle, String Model, String price, String Quantity,
			String Categories) {
		super();
		// this.userName=userName;
		// this.password=password;
		this.productname = productname;
		this.Metatagtitle = Metatagtitle;
		this.Model = Model;
		this.price = price;
		this.Quantity = Quantity;
		this.Categories = Categories;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public String getMetatagtitle() {
		return Metatagtitle;
	}

	public void setMetatagtitle(String Metatagtitle) {
		this.Metatagtitle = Metatagtitle;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	}

	public String getCategories() {
		return Categories;
	}

	public void setCategories(String Categories) {
		this.Categories = Categories;
	}

	@Override
	public String toString() {
		return "LoginBean [productname=" + productname + ", Metatagtitle=" + Metatagtitle + ", Model="
				+ Model  + ", price=" + price + ", Quantity=" + Quantity + ", Categories="
				+ Categories + "]";
	}

}
