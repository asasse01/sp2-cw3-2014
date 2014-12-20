/**
 * @author Abby Sassel, Jacopo Scotti
 * @since 08/11/2014
 *
 * Coursework3
 * - Simulates a simple elevator.
 * - Shows how different strategies can affect the efficiency of an elevator.
 *
 */

import java.util.Scanner;

public class SystemController {
	final static int DEFAULT = 10;
	private static Building building;
	private static int numberOfFloors = DEFAULT;
	private static int numberOfCustomers = DEFAULT;
	static boolean simulationFinished = false;
	private static int efficiencyCounter;
	private static String strategy;

	public static void main(String[] args) {
		requestSimulationInput();
		setupSimulation();
		runSimulation();
		System.out.println("Efficiency " + getEfficiencyCounter());

	}

	/**
     * generateCustomers generates a number of customers specified by the static variable DEFAULT
     */
	public static void generateCustomers() {
        while (building.getCustomerList().size() != defaultNumberOfCustomers()) {
			Customer customer = new Customer();
			building.addCustomer(customer);
		}
	}

	/**
     * generateCustomers generates a number of customers specified by the 'number' argument entered
     * @param number customers to generate
     */
	public static void generateCustomers(int number) {
		while (building.getCustomerList().size() != number) {
			Customer customer = new Customer();
			building.addCustomer(customer);
		}
	}

	/**
     * defaultStrategy runs the suggested "start at the bottom, go to the top, then go to the bottom" strategy
     */
	public static void defaultStrategy() {
		while (!simulationFinished) {
			loadAndUnload();
			incrementCounter();
			building.getElevator().move();
			updateSimulationStatus();
		}
	}

	/**
     * alternativeStrategy uses the same "start at the bottom, go to the top, then go to the bottom" strategy
     * condition added to only run the load or unload methods if needed
     */
	public static void alternativeStrategy() {
		while (!simulationFinished) {
			if (unloadNeeded() || loadNeeded())  {
				loadAndUnload();
				incrementCounter();
			}
			building.getElevator().move();
			updateSimulationStatus();
		}
	}

	/**
     * updateSimulationStatus determines whether every Customer is on destination floor and updates the simulation status
     */
	public static void updateSimulationStatus() {
		for (Customer customer : building.getCustomerList()) {
			if (customer.getCompletionStatus()) {
				setSimulationStatus(true);
			} else
				setSimulationStatus(false);
		}
	}

	/**
     * loadAndUnload combines the load and unload methods from Elevator
     */
	public static void loadAndUnload(){
		building.getElevator().load(building.getCustomerList());
		building.getElevator().unload();
	}

	/**
     * loadNeeded determines the need to load one or more Customers into the Elevator
     * @return boolean variable that can be used as a condition to invoke the load method
     */
	public static boolean loadNeeded(){
		for (Customer customer : building.getCustomerList()){
			if (customer.hasCalledElevator()) {
				return true;
			}
		}
		return false;
	}

	/**
     * unloadNeeded determines the need to unload one or more Customers from the Elevator
     * @return boolean variable that can be used as a condition to invoke the unload method
     */
	public static boolean unloadNeeded(){
		for (Customer customer : building.getElevator().getCustomersInElevator()){
			if (customer.isAtDestination()) {
				return true;
			}
		}
		return false;
	}

	/**
     * clearSystemData clears all data associated with a simulation
     */
	public static void clearSystemData() {
		setSimulationStatus(false);
		building.getCustomerList().clear();
		setEfficiencyCounter(0);
		Customer.resetCustomerCounter();
	}

	static int getEfficiencyCounter() {
		return efficiencyCounter;
	}

	static void setEfficiencyCounter(int efficiencyCounter) {
		SystemController.efficiencyCounter = efficiencyCounter;
	}

	public static Building getBuilding() {
		return building;
	}

	static int getNumberOfFloors() {
		return numberOfFloors;
	}

	static void setNumberOfFloors(int numberOfFloors) {
		SystemController.numberOfFloors = numberOfFloors;
	}

	private static void setNumberOfCustomers(int numberOfCustomers) {
		SystemController.numberOfCustomers = numberOfCustomers;
	}

	public static void generateBuilding(int numberOfFloors){
		building = new Building(getNumberOfFloors());
	}

	public static void generateBuilding(){
		building = new Building();
	}

	public static int defaultNumberOfCustomers() {
		return DEFAULT;
	}

	public static boolean getSimulationStatus() {
		return simulationFinished;
	}

	public static void setSimulationStatus(boolean status) {
		SystemController.simulationFinished = status;
	}

	/**
     * incrementCounter increments the efficiency counter by one unit
     */
	public static void incrementCounter() {
		setEfficiencyCounter(getEfficiencyCounter() + 1);
	}

	/**
     * requestSimulationInput requests from user all data required for the simulation to run
     */
	public static void requestSimulationInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of customers: ");
		setNumberOfCustomers(in.nextInt());

		System.out.println("Please enter the number of floors: ");
		setNumberOfFloors(in.nextInt());

		System.out.println("Run simulation with the alternative strategy? Type 'Y' to run the alternative, or 'N' to run default: ");
		strategy = in.next();
		in.close();
		// TODO error checking
	}

	/**
     * runSimulation runs the simulation with either the default or alternative strategy
     */
	public static void runSimulation() {
		switch (strategy) {
	    case "Y": alternativeStrategy();
	    case "N": defaultStrategy();
	    default: defaultStrategy();
	    // TODO error checking
		}
	}

	/**
     * setupSimulation generates the Customer and Building objects required for the simulation to run
     */
	public static void setupSimulation() {
		generateBuilding(numberOfFloors);
		generateCustomers(numberOfCustomers);
	}

}
