package pre_process;

import classes.Stemmer;

/**
 * This is for INFSCI 2140 in 2019
 * 
 */
public class WordNormalizer {
	// Essential private methods or variables can be added.
	Stemmer s = new Stemmer();
	// YOU MUST IMPLEMENT THIS METHOD.
	public String lowercase(String word) {
		// Transform the word uppercase characters into lowercase.
		return word.toLowerCase();
	}

	// YOU MUST IMPLEMENT THIS METHOD.
	public String stem(String word) {
		// Return the stemmed word with Stemmer in Classes package.
		char[] words = word.toCharArray();
		s.add(words, words.length);
		s.stem();
		String str = s.toString();
		return str;
	}

}
