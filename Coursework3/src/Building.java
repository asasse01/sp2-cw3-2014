
public class Building {
	
	private int numberOfFloors;
	private int numberOfCustomers;
	private Customer[] customerList;
	private Elevator e;

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
	
	public void setNumberOfcustomers() {
		// default
		this.numberOfCustomers = 10;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		// User should choose
		this.numberOfCustomers = numberOfFloors;
	}

	private Customer[] getCustomerList() {
		return customerList;
	}

	private void setCustomerList(Customer[] customerList) {
		this.customerList = customerList;
	}


}
