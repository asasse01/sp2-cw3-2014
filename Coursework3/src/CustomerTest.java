

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {

	final int FLOORS = 10;

	@Test
	public void getInAndOut(){
		Customer c = new Customer(FLOORS, 3, 4);
		assertEquals(false, c.getStatus());
		assertEquals(false, c.isFinished());
		c.getsIn();
		assertEquals(true, c.getStatus());
		c.getsOut();
		assertEquals(false, c.getStatus());
		assertEquals(true, c.isFinished());
	}

	@Test
	public void randomFloors(){
		SystemController.generateBuilding();
		Customer c = new Customer();
		assertTrue((c.getStartingFloor() < 10));
		assertTrue((c.getStartingFloor() >= 0));
		assertTrue((c.getDestinationFloor() < 10));
		assertTrue((c.getDestinationFloor() >= 0));
		SystemController.clearSystemData();
	}

	@Test
	public void startingFloorIsDestinationFloor(){
		Customer c = new Customer(4, 3, 3);
		assertEquals(true, c.isFinished());
	}

	@Test
	public void randomExludes13thFloor(){
		SystemController.generateBuilding(14);
		Customer c = new Customer();
		int randomFloor;
		for (int i = 0; i < 100000; i++) {
			randomFloor = c.pickRandomFloor(SystemController.getBuilding().getFloorList());
			assertTrue((randomFloor != 13));
		}
		SystemController.clearSystemData();
	}
}
