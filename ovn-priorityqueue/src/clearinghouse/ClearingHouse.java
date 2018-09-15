package clearinghouse;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ClearingHouse {
	private Map<String, OrderQueues> q;
		
	public ClearingHouse() {
		q = new TreeMap<String, OrderQueues>();
	}
	
	public boolean add(String shareId) {
		if (q.containsKey(shareId)) {
			return false;
		}
		q.put(shareId, new OrderQueues(shareId));
		return true;
	}
	
	/** 
	* Låter kunden customer lägga en köporder av aktieslaget shareId till 
	* budpriset price. Genomför köpet om matchande säljorder finns, i annat 
	* fall lagras köpordern i motsvarande orderkö.
	* @param customer kunden
	* @param shareId aktieslag
	* @param price budpris
	* @throws NoSuchElementException om det inte finns någon orderkö för 
	* aktieslaget shareId.
	*/
	public void buy(Customer customer, String shareId, double price) {
		// Fyll i egen kod
	}
	
	/** 
	* Låter kunden customer lägga en säljorder av aktieslaget shareId till 
	* budpriset price. Genomför försäljningen om matchande säljorder finns, i annat 
	* fall lagras säljordern i motsvarande orderkö.
	* @param customer kunden
	* @param shareId aktieslag
	* @param price budpris
	* @throws NoSuchElementException om det inte finns någon orderkö för 
	* aktieslaget shareId.
	*/
	public void sell(Customer customer, String shareId, double price) {
		// Fyll i egen kod
	}

	/** Genomför affären med ordrarna buyOrder och sellOrder. */
	private void execute(Order buyOrder, Order sellOrder) {
		// Simulerar aktieaffär
		System.out.println("Köp: " + buyOrder.getPrice() + " " + " sälj: " + sellOrder.getPrice());	
	}
	
	public String toString() {
		return q.toString();
	}
	
}
