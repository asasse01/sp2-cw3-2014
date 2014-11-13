import java.util.ArrayList;


public class Building {
	
	// this could be an int arrayList, it'll make easy to avoid 13th floor
	private static int numberOfFloors; 
	
	private static int numberOfCustomers;
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator e;
	
	/* NOTES:
	 * not sure about using static everywhere
	 * we might need to extrapolate generateCustomers()  into its own class
	 */

	
	
	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}
	
	public void addCustomer(Customer c){
		customerList.add(c);
	}
	
	public static int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public void setNumberOfFloors() {
		// default
		this.numberOfFloors = 10;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		// User should choose
		this.numberOfFloors = numberOfFloors;
	}
	
	public static int getNumberOfCustomers(){
		return numberOfCustomers;
	}
	
	public void setNumberOfCustomers() {
		// default
		numberOfCustomers = 10;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		// User should choose
		this.numberOfCustomers = numberOfCustomers;
	}

}
