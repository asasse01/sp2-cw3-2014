import static org.junit.Assert.*;

import org.junit.Test;

public class SystemControllerTest {
	
	final int FLOORS = 10;
	
	@Test
	public void defaultStrategy() {
		
		SystemController.generateCustomers();
		Building b1 = SystemController.getBuilding();
		Elevator e1 = b1.getElevator();
		
		// test status
		assertEquals(false, SystemController.getSimulationStatus());
		// test number of customers
		assertEquals(10, SystemController.getBuilding().getCustomerList().size());
		// tests if IDs are assigned correctly
    	assertEquals(1, SystemController.getBuilding().getCustomerList().get(0).getId());
    	assertEquals(4, SystemController.getBuilding().getCustomerList().get(3).getId());
    	assertEquals(8, SystemController.getBuilding().getCustomerList().get(7).getId());
    	assertEquals(10, SystemController.getBuilding().getCustomerList().get(9).getId());
		
		e1.setDirection(1); // refactor

		SystemController.defaultStrategy();
		assertEquals(true, SystemController.getSimulationStatus());

		System.out.println("Count: " + SystemController.getEfficiencyCounter());

	}
	
//	@Test
//	public void alternativeStrategy() {
//
//		Building b1 = SystemController.getBuilding();
//
//		Customer c1 = new Customer(FLOORS);
//		Customer c2 = new Customer(FLOORS);
//		Customer c3 = new Customer(FLOORS);
//		Customer c4 = new Customer(FLOORS);
//
//		Elevator e1 = b1.getElevator();
//		e1.setDirection(1);
//
//		// tests defaultStrategy in single direction
//		c1.setDestinationFloor(5);
//		c2.setDestinationFloor(5);
//		c3.setDestinationFloor(8);
//
//		// tests defaultStrategy in return direction
//		c4.setCurrentFloor(6);
//		c4.setDestinationFloor(2);
//
//		b1.addCustomer(c1);
//		b1.addCustomer(c2);
//		b1.addCustomer(c3);
//		b1.addCustomer(c4);

//		int count = SystemController.alternativeStrategy();
//		assertEquals(true, c1.isFinished());
//		assertEquals(true, c2.isFinished());
//		assertEquals(true, c3.isFinished());
//		assertEquals(true, c4.isFinished());

//		System.out.println("Count: " + count);

//	}
}
