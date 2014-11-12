import static org.junit.Assert.*;

import org.junit.Test;


public class SystemControllerTest {
	
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
