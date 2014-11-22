import static org.junit.Assert.*;

import org.junit.Test;



public class ElevatorTest {
	
	@Test
	public void move() {
		Elevator e1 = new Elevator();
		e1.setCurrentFloor();
		// direction up
		e1.setDirection(1);
		e1.move();
	
		Elevator e2 = new Elevator();
		e2.setCurrentFloor(1);
		// direction down
		e2.setDirection(-1);
		e2.move();

		assertEquals(1, e1.getCurrentFloor());
		assertEquals(0, e2.getCurrentFloor());

	}
	
	@Test
	public void switchDirection() {
		Elevator e1 = new Elevator();
		e1.setCurrentFloor();
		// direction up
		e1.setDirection(1);
		e1.switchDirection();
	
		Elevator e2 = new Elevator();
		e2.setCurrentFloor(10);
		// direction down
		e2.setDirection(-1);
		e2.switchDirection();

		assertEquals(-1, e1.getDirection());
		assertEquals(1, e2.getDirection());

	}
	
	@Test
	public void unload() {
		Elevator e = new Elevator();
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		
		assertEquals(0, e.getNumberOfCustomers());
		
		// 2 customers get in
		e.customerJoins(c1);
		e.customerJoins(c2);
		// tests the id of the 2 customers
		assertEquals(1, c1.getId());
		assertEquals(2, c2.getId());
		
		c1.setDestinationFloor(1);
		c2.setDestinationFloor(2);

		assertEquals(2, e.getNumberOfCustomers());
		// move elevator up by 1 floor
		e.move();
		e.unload();
		assertEquals(1, e.getNumberOfCustomers());
		// move elevator up by 1 floor
		e.move();
		e.unload();
		assertEquals(0, e.getNumberOfCustomers());
		
	}

}

