
public class Customer {
	
	private int currentFloor;
	private int destinationFloor;
	private int Id;
	private boolean inElevator;
	private boolean finish;
	
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
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public boolean isInElevator() {
		return inElevator;
	}
	public void setInElevator(boolean inElevator) {
		this.inElevator = inElevator;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
}
