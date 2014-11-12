import java.util.ArrayList;


public class Elevator {
	private int NUM_OF_FLOORS;
	private static ArrayList<Customer> registerList = new ArrayList<Customer>();
	private int currentFloor;
	private int direction; // -1 0 +1
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public void setCurrentFloor() {
		// default
		this.currentFloor = 0;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection() {
		// default
		this.direction = 0;
	}
	
	public void setDirection(int direction) {
		// set direction to strictly -1 0 or 1
		this.direction = direction;
	}
	
	
	public static void customerJoins(){
	// appends customer to registerList[]
	}
	
	public static void customerLeaves(){
	// removes customer to registerList[]
	}
	
	public static void move(){
	//Switch (direction) 
	//Case -1:
	//    Floor - 1
	//    break
	//Case 1:
	//    Floor + 1	
	//    break
	}
	
	public static void switchDirection(){
	//Switch (currentFloor) 
	//Case maxFloor:
	//    Direction = -1
	//Case minFloor:
	//    Direction = +1
	
	//FI: will also need to switch if no customers are present at lower or higher floors 

	}
	
	public static void customerGetsIn(Customer cust){
		registerList.add(cust);
		
	}
//	public static void customerGetsOut(Customer cust){
//		registerList.remove(cust);
//		// to be remove by id
//	}
	
	public static int getNumberOfCustomers(){
		return registerList.size();
	}
	
	
}


