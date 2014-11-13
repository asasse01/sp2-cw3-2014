import java.util.ArrayList;


public class Building {
	
	// this could be an int arrayList, it'll make easy to avoid 13th floor
	private int numberOfFloors; 
	private int numberOfCustomers;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	/* NOTES:
	 * add class constructor with elevator
	 */

	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}
	
	public void addCustomer(Customer c){
		customerList.add(c);
	}
	
	public int getNumberOfFloors() {
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
	
	public int getNumberOfCustomers(){
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
