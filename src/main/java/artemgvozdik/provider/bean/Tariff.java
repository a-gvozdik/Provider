package artemgvozdik.provider.bean;
public class Tariff {
	private int ID;
	private String name;
	private String description;
	private double price;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Tariff [ID=" + ID + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}
	
}
