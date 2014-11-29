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
	private static Building building = new Building();
	// TODO createBuilding method?
	static int numberOfFloors = DEFAULT;
	static boolean simulationFinished = false;
	private static int efficiencyCounter;

	public static void main(String[] args) {

		// TODO: ask User to specify simulation type
		int numberOfCustomers = requestNumberOfCustomers();
		generateCustomers(numberOfCustomers);

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

	public static void generateCustomers() {
		// setting default number of customers
		while (building.getCustomerList().size() != defaultNumberOfCustomers()) { // to do recursively

			Customer customer = new Customer(numberOfFloors);
			// TODO change to number of floors in building
			building.addCustomer(customer);
		}
	}

	public static void generateCustomers(int number) {
		// setting user specified number of customers
		while (building.getCustomerList().size() != number) { // to do recursively

			Customer customer = new Customer(numberOfFloors);
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

		Building building = getBuilding();

		while (!simulationFinished) {
			do {
				// customer gets out if at destination floor
				building.getElevator().unload();
				// customer gets in if at same floor as elevator
				building.getElevator().load(building.getCustomerList());

				setEfficiencyCounter(getEfficiencyCounter() + 1); // to refactor
				building.getElevator().move();
			} while (withinFloorLimits());

			building.getElevator().switchDirection();
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

	public static int requestNumberOfCustomers() {
		Scanner in = new Scanner(System.in);
		int numberOfCustomers = defaultNumberOfCustomers();
		System.out.println("Please enter the number of customers: ");
		numberOfCustomers = in.nextInt();
		in.close();
		return numberOfCustomers;
	}
}
