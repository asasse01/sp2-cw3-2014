
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BuildingTest {

	final int FLOORS = 10;

	@Test
	public void setNumberOfFloors(){
		Building b = new Building();
		b.setNumberOfFloors(100);
    	assertEquals(100, b.getNumberOfFloors());

    	b.setNumberOfFloors();
    	assertEquals(10, b.getNumberOfFloors());
	}

	@Test
	public void customerJoinsAndLeaves(){
		SystemController.generateBuilding();
		Building b = SystemController.getBuilding();
		assertEquals(0, b.getCustomerList().size());
		Customer c = new Customer();
		b.addCustomer(c);
		assertEquals(1, b.getCustomerList().size());
		SystemController.clearSystemData();
	}

}



