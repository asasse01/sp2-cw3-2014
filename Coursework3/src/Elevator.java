import java.util.ArrayList;


public class Elevator {
	private int NUM_OF_FLOORS;
	private static ArrayList<Customer> registerList = new ArrayList<Customer>();
	private int currentFloor;
	private int direction; // -1 0 +1
	
	public Elevator() {
		NUM_OF_FLOORS = 10; //TODO: change to num of floors in building
		currentFloor = 0;
		direction = 1;
		//registerList = new ArrayList<Customer>();
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
	
	public void unload() {
		ArrayList<Customer> unloadList = new ArrayList<Customer>();
		for (Customer c : getRegisterList()) {
			if (c.getCurrentFloor() == c.getDestinationFloor()) {
				unloadList.add(c);
			}
		}
		
		for (Customer c : unloadList) {
		    customerLeaves(c);
		}

	}
}


