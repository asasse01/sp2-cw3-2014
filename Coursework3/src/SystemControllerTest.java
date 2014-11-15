import static org.junit.Assert.*;

import org.junit.Test;


public class SystemControllerTest {
	
	@Test
	public void generateCustomers(){
		
		SystemController.generateCustomers();
		assertEquals(10, SystemController.getBuilding().getNumberOfCustomers());
    	assertEquals(10, SystemController.getBuilding().getCustomerList().size());
    	
    	// tests if IDs are assigned correctly
    	assertEquals(0, SystemController.getBuilding().getCustomerList().get(0).getId());
    	assertEquals(3, SystemController.getBuilding().getCustomerList().get(3).getId());
    	assertEquals(7, SystemController.getBuilding().getCustomerList().get(7).getId());
    	assertEquals(9, SystemController.getBuilding().getCustomerList().get(9).getId());
	}

}
