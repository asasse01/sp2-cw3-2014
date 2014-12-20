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
	private boolean inElevatorStatus;
	private boolean completionStatus = false;
	private static int customerCounter = 0;

	public Customer(){
		inElevatorStatus = false;
		currentFloor = pickRandomFloor(SystemController.getBuilding().getFloorList());
		destinationFloor = pickRandomFloor(SystemController.getBuilding().getFloorList());
		completionStatus = isAtDestination();
	}

	public Customer(int numberOfFloors, int startingFloor, int destinationFloor){
		// instantiates a customer without random floors (for tests)
		inElevatorStatus = false;
		this.currentFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		completionStatus = isAtDestination();
		SimulationLogger.log("Customer ID: " + customerCounter++ + " Starting at:" + getCurrentFloor() + " Ending at:" + getDestinationFloor());

	}

	/**
     * pickRandomFloor randomly selects a floor element from the given floor list
     * @param floorList array from which to randomly select and element
     * @return floor element
     */
	public int pickRandomFloor(int[] floorList){
		return floorList[(int)((Math.random()*floorList.length))];
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
     * hasCalledElevator determines whether the elevator has arrived at the same floor as an awaiting customer
     * @return boolean variable indicating whether the elevator has arrived at the same floor as an awaiting customer
     */
	public boolean hasCalledElevator(){
		if (SystemController.getBuilding().getElevator().getCurrentFloor() == getCurrentFloor() && !getInElevatorStatus()){
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

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	public int getCustomerCounter(){
		return customerCounter;
	}

	public void setCustomerCounter(){
		customerCounter++;
	}

	public static void resetCustomerCounter(){
		customerCounter = 0;
	}

	public boolean getInElevatorStatus() {
		return inElevatorStatus;
	}

	public void setInElevatorStatus(boolean inElevatorStatus) {
		this.inElevatorStatus = inElevatorStatus;
	}

	public boolean getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

	/**
     * hasEnteredElevator changes the customer status to indicate they are in the elevator
     */
	public void hasEnteredElevator(){
		inElevatorStatus = true;
	}

	/**
     * hasLeftElevator changes the customer status to indicate they are out of the elevator
     */
	public void hasLeftElevator(){
		setCompletionStatus(true);
		inElevatorStatus = false;
	}

}
