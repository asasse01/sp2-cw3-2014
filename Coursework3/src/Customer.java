
public class Customer {
	
	private int startingFloor;
	private int currentFloor;
	private int destinationFloor;
	private int ID;
	private boolean inElevator;
	private boolean finish = false;
	private static int customerCounter = 0;
	
	public Customer(int numberOfFloors){
		ID = setID();
		inElevator = false;
		startingFloor = pickRandomFloor(numberOfFloors);
		destinationFloor = pickRandomFloor(numberOfFloors);
		finish = firstCheck();
		System.out.println("Starting at:" + getStartingFloor());
		System.out.println("Ending at:" + getDestinationFloor());
	}
	// instantiate a customer without random floors (for tests)
	public Customer(int numberOfFloors, int startingFloor, int destinationFloor){
		ID = setID();
		inElevator = false;
		this.startingFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		finish = firstCheck();
	}
	
	public int pickRandomFloor(int numberOfFloors){
		return (int)(Math.random()*numberOfFloors);
	}
	
	public boolean firstCheck(){
		if (startingFloor == destinationFloor)
			return true;
		else
			return false;
	}
	
//	// startingFloor should be generated when Customer is created
//	public void generateStartingFloor(){
//		startingFloor = (int)(Math.random()*Building.getNumberOfFloors());
//		destinationFloor = (int)(Math.random()*Building.getNumberOfFloors());
//		System.out.println("Starting at:" + startingFloor);
//		System.out.println("Ending at:" + destinationFloor);
//	}
	
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
		return startingFloor;
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
	
	// check floor method 
	// If customer is generated at end floor setFinished to true
	// Without the need of going into the elevator
	
}
