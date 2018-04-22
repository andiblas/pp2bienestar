package org.bienestar.cocina.autocorrect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResourceReader {

	private final Map<Character, List<String>> nWords = new HashMap<Character, List<String>>();
	
	public ResourceReader(String path) throws IOException {
		super();
		BufferedReader in = new BufferedReader(new FileReader(path));
		Pattern p = Pattern.compile("\\w+");
		for (String temp = ""; temp != null; temp = in.readLine()) {
			Matcher m = p.matcher(temp);
			while (m.find()) {
				String word = m.group();
				for (Character c : word.toLowerCase().toCharArray()) {
					List<String> lista;
					if (getWords().containsKey(c)) {
						lista = getWords().get(c);
					} else {
						lista = new ArrayList<String>();
					}
					lista.add(word);
					getWords().put(c, lista);
				}
			}
		}
		in.close();
	}

	public Map<Character, List<String>> getWords() {
		return nWords;
	}
	
	
}
