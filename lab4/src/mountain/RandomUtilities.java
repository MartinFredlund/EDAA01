package mountain;

public class RandomUtilities {
	public static double randFunc(double dev) {
		double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
		if (Math.random() < 0.5)
			t = -t;
		return t;
	}
}
