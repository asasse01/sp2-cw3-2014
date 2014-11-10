
public class Elevator {
	private int NUM_OF_FLOORS;
	private Customer[] registerList;
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
		
	}
	
	public static void customerLeaves(){
		
	}
	
	public static void move(){
		
	}
	
}


