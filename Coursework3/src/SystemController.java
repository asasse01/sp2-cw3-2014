import java.util.ArrayList;


public class SystemController {
	private static Building building = new Building();
	
	public static void main(String[] args) {
		
		// TODO:  ask User the number of Customers
		generateCustomers();
	}
	
	public static void generateCustomers(){ 
		// setting number of customer
		// should this be done here and not in the building ?
		building.setNumberOfCustomers(); 
		
		while (building.getCustomerList().size() != building.getNumberOfCustomers()){ // to do recursively
			Customer customer = new Customer();
			customer.setId();
			// customer.setCurrentFloor();
			// customer.setDestinationFloor();
			//System.out.println(customer.getId()); // to be removed
			building.addCustomer(customer);
		}
	}
	
	public static Building getBuilding(){
		return building;
	}
	
	public static int defaultStrategy() {
		int count = 0;
		Building building = getBuilding();
		ArrayList<Customer> loadList = new ArrayList<Customer>();
		
		for (Customer customer : building.getCustomerList()) {
			// method to check all customers are one destination floor
			if (!(customer.isFinished())) {
				//building.getElevator().switchDirection();//TODO remove floorlist
				while (/*(building.getElevator().getCurrentFloor() >= 0) && */(building.getElevator().getCurrentFloor() < building.getNumberOfFloors())) {
					// customer gets out if at destination floor
					building.getElevator().unload();
					
					// for every customer in building
					for (Customer c : building.getCustomerList()) {
						// customer joins if they are on the same floor as elevator
						if (c.getCurrentFloor() == (building.getElevator().getCurrentFloor())) {
						    if (!(c.isInElevator()) && (c.getDestinationFloor() != c.getCurrentFloor())) {
								loadList.add(c);
						    }
						}
					}
					// customer joins after loop (to avoid concurrency error)
				    for (Customer cust : loadList) {
				    	//rename
				    	building.getElevator().customerJoins(cust);
				    }
					loadList.clear();
					System.out.println(building.getElevator().getRegisterList()); //to remove
				count++;
				building.getElevator().move();
				}
				
			}
		}
		return count;
	}
}
