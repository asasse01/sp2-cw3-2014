import java.util.ArrayList;


public class Building {
	
	private static int numberOfFloors;
	private static int numberOfCustomers;
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator e = new Elevator(getNumberOfFloors());
	
	/* NOTES:
	 * not sure about using static everywhere
	 * we might need to extrapolate generateCustomers()  into its own class
	 */

	public static void main(String[] args){
		setNumberOfCustomers();
		generateCustomers();
	}
	
	public Elevator getElevator(){
		System.out.println("elevator");
		return e;
	}
	

	public static void generateCustomers(){ 

		while (customerList.size() != getNumberOfCustomers()){
			Customer customer = new Customer();
			customer.setId();
			// a.setCurrentFloor();
			// a.setDestinationFloor();
			customerList.add(customer);
		}
	}
	
	public ArrayList<Customer> getListOfCustomers(){
		return customerList;
	}
	
	public static int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public void setNumberOfFloors() {
		// default
		numberOfFloors = 10;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		// User should choose
		Building.numberOfFloors = numberOfFloors;
	}
	
	public static int getNumberOfCustomers(){
		return numberOfCustomers;
	}
	
	public static void setNumberOfCustomers() {
		// default
		numberOfCustomers = 10;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		// User should choose
		Building.numberOfCustomers = numberOfCustomers;
	}

}
