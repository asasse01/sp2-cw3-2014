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
	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {

		// TODO: ask User to specify simulation type
		requestNumberOfCustomers(); // to refactor
		requestNumberOfFloors(); // to refactor
		in.close();
		generateBuilding(numberOfFloors);
		generateCustomers(numberOfCustomers); // to refactor
		
		defaultStrategy();
		
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

	
	// to remove
	public static void generateCustomers() {
		// setting default number of customers
        while (building.getCustomerList().size() != defaultNumberOfCustomers()) { // to do recursively

			Customer customer = new Customer(getNumberOfFloors());
			// TODO change to number of floors in building
			building.addCustomer(customer);
		}
	}

	public static void generateCustomers(int number) {
		// setting user specified number of customers
		while (building.getCustomerList().size() != number) { // to do recursively

			Customer customer = new Customer(getNumberOfFloors());
			// TODO change to number of floors in building
			building.addCustomer(customer);
		}
	}

	public static Building getBuilding() {
		return building;
	}

	/**
     * defaultStrategy runs the suggested "start at the bottom, go to the top, then go to the bottom" strategy
     */
	public static void defaultStrategy() {

		setEfficiencyCounter(0);

		
		// elevator should automatically:
		// load 
		// unload
		// move
		// switch direction
		
		while (!simulationFinished) {
			do {
				// customer gets out if at destination floor
				getBuilding().getElevator().unload();
				// customer gets in if at same floor as elevator
				getBuilding().getElevator().load(getBuilding().getCustomerList());

				setEfficiencyCounter(getEfficiencyCounter() + 1); // to refactor
				getBuilding().getElevator().move();
			} while (withinFloorLimits());

			getBuilding().getElevator().switchDirection();
			updateSimulationStatus();
		}
	}

	static int getEfficiencyCounter() {
		return efficiencyCounter;
	}

	static void setEfficiencyCounter(int efficiencyCounter) {
		SystemController.efficiencyCounter = efficiencyCounter;
	}

	public static boolean withinFloorLimits() {
		if ((building.getElevator().getCurrentFloor() > 0)
				&& (building.getElevator().getCurrentFloor() < building.getNumberOfFloors())) {
			return true;
		} else
			return false;

	}

	public static void updateSimulationStatus() {
		for (Customer customer : building.getCustomerList()) {
			if (customer.isFinished()) {
				setSimulationStatus(true);
			} else
				setSimulationStatus(false);
		}
	}

	/**
     * alternativeStrategy uses the same "start at the bottom, go to the top, then go to the bottom" strategy
     * condition added to only load Customer if the destination floor is in the direction of travel
     */
	public static void alternativeStrategy() {

		setEfficiencyCounter(0);

		Building building = getBuilding();

		while (!simulationFinished) {
			do {
				// customer gets out if at destination floor
				building.getElevator().unload();

				for (Customer customer : building.getCustomerList()) {
					// refactor
					if (((customer.getDestinationFloor()
							- customer.getCurrentFloor() > 0) && building
							.getElevator().getDirection() == 1)
							|| ((customer.getDestinationFloor()
									- customer.getCurrentFloor() < 0) && building
									.getElevator().getDirection() == -1)) {
						// customer gets in if at same floor as elevator
						building.getElevator().load(building.getCustomerList());
					}
				}

				setEfficiencyCounter(getEfficiencyCounter() + 1); // to refactor
				building.getElevator().move();
			} while (withinFloorLimits());

			building.getElevator().switchDirection();
			updateSimulationStatus();
		}
	}

	public static void clearSystemData() {

		setSimulationStatus(false);
		building.getCustomerList().clear();
		setEfficiencyCounter(0);

	}

	public static void requestNumberOfCustomers() {
		System.out.println("Please enter the number of customers: ");
		setNumberOfCustomers(in.nextInt());
	}
	
	public static void requestNumberOfFloors() {
		System.out.println("Please enter the number of floors: ");
		setNumberOfFloors(in.nextInt());
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
}
