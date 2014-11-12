
public class SystemController {
	static Building building = new Building();
	

	public static void main(String[] args) {
		
		// TODO:  ask User the number of Customers
		building.setNumberOfCustomers();
		generateCustomers();

	}
	
	public static void generateCustomers(){ 

		while (building.getCustomerList().size() != building.getNumberOfCustomers()){ // to do recursively
			Customer customer = new Customer();
			customer.setId();
			// customer.setCurrentFloor();
			// customer.setDestinationFloor();
			building.addCustomer(customer);
		}
	}

}
