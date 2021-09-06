package edu.bu.met.cs665.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.bu.met.cs665.notificationsystem.DeliveryRequest;
import edu.bu.met.cs665.notificationsystem.Driver;
import edu.bu.met.cs665.notificationsystem.FlowerShop;

public class TestNotificationSystem {

	//Objects for Flower shop and Drivers are created
	FlowerShop shop = new FlowerShop("Free Green House");
	Driver driver1 = new Driver(1,"Mike");
	Driver driver2 = new Driver(2,"Lou");
	Driver driver3 = new Driver(3,"Sue");
	Driver driver4 = new Driver(4,"Will");
	Driver driver5 = new Driver(5,"Emily");
	
	/* Tests for:
	 *  sending out a single delivery request and notify all drivers regarding the delivery request
	 *  and assigning the delivery request based on first come first served principles
	 * */
	@Test
	public void testFlowerShop() {
				
		//registering 5 drivers
		shop.registerDriver(driver1);
		shop.registerDriver(driver2);
		shop.registerDriver(driver3);
		shop.registerDriver(driver4);
		shop.registerDriver(driver5);
		
		//removing driver
		shop.removeDriver(driver1);
		shop.notifyDriver();	//notifying drivers regarding the delivery requests
		
		assertEquals(shop.getTotalDrivers(),4);	//checking total numbers of drivers after removing 1 driver
		
		//creating and setting delivery request object
		DeliveryRequest request1 = new DeliveryRequest("Perry", "12 Blah Street, Frankton, ZZ", "(565)-234-3557", "Rose pot, Butterfly Weed Pot", 24.76);
		shop.setDeliveryRequest(request1);
		shop.assign(request1); 	//assigning delivery requests based on first come first served principles
				
		assertEquals(shop.getDeliveryRequest(),driver2.getDelivery(request1));	//checking the delivery request between shop and deriver 
		assertEquals(shop.getTotalDrivers(),3);	//checking total numbers of drivers after removing 1 driver
		
		//creating and setting delivery request object
		DeliveryRequest request2 = new DeliveryRequest("Abbie", "2 Blah Street, Franklin, XX", "(560)-111-4536", "Hibiscus flower Pot, Basil Herb Pot", 30.05);
		shop.notifyDriver();
		shop.setDeliveryRequest(request2);
		shop.assign(request2);
		
		assertEquals(shop.getDeliveryRequest(),driver3.getDelivery(request2));
		assertEquals(shop.getTotalDrivers(),2);	//checking total numbers of drivers after removing 1 driver
		
		//creating and setting delivery request object
		DeliveryRequest request3 = new DeliveryRequest("Garry", "1 Blah Street, Munchkin, XX", "(345)-876-5468", "Apple Tree Pot, Potting Soil", 13.89);
		shop.notifyDriver();
		shop.setDeliveryRequest(request3);
		shop.assign(request3);	//assigning delivery requests
		
		assertEquals(shop.getDeliveryRequest(),driver4.getDelivery(request3));
		assertEquals(shop.getTotalDrivers(),1);	//checking total numbers of drivers after removing 1 driver
		
		//creating and setting delivery request object
		DeliveryRequest request4 = new DeliveryRequest("AJ", "2 Blah Street, Circus, XX", "(908)-123-7799", "Grow Fertilizer, Weed Flower Pot, Garden Gloves", 44.16);
		shop.notifyDriver();
		shop.setDeliveryRequest(request4);
		shop.assign(request4);	//assigning delivery requests
		
		assertEquals(shop.getDeliveryRequest(),driver5.getDelivery(request4));
		assertEquals(shop.getTotalDrivers(),0);	//checking total numbers of drivers after removing 1 driver
		
		//creating and setting delivery request object
		DeliveryRequest request5 = new DeliveryRequest("TEST", "Test for NO drivers", "XXX-000-YYYY", "Test", 0);
		shop.notifyDriver();
		shop.setDeliveryRequest(request5);
		shop.assign(request5);	//assigning delivery requests
	}
	
	
}
