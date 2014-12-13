import java.util.ArrayList;


public class Building {

	private final int DEFAULT = 10;
	private int numberOfFloors;
	private int[] floorList;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;

	public Building(int numberOfFloors) {
		setNumberOfFloors(numberOfFloors);
		//new stuff
		floorList = new int[numberOfFloors];
		for (int i = 0; i < numberOfFloors; i++) {
			//excludes 13th floor
			//refactor
			if (i >= 13) {
				floorList[i] = i+1;
			} else floorList[i] = i;

		}
		//end of new stuff
		System.out.println(getNumberOfFloors());
		setElevator(elevator = new Elevator(numberOfFloors));
	}

	public Building() {
		setNumberOfFloors();
		//new stuff
		floorList = new int[getNumberOfFloors()];
		for (int i = 0; i < getNumberOfFloors(); i++) {
			//excludes 13th floor
			//refactor
			if (i >= 13) {
				floorList[i] = i+1;
			} else floorList[i] = i;

		}
		//end of new stuff
		setElevator(elevator = new Elevator());
	}

	public ArrayList<Customer> getCustomerList(){
		return this.customerList;
	}

	public void addCustomer(Customer c){
		this.customerList.add(c);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors() {
		// default
		this.numberOfFloors = DEFAULT;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfCustomers(){
		return customerList.size();
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public int[] getFloorList() {
		return floorList;
	}

	public void setFloorList(int[] floorList) {
		this.floorList = floorList;
	}

}
