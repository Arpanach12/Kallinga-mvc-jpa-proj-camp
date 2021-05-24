package entity;


public class Train {
	private int trainId;
	private String trainName;
	private String source;
	private String destination;
	private int distance;
	private int fare;
	
	public Train() {
		super();
	}
	public Train(int trainId, String trainName, String source, String destination, int distance, int fare) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.fare = fare;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
}
