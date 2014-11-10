
import static org.junit.Assert.*;

import org.junit.Test;

public class ElevatorTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void moveTest() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void getNumberOfFloors(){
		Building b = new Building();
		b.setNumberOfFloors();
		assertEquals(10, b.getElevator().getNumberOfFloors());
	}

}
