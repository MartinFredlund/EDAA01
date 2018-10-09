package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
	private Map<String, Integer> wordCounter = new TreeMap<>();
	Set<String> stopwords = new HashSet<>();

	public GeneralWordCounter(Set<String> stopwords) {
		this.stopwords = stopwords;
	}

	@Override
	public void process(String w) {
		if(stopwords.contains(w))
		{
			return;
		}
		if(wordCounter.containsKey(w))
		{
			wordCounter.put(w, wordCounter.get(w)+1);
		}
		else {
			wordCounter.put(w, 1);
		}
	}
	
	@Override
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = wordCounter.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		for(int i = 0; i < 100 ; i++) {
			System.out.println(wordList.get(i));
		}
		
	}
	
	public Set<Map.Entry<String, Integer>> getWords() {
		return wordCounter.entrySet();
	}

}
