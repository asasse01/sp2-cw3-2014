
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
	
	@Test
	public void generateCustomers(){
		Building b = new Building();
		b.setNumberOfCustomers();
		b.generateCustomers();
		
    	assertEquals(10, b.getListOfCustomers().size());
    	assertEquals(0, b.getListOfCustomers().get(0).getId());
    	assertEquals(3, b.getListOfCustomers().get(3).getId());
    	assertEquals(7, b.getListOfCustomers().get(7).getId());
    	assertEquals(9, b.getListOfCustomers().get(9).getId());
	}
}



