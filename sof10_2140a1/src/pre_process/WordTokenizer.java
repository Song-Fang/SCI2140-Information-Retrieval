package pre_process;

/**
 * This is for INFSCI 2140 in 2019
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	// Essential private methods or variables can be added.
	String[] words;
	int index;

	// YOU MUST IMPLEMENT THIS METHOD.
	public WordTokenizer(String texts) {
		// Tokenize the input texts.
		words = texts.split(" ");
		index = 0;
	}

	// YOU MUST IMPLEMENT THIS METHOD.
	public String nextWord() {
		// Return the next word in the document.
		// Return null, if it is the end of the document.
		int length = words.length;
		if (index >= length) {
			return null;
		}
		String word = trimWord(words[index]);
		if(word.length()==0) {
			index++;
			return nextWord();
		}
		index++;
		return word;
	}

	//trim illegal character, leave letters only
	private String trimWord(String word) {
		return word.replaceAll("[^a-zA-Z]", "");
	}

}
