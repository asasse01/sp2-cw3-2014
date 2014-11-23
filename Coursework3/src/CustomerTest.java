

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void getInAndOut(){
		Customer c = new Customer(10, 3, 4);
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
		Customer c = new Customer(10);
		assertTrue((c.getStartingFloor() < 10));
		assertTrue((c.getStartingFloor() >= 0));
		assertTrue((c.getDestinationFloor() < 10));
		assertTrue((c.getDestinationFloor() >= 0));
	}
	
	public void startingFloorIsDestinationFloor(){
		Customer c = new Customer(4, 3, 3);
		assertEquals(true, c.isFinished());
	}
}
