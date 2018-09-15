import java.util.ArrayList;
import java.util.List;

public class PersonExample {

	/**
	 * Skriver ut alla de personer i listan som uppfyller villkoret condition.
	 */
	public static void print(List<Person> persons, PersonCondition condition) {
		for (Person p : persons) {
			if (condition.test(p)) {
				System.out.println(p.toString());
			}
		}
	}

	/**
	 * Klass för villkorsobjekt. Skiljer ut personer som uppnått
	 * myndighetsålder.
	 */
	private static class AgeCondition implements PersonCondition {
		public boolean test(Person p) {
			return p.getAge() >= 18;
		}
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Nilsson, Sten", 13));
		persons.add(new Person("Jonsson, Camilla", 23));
		persons.add(new Person("Hermansson, Lena", 38));
		persons.add(new Person("Fransson, Anneli", 15));
		persons.add(new Person("Lundström, David", 21));
		persons.add(new Person("Björk, Stefan", 20));
		persons.add(new Person("Andersson, Gun", 55));
		persons.add(new Person("Lundgren, Carina", 12));
		persons.add(new Person("Svensson, Ulf", 47));
		
		PersonCondition cond = new AgeCondition();
		print(persons, cond);
	}

}
