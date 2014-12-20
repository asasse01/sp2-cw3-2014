/**
 * @author Abby Sassel, Jacopo Scotti
 * @since 08/11/2014
 *
 * Coursework3
 * - Simulates a simple elevator.
 * - Shows how different strategies can affect the efficiency of an elevator.
 *
 */

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
		currentFloor = pickRandomFloor(SystemController.getBuilding().getFloorList());
		destinationFloor = pickRandomFloor(SystemController.getBuilding().getFloorList());
		finish = isAtDestination();
		System.out.println("ID: " + ID); // create getter
		System.out.println("Starting at:" + getStartingFloor());
		System.out.println("Ending at:" + getDestinationFloor());
	}

	public Customer(int numberOfFloors, int startingFloor, int destinationFloor){
		// instantiates a customer without random floors (for tests)
		ID = setID();
		inElevator = false;
		this.currentFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		finish = isAtDestination();
		System.out.println("Starting at:" + getStartingFloor());
		System.out.println("Ending at:" + getDestinationFloor());
	}

	/**
     * pickRandomFloor randomly selects a floor element from the given floor list
     * @param floorList array from which to randomly select and element
     * @return floor element
     */
	public int pickRandomFloor(int[] floorList){
		return floorList[(int)((Math.random()*floorList.length))];
		// TODO return element not index
	}

	/**
     * isAtDestination determines whether the customer is on their destination floor
     * @return boolean variable indicating whether the customer is on their destinations floor
     */
	public boolean isAtDestination(){
		if (currentFloor == destinationFloor)
			return true;
		else
			return false;
	}

	/**
     * elevatorArrivedAtStartingFloor determines whether the elevator is on the starting floor
     * @return boolean variable indicating whether the elevator is on the starting floor
     */
	public boolean elevatorArrivedAtStartingFloor(){
		if (SystemController.getBuilding().getElevator().getCurrentFloor() == getStartingFloor() && !isFinished() && !isInElevator()){
			//TODO change this
			return true;
		} else {
			return false;
		}

	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	// just for test use
	public int getStartingFloor(){
		return currentFloor;
		// TODO remove
	}

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	public int getId() {
		return ID;
	}

	public int setID() {
		setCustomerCounter();
		return getCustomerCounter();
		// TODO remove return
	}

	public int getCustomerCounter(){
		return customerCounter;
	}

	public void setCustomerCounter(){
		customerCounter++;
	}

	public boolean isInElevator() {
		return inElevator;
		// TODO rename
	}

	public void setInElevator(boolean inElevator) {
		this.inElevator = inElevator;
		// TODO rename
	}

	public boolean isFinished() {
		return finish;
	}

	public void finish(boolean finish) {
		this.finish = finish;
	}

	/**
     * getsIn changes the customer status to indicate they are in the elevator
     */
	public void getsIn(){
		inElevator = true;
	}

	/**
     * getsOut changes the customer status to indicate they are out of the elevator
     */
	public void getsOut(){
		finish(true);
		inElevator = false;
	}

	public boolean getStatus(){
		return inElevator;
	}

}
