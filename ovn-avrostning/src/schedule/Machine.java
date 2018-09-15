package schedule;

public class Machine {
	
	/** Skapar maskin nr nbr. */
	public Machine(int nbr) {
	
	}

	/** Tar reda på maskinens nr. */
	public int getNbr() {
		return 0;
	}	


	/** Tilldelar maskinen jobbet j. */
	public void assignJob(Job j) {
		
	}
	
	/** Tar bort alla jobb från maskinen. */
	public void clearJobs() {
		
	}
	
	/** Tar bort och returnerar nästa jobb som maskinen ska utföra. 
	 	Returnerar null om maskinen inte har några jobb. */
	public Job getNextJob() {
		return null;
	}
	
	/** Tar reda på den totala tiden för maskinens jobb. */
	public int getTotalTime() {
		return 0;
	}
	
	/** Returnerar en sträng som innehåller maskinens nr samt maskinens
    schemalagda jobb inom [] med kommatecken mellan. */
	public String toString() {
		return null;
	}
	
}
