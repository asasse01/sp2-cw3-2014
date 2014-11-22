

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void getInAndOut(){
		Customer c = new Customer(10);
		assertEquals(false, c.getStatus());
		assertEquals(false, c.isFinished());
		c.getsIn();
		assertEquals(true, c.getStatus());
		c.getsOut();
		assertEquals(false, c.getStatus());
		assertEquals(true, c.isFinished());
	}
	
	@Test
	public void startingFloorIsDestinationFloor(){
		Customer c = new Customer(4, 3, 3);
		assertEquals(true, c.isFinished());
	}
}
