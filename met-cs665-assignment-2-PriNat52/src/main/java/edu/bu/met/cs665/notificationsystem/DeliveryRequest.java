package edu.bu.met.cs665.notificationsystem;

/* creating and setting in delivery request class */
public class DeliveryRequest {

	private String name;
	private String address;
	private String mobile;
	private String products;
	private double totalamount;	
	
	public DeliveryRequest(String customername, String address, String mobile, String products, double totalamount) {
		this.setName(customername);
		this.setAddress(address);
		this.setMobile(mobile);
		this.setProducts(products);
		this.setTotalamount(totalamount);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String toString() {
		return "Customer Name: "+name+" Address: "+address+" Call: "+mobile+" Ordered Products:"+products+ " Amount: $" +totalamount;
		
	}
}

