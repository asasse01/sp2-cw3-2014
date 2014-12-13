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

	// to remove
	public static void generateCustomers() {
		// setting default number of customers
        while (building.getCustomerList().size() != defaultNumberOfCustomers()) { // to do recursively
			Customer customer = new Customer();
			building.addCustomer(customer);
		}
	}
	public static void generateCustomers(int number) {
		// setting user specified number of customers
		while (building.getCustomerList().size() != number) { // to do recursively
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

			getBuilding().getElevator().move();

			updateSimulationStatus();
		}
	}

	/**
     * alternativeStrategy uses the same "start at the bottom, go to the top, then go to the bottom" strategy
     * condition added to only load Customer if the destination floor is in the direction of travel
     */
	public static void alternativeStrategy() {
		while (!simulationFinished) {
			if (unloadNeeded() || loadNeeded())  {
				loadAndUnload();
				incrementCounter();
			}
			getBuilding().getElevator().move();
			updateSimulationStatus();
		}
	}

	public static void updateSimulationStatus() {
		for (Customer customer : building.getCustomerList()) {
			if (customer.isFinished()) {
				setSimulationStatus(true);
			} else
				setSimulationStatus(false);
		}
	}

	public static void loadAndUnload(){
		getBuilding().getElevator().load(getBuilding().getCustomerList());
		building.getElevator().unload();
	}

	public static boolean loadNeeded(){
		for (Customer customer : building.getCustomerList()){
			if (customer.elevatorArrivedAtStartingFloor()) {
				return true;
			}
		}
		return false;
	}
	public static boolean unloadNeeded(){
		for (Customer customer : building.getElevator().getCustomersInElevator()){
			if (customer.isAtDestination()) {
				return true;
			}
		}
		return false;
	}

	public static void clearSystemData() {
		setSimulationStatus(false);
		building.getCustomerList().clear();
		setEfficiencyCounter(0);
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
	private static int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	private static void setNumberOfCustomers(int numberOfCustomers) {
		SystemController.numberOfCustomers = numberOfCustomers;
	}
	public static void generateBuilding(int numberOfFloors){
		building = new Building(getNumberOfFloors());
	}
	// default
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
	public static void incrementCounter() {
		setEfficiencyCounter(getEfficiencyCounter() + 1);
	}

	public static void requestSimulationInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of customers: ");
		setNumberOfCustomers(in.nextInt());

		System.out.println("Please enter the number of floors: ");
		setNumberOfFloors(in.nextInt());

		System.out.println("Run simulation with the alternative strategy? Type 'Y' to run the alternative, or 'N' to run default: ");
		strategy = in.next();
		in.close();
	}

	public static void runSimulation() {
		switch (strategy) {
	    case "Y": alternativeStrategy();
	    case "N": defaultStrategy();
	    default: defaultStrategy();
	    //error checking
		}
	}

	public static void setupSimulation() {
		generateBuilding(numberOfFloors);
		generateCustomers(numberOfCustomers);
	}

}
