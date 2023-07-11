package roomservicemanagementproducer;

public class Room {

	private int roomId;
	private String roomType;
	private double roomPrice;
	private double discount;
	private double finalPrice;
	
	public Room(int roomId, String roomType, double roomPrice, double discount) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.discount = discount;
		calculateFinalPrice();
		
	}
	public int getroomId() {
		return roomId;
	}
	public void setroomId(int roomId) {
		this.roomId = roomId;
	}
	public String getroomType() {
		return roomType;
	}
	public void setroomType(String roomType) {
		this.roomType = roomType;
	}
	public double getroomPrice() {
		return roomPrice;
	}
	public void setroomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
		calculateFinalPrice();
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
		calculateFinalPrice();
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void calculateFinalPrice() {
		this.finalPrice = roomPrice * ((100.00- discount)/100.00) ;
	}
}
