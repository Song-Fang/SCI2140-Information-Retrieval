package pre_process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import classes.Path;

public class StopWordRemover {
	// Essential private methods or variables can be added.
	HashSet<String> stopWords;
	String stopWord;
	File file;
	FileReader fr;
	BufferedReader br;
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public StopWordRemover() throws IOException {
		// Load and store the stop words from the fileinputstream with appropriate data
		// structure.
		// NT: address of stopword.txt is Path.StopwordDir
		File file = new File(Path.StopwordDir);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		stopWords = new HashSet<String>();
		stopWord = br.readLine();
		
		while(stopWord!=null) {
			stopWords.add(stopWord);
			stopWord = br.readLine();
		}
		if(br!=null) {
			br.close();
		}
		if(fr!=null) {
			fr.close();
		}
		
	}

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public boolean isStopword(String word) {
		// Return true if the input word is a stopword, or false if not.
		
		return stopWords.contains(word);
	}
}
