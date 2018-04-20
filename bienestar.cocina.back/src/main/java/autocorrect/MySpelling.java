package autocorrect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySpelling {

	private final Map<Character, List<String>> nWords = new HashMap<Character, List<String>>();
	private Map<String, Integer> candidates = new HashMap<String, Integer>();

	public MySpelling(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		Pattern p = Pattern.compile("\\w+");
		for (String temp = ""; temp != null; temp = in.readLine()) {
			Matcher m = p.matcher(temp.toLowerCase());
			while (m.find()) {
				String word = m.group();
				for (Character c : word.toCharArray()) {
					List<String> lista;
					if (nWords.containsKey(c)) {
						lista = nWords.get(c);
					} else {
						lista = new ArrayList<String>();
					}
					lista.add(word);
					nWords.put(c, lista);
				}
			}
		}
		in.close();
	}

	public String sugerencia(String keyword) {
		candidates = new HashMap<String, Integer>();
		for (Character c : keyword.toCharArray()) {
			if (nWords.containsKey(c)) {
				this.contarOcurrencias(nWords.get(c));
			}
		}
		if (!candidates.isEmpty()) {
			Comparator<Entry<String, Integer>> comparator = (entry1, entry2) -> entry1.getValue() > entry2.getValue()
					|| (entry1.getValue() == entry2.getValue() && entry1.getKey().length() < entry2.getKey().length())
					? 1
					: -1;
			return candidates.entrySet().stream().max(comparator)
					.get().getKey();
		}
		return "";
	}

	private void contarOcurrencias(List<String> list) {
		for (String word : list) {
			candidates.put(word, candidates.containsKey(word) ? candidates.get(word) + 1 : 1);
		}
	}

	public static void main(String args[]) throws IOException {
		String input = "poio";
		String input2 = "poshio";
		String input3 = "poyo";
		MySpelling spelling = new MySpelling("C:\\wks\\bienestar\\autocorrect\\src\\main\\java\\big.txt");
		System.out.println("Input: " + input);
		System.out.println("Sugerencia: " + spelling.sugerencia(input));
		System.out.println("Input: " + input2);
		System.out.println("Sugerencia: " + spelling.sugerencia(input2));
		System.out.println("Input: " + input3);
		System.out.println("Sugerencia: " + spelling.sugerencia(input3));
		System.out.println("Input: " + "cala");
		System.out.println("Sugerencia: " + "gato");
	}

}
