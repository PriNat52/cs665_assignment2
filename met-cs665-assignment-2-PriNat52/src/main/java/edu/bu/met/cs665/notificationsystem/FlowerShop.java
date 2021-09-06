package edu.bu.met.cs665.notificationsystem;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/*Observer Pattern - Concrete Subject implements Observable/Subject Interface*/
public class FlowerShop implements ShopObservable {

	private static Logger logger = Logger.getLogger(FlowerShop.class);
	
	private ArrayList<DriverObserver> driverlist = new ArrayList<DriverObserver>();
	private DeliveryRequest deliveryrequest;
	private String shopname;
	private int ordercount = 0;
	
	public FlowerShop(String name) {
		this.shopname = name;
		this.ordercount = 0;
	}
	
	public void assign(DeliveryRequest request){
		/*assigning the delivery request based on first come first served principles*/
		
		ordercount++;
		logger.info("Order:"+"("+ordercount+") "+"Delivery Request for "+shopname);
		
		logger.debug(request.toString());
		
		if(driverlist.size() == 0) {
			
			logger.fatal("!!! All the Drivers are Busy, Your Order is on hold !!!");
			
		}else if(driverlist.size() != 0) {

			DriverObserver a= driverlist.get(0);
			logger.info("*** Delivery Request Taken: "+a);
			driverlist.remove(a);
		}
	}
	
	@Override
	public void registerDriver(DriverObserver driver) {
		/*adds driver from the array list*/
		
		driverlist.add(driver);
		logger.debug("Registered Driver online: " + driver.toString());
	}

	@Override
	public void removeDriver(DriverObserver driver) {
		/*removes driver from the array list*/
		
		driverlist.remove(driver);
		logger.fatal("Driver offline: " + driver.toString());
	}

	@Override
	public void notifyDriver() {
		/*notify all drivers regarding the delivery request*/
		
		for(DriverObserver driver : driverlist) 
			driver.updateDriver(deliveryrequest);
		
		logger.trace("{{--"+shopname+": Delivery Request Notificaion Sent to all drivers"+"--}}");
	}

	public void setDeliveryRequest(DeliveryRequest request) {
		/*sets the delivery request*/
		this.deliveryrequest = request;
	}

	public DeliveryRequest getDeliveryRequest() {
		/*returns the delivery request*/
		return deliveryrequest;
	}

	public int getTotalDrivers() {
		/*finds total number of drivers*/
		return driverlist.size();
	}
}
