

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void getInAndOut(){
		Customer c = new Customer();
		assertEquals(false, c.getStatus());
		c.getsIn();
		assertEquals(true, c.getStatus());
		c.getsOut();
		assertEquals(false, c.getStatus());
	}

}
