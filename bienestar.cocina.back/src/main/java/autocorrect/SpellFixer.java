package autocorrect;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SpellFixer {

	private Map<Character, List<String>> repository;
	private Comparator<Entry<String, Integer>> comparator;

	public SpellFixer(Map<Character, List<String>> repository) throws IOException {
		this.repository = repository;
		comparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry1.getValue() > entry2.getValue()
					|| (entry1.getValue() == entry2.getValue() && entry1.getKey().length() < entry2.getKey().length())
					? 1
					: -1;
			}
		};
	}

	public String sugerencia(String keyword) {
		Map<String, Integer> candidates = new HashMap<String, Integer>();
		for (Character c : keyword.toCharArray()) {
			if (repository.containsKey(c)) {
				this.contarOcurrencias(candidates, repository.get(c));
			}
		}
		if (!candidates.isEmpty()) {		
			return candidates.entrySet().stream().max(comparator)
					.get().getKey();
		}
		return "";
	}

	private void contarOcurrencias(Map<String, Integer> candidates, List<String> list) {
		for (String word : list) {
			candidates.put(word, candidates.containsKey(word) ? candidates.get(word) + 1 : 1);
		}
	}

	public static void main(String args[]) throws IOException {
		String input = "poio";
		String input2 = "poshio";
		String input3 = "poyo";
		ResourceReader reader = new ResourceReader("E:\\git\\pp2bienestar\\bienestar.cocina.back\\src\\main\\java\\autocorrect\\big.txt");
		SpellFixer spelling = new SpellFixer(reader.getWords());
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
