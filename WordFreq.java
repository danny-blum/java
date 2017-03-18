import java.util.*;

public class WordFreq {
    private HashMap <String,Integer>hm;

    public WordFreq() {
	hm = new HashMap<String,Integer>();
    }

    public void countWords(String book) {
	Integer freq;

	String[] words = book.split(" ");
	for(String word : words) {
	    freq = hm.get(word);
	    if (freq == null) freq = new Integer(0);
	    freq++;
	    hm.put(word, freq);
	}

	System.out.println("Constructed hashmap: " + hm);
    }

    public Integer getFreq(String word) {
	return hm.get(word);
    }

    public static void main(String[] args) {
	Integer freq;

	WordFreq wf = new WordFreq();
	wf.countWords("This is an example book and it is great");
	freq = wf.getFreq("is");
	System.out.println("Freq of is: " + freq);

    }
}
