
public class Customer {
	
	private int currentFloor;
	private int destinationFloor;
	private int Id;
	private boolean inElevator = false;
	private boolean finish = false;
	private static int customerCounter = 0;
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		// add random current floor from 0 to number of floors - 1 
		this.currentFloor = currentFloor;
	}
	public int getDestinationFloor() {
		return destinationFloor;
	}
	public void setDestinationFloor(int destinationFloor) {
		// add random destination floor from 0 to number of floors - 1 
		this.destinationFloor = destinationFloor;
	}
	public int getId() {
		return Id;
	}
	public void setId() {
		Id = getCustomerCounter();
		setCustomerCounter();
	}
	
	public int getCustomerCounter(){
		return customerCounter;
	}
	
	public void setCustomerCounter(){
		customerCounter++;
	}
	public boolean isInElevator() {
		return inElevator;
	}
	public void setInElevator(boolean inElevator) {
		this.inElevator = inElevator;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public void getsIn(){
		
	}
	public void getsOut(){
		
	}
	
}
