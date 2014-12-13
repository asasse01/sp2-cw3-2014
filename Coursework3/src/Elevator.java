import java.util.ArrayList;


public class Elevator {
	private static ArrayList<Customer> registerList = new ArrayList<Customer>();
	private int currentFloor;
	private int numberOfFloors;
	private int direction; // -1 0 +1
	private final int DEFAULT = 10;

	public Elevator() { //default
		currentFloor = 0;
		direction = 1;
		registerList = new ArrayList<Customer>();
//		this.numberOfFloors = DEFAULT;
	}

	public Elevator(int floors) { // for testing
		currentFloor = 0;
		direction = 1;
		registerList = new ArrayList<Customer>();
		numberOfFloors = floors;
	}

	public int getNumberOfFloors(){
		return numberOfFloors;
	}

	public boolean atLastFloor(){
		if (getCurrentFloor() == (getNumberOfFloors() - 1)){
			return true;
		}
		return false;
	}

	public boolean atFirsFloor(){
		//correct this
		if (getCurrentFloor() == 0){
			return true;
		}
		return false;
	}

	public void move(){
		if (atLastFloor())
			switchDirection();

		switch (this.getDirection()) {
			case -1:
				this.setCurrentFloor(getCurrentFloor()-1);
			    break;
			case 1:
				this.setCurrentFloor(getCurrentFloor()+1);
			    break;
		}
		updateCustomersCurrentFloor();

		if (atFirsFloor())
			switchDirection();
	}

	public void load(ArrayList<Customer> customerList) {
		ArrayList<Customer> loadList = new ArrayList<Customer>();
		for (Customer customer : customerList) {
			// customer joins if they are on the same floor as elevator
			if (customer.getCurrentFloor() == (this.getCurrentFloor())) {
			    if (!customer.isInElevator() && !customer.isAtDestination()) {
					loadList.add(customer);
			    }
			}
		}
		// customer joins after loop (to avoid concurrency error)
	    for (Customer customer : loadList) {
	    	customerJoins(customer);
	    }
		loadList.clear();
	}

	public void unload() {
		ArrayList<Customer> unloadList = new ArrayList<Customer>();
		for (Customer customer : getCustomersInElevator()) {
			// customer leaves if they are on destination floor
			if (customer.isAtDestination()) {
				unloadList.add(customer);
			}
		}
		// customer leaves after loop (to avoid concurrency error)
		for (Customer customer : unloadList) {
		    customerLeaves(customer);
		}

	}

	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor() {
		// default
		this.currentFloor = 0;
	}
	public void setCurrentFloor(int floor) {
		//excludes 13th floor
		if (floor >= 13) {
			this.currentFloor = floor + 1;
		} else this.currentFloor = floor;

	}
	public int getDirection() {
		return direction;
	}
	public void setDirection() {
		// default
		this.direction = 0;
	}
	public void switchDirection() {
		setDirection(-getDirection());
	}
	public void customerJoins(Customer cust){
		cust.getsIn();
		registerList.add(cust);
	}
	public void customerLeaves(Customer cust){
		cust.getsOut();
		registerList.remove(cust);
	}
	public int getNumberOfCustomers(){
		return registerList.size();
	}
	public void setDirection(int direction) {
		// set direction to strictly -1 0 or 1
		this.direction = direction;
	}
	public ArrayList<Customer> getCustomersInElevator(){
		return registerList;
	}
	public void updateCustomersCurrentFloor(){
		for (Customer customer : getCustomersInElevator()){
			customer.setCurrentFloor(getCurrentFloor());
		}
	}
}
