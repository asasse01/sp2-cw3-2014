
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
	
	// to test adding customers
}



