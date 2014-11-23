import java.util.ArrayList;


public class SystemController {
	private static Building building = new Building();
	final static int FLOORS = 10;
	static boolean simulationFinished = false;
	private static int efficiencyCounter;
	
	public static void main(String[] args) {
		
		// TODO:  ask User the number of Customers
		generateCustomers();
	}
	
	public static int numberOFCustomers(){
		return 10;
	}
	
	public static boolean getSimulationStatus(){
		return simulationFinished;
	}

	public static void setSimulationStatus(boolean status){
		SystemController.simulationFinished = status;
	}
	
	public static void generateCustomers(){ 
		// setting number of customer
		// should this be done here and not in the building ?
		building.setNumberOfCustomers(); 
		
		while (building.getCustomerList().size() != building.getNumberOfCustomers()){ // to do recursively
			Customer customer = new Customer(FLOORS);
			// customer.setCurrentFloor();
			// customer.setDestinationFloor();
			System.out.println(customer.getId()); // to be removed
			building.addCustomer(customer);
		}
	}
	
	public static Building getBuilding(){
		return building;
	}
	

	
	public static void defaultStrategy() {
		
		setEfficiencyCounter(0);
		
		Building building = getBuilding();
		
	
		while (!simulationFinished) {
			do {
			// customer gets out if at destination floor
			building.getElevator().unload();
			// customer gets in if at same floor as elevator
			building.load();

			setEfficiencyCounter(getEfficiencyCounter() + 1); // to refactor
			building.getElevator().move();
			} while ((building.getElevator().getCurrentFloor() > 0) && (building.getElevator().getCurrentFloor() < building.getNumberOfFloors()));			
		
			building.getElevator().switchDirection();
			
			for (Customer customer : building.getCustomerList()) {
	            // TODO method to check all customers are on destination floor
	            if (customer.isFinished()) {
	                setSimulationStatus(true);
	            } else setSimulationStatus(false);
	        }
							
		}
	}

	static int getEfficiencyCounter() {
		return efficiencyCounter;
	}

	static void setEfficiencyCounter(int efficiencyCounter) {
		SystemController.efficiencyCounter = efficiencyCounter;
	}
}
