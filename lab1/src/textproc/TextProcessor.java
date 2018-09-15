package textproc;

/**
 * Beskriver metoder för att behandla en sekvens av ord (som en bok), och därefter
 * presentera ett resultat med statistik av något slag.
 */
public interface TextProcessor {

	/** Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter. */
	void process(String w);

	/**
	 * Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
	 * en sammanställning av statistiken.
	 */
	void report();
}
