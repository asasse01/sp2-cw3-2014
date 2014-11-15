import static org.junit.Assert.*;

import org.junit.Test;



public class ElevatorTest {

	@Test
	public void customerGetsInAndOut() {
		Customer c0 = new Customer();
		Customer c1 = new Customer();
		//TODO: setId() should be run automatically every time a Customer is created
		c0.setId();
		c1.setId();
		assertEquals(0, Elevator.getNumberOfCustomers());
		// 2 customers get in
		Elevator.customerJoins(c0);
		Elevator.customerJoins(c1);
		// tests the id of the 2 customers
		assertEquals(0, c0.getId());
		assertEquals(1, c1.getId());
		// tests the number of customers inside the elevator
		assertEquals(2, Elevator.getNumberOfCustomers());
		// customer 0 gets out
		Elevator.customerLeaves(c0);
		// tests the number of customers in elevator
		assertEquals(1, Elevator.getNumberOfCustomers());
		// tests if the customer remaining in the elevator is the correct one by his ID
		assertEquals(1, Elevator.getRegisterList().get(0).getId());
	}
	
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
}
