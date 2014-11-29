import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SystemControllerTest {

	final int FLOORS = 10;

	@Test
	public void generateCustomers() {

		SystemController.generateCustomers();
		// test number of customers
		assertEquals(10, SystemController.getBuilding().getCustomerList().size());
    	SystemController.clearSystemData();

	}

	@Test
	public void defaultStrategy() {

		SystemController.generateCustomers();
		Building b1 = SystemController.getBuilding();
		Elevator e1 = b1.getElevator();

		// test status
		assertEquals(false, SystemController.getSimulationStatus());

		e1.setDirection(1); // refactor

		SystemController.defaultStrategy();
		assertEquals(true, SystemController.getSimulationStatus());

		System.out.println("Count: " + SystemController.getEfficiencyCounter());

		SystemController.clearSystemData();
	}

	@Test
	public void alternativeStrategy() {

		SystemController.generateCustomers();
		Building b1 = SystemController.getBuilding();
		Elevator e1 = b1.getElevator();

		// test status
		assertEquals(false, SystemController.getSimulationStatus());

		e1.setDirection(1); // refactor

		SystemController.alternativeStrategy();
		assertEquals(true, SystemController.getSimulationStatus());

		System.out.println("Count: " + SystemController.getEfficiencyCounter());

		SystemController.clearSystemData();

	}
}
