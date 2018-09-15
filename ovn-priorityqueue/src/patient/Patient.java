package patient;

public class Patient  {
	private String firstname;
	private String lastname;
	private String personNbr;
	private int prio;

	public Patient(String firstname, String lastname, String personNbr, int prio) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.personNbr = personNbr;
		this.prio = prio;
	}
}
