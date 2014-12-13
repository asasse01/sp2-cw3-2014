import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class ElevatorTest {

	final int FLOORS = 10;

	@Test
	public void move() {
		Elevator e1 = new Elevator(FLOORS);
		e1.setCurrentFloor();
		// direction up
		e1.setDirection(1);
		e1.move();

		Elevator e2 = new Elevator(FLOORS);
		e2.setCurrentFloor(1);
		// direction down
		e2.setDirection(-1);
		e2.move();

		assertEquals(1, e1.getCurrentFloor());
		assertEquals(0, e2.getCurrentFloor());
	}
	@Test
	public void switchDirection() {
		Elevator e1 = new Elevator(FLOORS);
		e1.setCurrentFloor();
		// direction up
		e1.setDirection(1);
		e1.switchDirection();

		Elevator e2 = new Elevator(FLOORS);
		e2.setCurrentFloor(10);
		// direction down
		e2.setDirection(-1);
		e2.switchDirection();

		assertEquals(-1, e1.getDirection());
		assertEquals(1, e2.getDirection());
	}
	@Test
	public void load() {
		Building b = new Building();
		Elevator e = b.getElevator();
		Customer c1 = new Customer(FLOORS, 0, 2);
		b.addCustomer(c1);

		// tests that there are no customers in the elevator to begin with
		assertEquals(0, e.getNumberOfCustomers());

		e.load(b.getCustomerList());
		assertEquals(1, e.getNumberOfCustomers());
	}
	@Test
	public void unload() {
		Elevator e = new Elevator(FLOORS);
		Customer c1 = new Customer(FLOORS, 0, 1);
		Customer c2 = new Customer(FLOORS, 0, 2);

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
		assertEquals(1, c1.getCurrentFloor());
		e.unload();
		assertEquals(1, e.getNumberOfCustomers());
		// move elevator up by 1 floor
		e.move();
		assertEquals(2, c2.getCurrentFloor());
		e.unload();
		assertEquals(0, e.getNumberOfCustomers());
	}
	@Test
	public void firstOrLastFloor() {

		Building b = new Building(2);
		Elevator e = b.getElevator();
		assertEquals(0, e.getCurrentFloor());
		e.move();
		assertEquals(1, e.getCurrentFloor());
		e.move();
		assertEquals(0, e.getCurrentFloor());
		e.move();
		assertEquals(1, e.getCurrentFloor());
		e.move();
		assertEquals(0, e.getCurrentFloor());
	}
}

