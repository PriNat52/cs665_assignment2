package edu.bu.met.cs665.notificationsystem;

/*Observer Pattern - Observable/Subject Interface*/
public interface ShopObservable {
	
	public void registerDriver(DriverObserver driver);
	public void removeDriver(DriverObserver driver);
	public void notifyDriver();
	
}
