package pre_process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import classes.Path;

/**
 * This is for INFSCI 2140 in 2019
 *
 */
public class TrectextCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	// Declare fields of TrectextCollection Class
	File file;
	FileReader fr;
	BufferedReader br;

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrectextCollection() throws IOException {
		// 1. Open the file in Path.DataTextDir.
		// 2. Make preparation for function nextDocument().
		// NT: you candocNumt load the whole corpus into memory!!
		// Create IO object&access the information of file
		file = new File(Path.DataTextDir);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
		// 1. When called, this API processes one document from corpus, and returns its
		// doc number and content.
		// 2. When docNum document left, return null, and close the file.
		Map<String, Object> document = new HashMap<String, Object>();
		String docNum = br.readLine();
		
		// Decide whether there are documents left
		if (docNum == null) {
			if (br != null) {
				br.close();
			}
			if (fr != null) {
				fr.close();
			}
			return null;
		}
		//Get the DocdocNum
		while(!docNum.startsWith("<DOCNO>")) {
			docNum = br.readLine();
		}
		
		//Get the content of the text
		while(!br.readLine().startsWith("<TEXT>")) {
			continue;
		}
		String content = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(!content.startsWith("</TEXT>")) {
			sb.append(content+" ");
			content = br.readLine();
		}
		
		//Go to the end of the document and prepare for next document processing
		while(!br.readLine().startsWith("</DOC>")) {
			continue;
		}
		
		//trim the document number
		int start = docNum.indexOf(">");
		int end = docNum.indexOf("<",start);
		docNum = docNum.substring(start+1,end).trim();
		
		//put the result in the Map and return results
		document.put(docNum, sb.toString());
		return document;
		
	}

}
