package clearinghouse;

import java.util.PriorityQueue;

public class OrderQueues {
	private String shareId;
	private PriorityQueue<Order> buyOrders;		// sorterad efter avtagande pris
	private PriorityQueue<Order> sellOrders;	// sorterad efter växande pris

	/** 
	 * Skapar ett objekt som hanterar en kö för köpordrar och en kö för säljordrar för aktien med id shareId. 
	 * @param shareId 
	 */
	public OrderQueues(String shareId) {
		// Fyll i egen kod
	}
	
	/**
	 * Lägger till en köporder ifall matchande säljorder inte finns. 
	 * Om matchande säljorder finns tas säljordern bort och returneras.
	 * @param buyOrder köporder
	 * @return matchande säljorder om sådan finns, i annat fall null
	 */
	public Order addBuyOrder(Order buyOrder) {
		// Fyll i egen kod
		return null;
	}
	
	/**
	 * Lägger till en säljorder ifall matchande köporder inte finns. 
	 * Om matchande köporder finns tas köpordern bort och returneras.
	 * @param buyOrder säljorder
	 * @return matchande köporder om sådan finns, i annat fall null
	 */
	public Order addSellOrder(Order sellOrder) {
		// Fyll i egen kod
		return null;
	}
	
	
	public String toString() {
		return "Köporder: " + buyOrders + " säljorder: " +sellOrders;
	}

}
