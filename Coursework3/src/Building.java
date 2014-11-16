import java.util.ArrayList;


public class Building {
	
	// this could be an int arrayList, it'll make easy to avoid 13th floor
	private int numberOfFloors;
	private ArrayList<Integer> floorList;
	private int numberOfCustomers;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;

	
	/* NOTES:
	 * add class constructor with elevator
	 */
	
	public Building() {
		setNumberOfFloors();
		setNumberOfCustomers();
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
	
	public ArrayList<Integer> getFloorList(){
		return floorList;
	}

	public void setFloorList(){
		// Should always be equal to number of floors
		//TODO: exclude 13th floor
		floorList = new ArrayList<Integer>(this.getNumberOfFloors());
		
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}
	
	public void load() {
		ArrayList<Customer> loadList = new ArrayList<Customer>();
		for (Customer c : this.getCustomerList()) {
			// customer joins if they are on the same floor as elevator
			if (c.getCurrentFloor() == (this.getElevator().getCurrentFloor())) {
			    if (!(c.isInElevator()) && (c.getDestinationFloor() != c.getCurrentFloor())) {
					loadList.add(c);
			    }
			}
		}
		// customer joins after loop (to avoid concurrency error)
	    for (Customer cToJoin : loadList) {
	    	//rename
	    	this.getElevator().customerJoins(cToJoin);
	    }
		loadList.clear();
	}
}
