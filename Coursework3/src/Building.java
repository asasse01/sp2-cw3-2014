import java.util.ArrayList;


public class Building {

	private final int DEFAULT = 10;
	private int numberOfFloors;
	private ArrayList<Integer> floorList;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;

	public Building() {
		setNumberOfFloors();
		setFloorList();
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
		// User should choose
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfCustomers(){
		return customerList.size();
	}

	public ArrayList<Integer> getFloorList(){
		return floorList;
	}

	public void setFloorList(){
		//TODO: exclude 13th floor
		floorList = new ArrayList<Integer>(this.getNumberOfFloors());

	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

}
