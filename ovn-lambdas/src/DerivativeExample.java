public class DerivativeExample {

	public interface Func {
		// här behövs mer (uppgift U8)
	}
	
	public static double deriv(Func f, double x) {
		final double h = 1e-6;
		return 0; // använd derivatans definition här (uppgift U9)
	}
	
	public static void main(String[] args) {
		// avkommentera nedanstående

		// double yprime = deriv(x -> Math.sin(x), 0.3);
		// System.out.println(yprime + " (förväntat: ca 0.9553)");
	}
}
