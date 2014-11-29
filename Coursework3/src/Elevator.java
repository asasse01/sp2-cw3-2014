import java.util.ArrayList;


public class Elevator {
	private static ArrayList<Customer> registerList = new ArrayList<Customer>();
	private int currentFloor;
	private int direction; // -1 0 +1

	public Elevator() {
		currentFloor = 0;
		direction = 1;
		registerList = new ArrayList<Customer>();
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor() {
		// default
		this.currentFloor = 0;
	}

	public void setCurrentFloor(int floor) {
		this.currentFloor = floor;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection() {
		// default
		this.direction = 0;
	}

	public void setDirection(int direction) {
		// set direction to strictly -1 0 or 1
		this.direction = direction;
	}

	public void move(){
		switch (this.getDirection()) {
			case -1:
				this.setCurrentFloor(getCurrentFloor()-1);
				for (Customer customer : registerList) {
					customer.setCurrentFloor(getCurrentFloor());
				}
			    break;
			case 1:
				this.setCurrentFloor(getCurrentFloor()+1);
				for (Customer customer : registerList) {
					customer.setCurrentFloor(getCurrentFloor());
				}
			    break;
		}
	}

	public void switchDirection() {
		switch (this.getDirection()) {
		case -1:
			this.setDirection(+1);
		    break;
		case 1:
			this.setDirection(-1);
		    break;
		}

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
	public static ArrayList<Customer> getRegisterList(){
		return registerList;
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
		for (Customer customer : getRegisterList()) {
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
}


