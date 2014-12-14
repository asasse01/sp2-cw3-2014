import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ElevatorTest.class, CustomerTest.class, BuildingTest.class, SystemControllerTest.class
})
public class TestSuite {
}