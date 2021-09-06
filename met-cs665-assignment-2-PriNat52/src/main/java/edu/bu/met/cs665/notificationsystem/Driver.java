package edu.bu.met.cs665.notificationsystem;

/*Observer Pattern - Concrete Observer implements Observer Interface*/
public class Driver implements DriverObserver{
	
	private int id;
	private String drivername;
	private DeliveryRequest deliveryrequest;
	
	public Driver(int id, String name) {
		this.setDrivername(name);
		this.setId(id);
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public DeliveryRequest getDeliveryrequest() {
		return deliveryrequest;
	}
	
	public DeliveryRequest getDeliveryRequest(DeliveryRequest deliveryrequest) {
		this.setDeliveryrequest(deliveryrequest);
		return deliveryrequest;
	}
	
	public void setDeliveryrequest(DeliveryRequest deliveryrequest) {
		this.deliveryrequest = deliveryrequest;
	}

	@Override
	public void updateDriver(DeliveryRequest deliveryrequest) {
		this.setDeliveryrequest(deliveryrequest);
	}

	public DeliveryRequest getDelivery(DeliveryRequest deliveryrequest) {

		return deliveryrequest;	
	}
	
	public String toString() {
		return "ID: "+id+" Name: "+drivername;
	}

}
