import static org.junit.Assert.*;

import org.junit.Test;


public class SystemControllerTest {
	
	/*@Test
	public void generateCustomers(){
		
		SystemController.generateCustomers();
		assertEquals(10, SystemController.getBuilding().getNumberOfCustomers());
    	assertEquals(10, SystemController.getBuilding().getCustomerList().size());
    	
    	// tests if IDs are assigned correctly
    	assertEquals(0, SystemController.getBuilding().getCustomerList().get(0).getId());
    	assertEquals(3, SystemController.getBuilding().getCustomerList().get(3).getId());
    	assertEquals(7, SystemController.getBuilding().getCustomerList().get(7).getId());
    	assertEquals(9, SystemController.getBuilding().getCustomerList().get(9).getId());
	}*/

	@Test
	public void defaultStrategy(){
		
		Building b1 = SystemController.getBuilding();
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();

		Elevator e1 = b1.getElevator();
		e1.setDirection(1);
		
		// tests defaultStrategy in single direction
		c1.setDestinationFloor(5);
		c2.setDestinationFloor(5);
		c3.setDestinationFloor(8);
		
		// tests defaultStrategy in return direction
		c4.setCurrentFloor(6);
		c4.setDestinationFloor(2);

		b1.addCustomer(c1);
		b1.addCustomer(c2);
		b1.addCustomer(c3);
		b1.addCustomer(c4);
	
		int count = SystemController.defaultStrategy();
		assertEquals(true, c1.isFinished());
		assertEquals(true, c2.isFinished());
		assertEquals(true, c3.isFinished());
		assertEquals(true, c4.isFinished());

		System.out.println("Count: "+count);

	}
}
