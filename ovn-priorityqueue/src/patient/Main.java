package patient;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Patient> pq = new PriorityQueue<Patient>();
		
		pq.offer(new Patient("Kalle", "Karlsson", "8503622-1213", 3));
		pq.offer(new Patient("Lisa", "Svensson", "840312-1224", 2));
		pq.offer(new Patient("Lena", "Nilsson", "820323-1224", 3));
		
		while (! pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
