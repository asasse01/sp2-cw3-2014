public class SystemController {
	private static Building building = new Building();
	final static int FLOORS = 10;
	static boolean simulationFinished = false;
	private static int efficiencyCounter;

	public static void main(String[] args) {

		// TODO: ask User the number of Customers
		generateCustomers();
	}

	public static int defaultNumberOfCustomers() {
		return 10;
	}

	public static boolean getSimulationStatus() {
		return simulationFinished;
	}

	public static void setSimulationStatus(boolean status) {
		SystemController.simulationFinished = status;
	}

	public static void generateCustomers() {
		// setting default number of customers
		while (building.getCustomerList().size() != defaultNumberOfCustomers()) { // to
																					// do
																					// recursively
			Customer customer = new Customer(FLOORS);
			building.addCustomer(customer);
		}
	}

	public static void generateCustomers(int number) {
		// setting user specified number of customers
		while (building.getCustomerList().size() != number) { // to do
																// recursively
			Customer customer = new Customer(FLOORS);
			building.addCustomer(customer);
		}
	}

	public static Building getBuilding() {
		return building;
	}

	public static void defaultStrategy() {

		setEfficiencyCounter(0);

		Building building = getBuilding();

		while (!simulationFinished) {
			do {
				// customer gets out if at destination floor
				building.getElevator().unload();
				// customer gets in if at same floor as elevator
				building.load();

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
						building.load();
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
}
