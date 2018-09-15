package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> wordCounter = new TreeMap<>();

	public MultiWordCounter(String[] landskap) {
		for (String k : landskap) {
			wordCounter.put(k, 0);
		}
	}

	@Override
	public void process(String w) {
		if(wordCounter.containsKey(w)) {
			wordCounter.put(w, wordCounter.get(w)+1);
			
		}

	}

	@Override
	public void report() {
		for (String key : wordCounter.keySet()) {
			System.out.println(key + " " + wordCounter.get(key));
		}

	}

}
