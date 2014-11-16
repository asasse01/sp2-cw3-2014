import static org.junit.Assert.*;

import org.junit.Test;


public class SystemControllerTest {
	
	@Test
	public void generateCustomers(){
		
		SystemController.generateCustomers();
		assertEquals(10, SystemController.getBuilding().getNumberOfCustomers());
    	assertEquals(10, SystemController.getBuilding().getCustomerList().size());
    	
    	// tests if IDs are assigned correctly
    	assertEquals(0, SystemController.getBuilding().getCustomerList().get(0).getId());
    	assertEquals(3, SystemController.getBuilding().getCustomerList().get(3).getId());
    	assertEquals(7, SystemController.getBuilding().getCustomerList().get(7).getId());
    	assertEquals(9, SystemController.getBuilding().getCustomerList().get(9).getId());
	}

	@Test
	public void defaultStrategy(){
		Elevator e1 = new Elevator(); // should be new Building?

		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();

		c1.setDestinationFloor(5);
		c2.setDestinationFloor(5);
		c3.setDestinationFloor(8);

		e1.customerJoins(c1);
		e1.customerJoins(c2);
		e1.customerJoins(c3);

		// check starting number is correct
		assertEquals(3, e1.getNumberOfCustomers());
		
		e1.defaultStrategy();
		assertEquals(0, e1.getNumberOfCustomers());
	}
}
