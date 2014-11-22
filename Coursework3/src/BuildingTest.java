
import static org.junit.Assert.*;

import org.junit.Test;


public class BuildingTest {

	@Test
	public void setNumberOfFloors(){
		Building b = new Building();
		b.setNumberOfFloors(100);
    	assertEquals(100, b.getNumberOfFloors());
 
    	b.setNumberOfFloors();
    	assertEquals(10, b.getNumberOfFloors());
	}
	
	@Test
	public void customerJoinsAndLeaves(){
		Building b = new Building();
		assertEquals(0, b.getCustomerList().size());
		Customer c = new Customer();
		b.addCustomer(c);
		assertEquals(1, b.getCustomerList().size());
	}
	
	@Test
	public void load() {
		Building b = new Building();
		Customer c1 = new Customer();
		b.addCustomer(c1);
		c1.setCurrentFloor(0);
		c1.setDestinationFloor(2);

		// tests that there are no customers in the elevator to begin with
		assertEquals(0, b.getElevator().getNumberOfCustomers());
		
		b.load();
		assertEquals(1, b.getElevator().getNumberOfCustomers());

	}
}



