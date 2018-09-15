package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		List<TextProcessor> cnters = new ArrayList<TextProcessor>();
		
		cnters.add(new SingleWordCounter("nils"));
		cnters.add(new SingleWordCounter("norge"));
		cnters.add(new MultiWordCounter(REGIONS));
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		cnters.add(new GeneralWordCounter(stopwords));
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			for(TextProcessor p: cnters) {
			p.process(word);
			}
		}

		s.close();
		for(TextProcessor p: cnters) {
		p.report();
		
		}
		long t1 = System.nanoTime();
		System.out.println("tid " + (t1-t0) / 1000000.0 + " ms");
	}
}