/**
 * @author Abby Sassel, Jacopo Scotti
 * @since 08/11/2014
 *
 * Coursework3
 * - Simulates a simple elevator.
 * - Shows how different strategies can affect the efficiency of an elevator.
 *
 */

import java.util.ArrayList;

public class Building {
	private final int DEFAULT = 10;
	private int numberOfFloors;
	private int[] floorList;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;

	public Building(int numberOfFloors) {
		setNumberOfFloors(numberOfFloors);
		floorList = createUsFloorList(numberOfFloors);
		System.out.println(getNumberOfFloors());
		setElevator(elevator = new Elevator(numberOfFloors));
	}

	public Building() {
		setNumberOfFloors();
		floorList = createUsFloorList(numberOfFloors);
		setElevator(elevator = new Elevator());
	}

	public ArrayList<Customer> getCustomerList(){
		return this.customerList;
	}

	/**
     * addCustomer adds a Customer to the customerList
     */
	public void addCustomer(Customer c){
		this.customerList.add(c);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors() {
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

	/**
     * createUsFloorList instantiates an integer array in order to skip the 13th floor
     * @param numberOfFloors number of floors in Building
     * @return floorList array which excludes the 13th floor
     */
	public int[] createUsFloorList(int numberOfFloors) {
		floorList = new int[numberOfFloors];
		for (int i = 0; i < floorList.length; i++) {
			if (i >= 13) {
				floorList[i] = i+1;
			} else floorList[i] = i;

		}
		return floorList;
	}

}
