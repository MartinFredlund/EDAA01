package clearinghouse;

public class Order {
	private double price;
	private Customer customer;
	
	/** Skapar en köp- eller säljorder för en aktiepost med priset price och köpare/säljare customer. */
	public Order(double price, Customer customer) {
		this.price = price;
		this.customer = customer;
	}
	
	/** Returnerar köp/säljpris för aktieposten. */
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return String.valueOf(price);
	}
}
