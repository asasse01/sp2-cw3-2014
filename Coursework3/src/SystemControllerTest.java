import static org.junit.Assert.*;

import org.junit.Test;


public class SystemControllerTest {
	
	@Test
	public void generateCustomers(){
		Building b = new Building();
		b.setNumberOfCustomers();
		generateCustomers();
		
    	assertEquals(10, b.getCustomerList().size());
    	
    	// tests if IDs are assigned correctly
    	assertEquals(0, b.getCustomerList().get(0).getId());
    	assertEquals(3, b.getCustomerList().get(3).getId());
    	assertEquals(7, b.getCustomerList().get(7).getId());
    	assertEquals(9, b.getCustomerList().get(9).getId());
	}

}
