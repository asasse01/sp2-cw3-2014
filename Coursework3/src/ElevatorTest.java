import static org.junit.Assert.*;

import org.junit.Test;



public class ElevatorTest {

	@Test
	public void customerGetsIn() {
		Customer c = new Customer();
		assertEquals(0, Elevator.getNumberOfCustomers());
		Elevator.customerGetsIn(c);
		assertEquals(1, Elevator.getNumberOfCustomers());
		
	}
	
	@Test
	public void customerGetsOut() {
		
	}
	
//	@Test
//	public void moveTest() {
//		fail("Not yet implemented");
//	}

}
