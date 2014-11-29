import java.util.ArrayList;


public class Building {

	private final int DEFAULT = 10;
	private int numberOfFloors;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;

	public Building(int numberOfFloors) {
		setNumberOfFloors(numberOfFloors);
		System.out.println(getNumberOfFloors());
		setElevator(new Elevator());
	}
	
	public Building() {
		setNumberOfFloors();
		setElevator(new Elevator());
	}

	public ArrayList<Customer> getCustomerList(){
		return this.customerList;
	}

	public void addCustomer(Customer c){
		this.customerList.add(c);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors() {
		// default
		this.numberOfFloors = DEFAULT;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfCustomers(){
		return customerList.size();
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

}
