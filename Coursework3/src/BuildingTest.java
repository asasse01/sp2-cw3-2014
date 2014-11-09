
import static org.junit.Assert.*;

import org.junit.Test;


public class BuildingTest {

	@Test
	public void setNumberOfFloors(){
		Building b = new Building();
		b.setNumberOfFloors(100);
    	assertEquals(100, b.getNumberOfFloors());
 
    	b.setNumberOfFloors();
    	assertEquals(10, b.getNumberOfFloors());
	}
	
//	@Test
//	public void setNumberOfCustomers(){
//		Customer c = new Customer();
//		c.setNumberOfCustomers(100);
//    	assertEquals(100, c.getNumberOfCustomers());
// 
//    	c.setNumberOfCustomers();
//    	assertEquals(10, c.getNumberOfCustomers());
//	}
}



