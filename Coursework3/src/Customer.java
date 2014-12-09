
public class Customer {
	
	private int currentFloor;
	private int destinationFloor;
	private int ID;
	private boolean inElevator;
	private boolean finish = false;
	private static int customerCounter = 0;
	
	public Customer(){
		ID = setID();
		inElevator = false;
		currentFloor = pickRandomFloor(SystemController.getNumberOfFloors());
		destinationFloor = pickRandomFloor(SystemController.getNumberOfFloors());
		finish = isAtDestination();
		System.out.println("ID: " + ID); // create getter
		System.out.println("Starting at:" + getStartingFloor());
		System.out.println("Ending at:" + getDestinationFloor());
	}
	// instantiate a customer without random floors (for tests)
	public Customer(int numberOfFloors, int startingFloor, int destinationFloor){
		ID = setID();
		inElevator = false;
		this.currentFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		finish = isAtDestination();
		System.out.println("Starting at:" + getStartingFloor());
		System.out.println("Ending at:" + getDestinationFloor());
	}
	
	public int pickRandomFloor(int numberOfFloors){
		return (int)(Math.random()*numberOfFloors);
	}
	
	// Checks if startingFloor == destinationFloor
	public boolean isAtDestination(){
		if (currentFloor == destinationFloor)
			return true;
		else
			return false;
	}
	
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
	// just for test use
	public int getStartingFloor(){
		return currentFloor;
	}
	public void setDestinationFloor(int destinationFloor) {
		// add random destination floor from 0 to number of floors - 1 
		this.destinationFloor = destinationFloor;
	}
	public int getId() {
		return ID;
	}
	public int setID() {
		setCustomerCounter();
		return getCustomerCounter();
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
	
	// to rename
	public boolean isFinished() {
		return finish;
	}
	// to rename
	public void finish(boolean finish) {
		this.finish = finish;
	}
	
	public void getsIn(){
		inElevator = true;
	}
	public void getsOut(){
		finish(true);
		inElevator = false;	
	}
	
	public boolean getStatus(){
		return inElevator;
	}
	
}
