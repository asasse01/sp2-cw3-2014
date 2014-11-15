
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
			System.out.println(customer.getId()); // to be removed
			building.addCustomer(customer);
		}
	}
	
	public static Building getBuilding(){
		return building;
	}
}
