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

		SystemController.setupSimulation();
		Elevator e1 = SystemController.getBuilding().getElevator();

		// test status
		assertEquals(false, SystemController.getSimulationStatus());

		e1.setDirection(1);

		SystemController.defaultStrategy();
		assertEquals(true, SystemController.getSimulationStatus());

		System.out.println("Count: " + SystemController.getEfficiencyCounter());

		SystemController.clearSystemData();
	}

	@Test
	public void alternativeStrategy() {

		SystemController.setupSimulation();
		Elevator e1 = SystemController.getBuilding().getElevator();

		// test status
		assertEquals(false, SystemController.getSimulationStatus());

		e1.setDirection(1);

		SystemController.alternativeStrategy();
		assertEquals(true, SystemController.getSimulationStatus());

		System.out.println("Count: " + SystemController.getEfficiencyCounter());

		SystemController.clearSystemData();

	}
}
