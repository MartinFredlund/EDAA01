
/** Beskriver ett villkor som Person-objekt kan uppfylla. */
public interface PersonCondition {
	
	/** Returnerar true om villkoret är uppfyllt, annars false. */
	boolean test(Person p);
}
