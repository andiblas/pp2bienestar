package autocorrect;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bienestar.cocina.specifications.validations.Equals;
import org.bienestar.cocina.specifications.validations.GreaterThan;

public class SpellFixer {

	private Map<Character, List<String>> repository;
	private Comparator<Entry<String, Integer>> comparator;

	public SpellFixer(Map<Character, List<String>> repository, Comparator<Entry<String, Integer>> comparator)
			throws IOException {
		this.repository = repository;
		this.comparator = comparator;
	}

	public String getBestFit(String keyword) {
		Map<String, Integer> candidates = new HashMap<String, Integer>();
		for (Character c : keyword.toCharArray()) {
			if (repository.containsKey(c)) {
				this.fillCandidates(candidates, repository.get(c));
			}
		}
		if (!candidates.isEmpty()) {
			return candidates.entrySet().stream().max(comparator).get().getKey();
		}
		return "";
	}

	private void fillCandidates(Map<String, Integer> candidates, List<String> list) {
		for (String word : list) {
			candidates.put(word, candidates.containsKey(word) ? candidates.get(word) + 1 : 1);
		}
	}

	public static void main(String args[]) throws IOException {
		String input = "poio";
		String input2 = "poshio";
		String input3 = "poyo";
		Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return new GreaterThan(entry1.getValue()).isSatisfiedBy(entry2.getValue())
						|| (new Equals(entry1.getValue()).isSatisfiedBy(entry2.getValue())
								&& new GreaterThan(entry2.getKey().length()).isSatisfiedBy(entry1.getKey().length()))
										? 1
										: -1;
			}
		};
		ResourceReader reader = new ResourceReader(
				"E:\\git\\pp2bienestar\\bienestar.cocina.back\\src\\main\\java\\autocorrect\\big.txt");
		SpellFixer spelling = new SpellFixer(reader.getWords(), comparator);
		System.out.println("Input: " + input);
		System.out.println("Sugerencia: " + spelling.getBestFit(input));
		System.out.println("Input: " + input2);
		System.out.println("Sugerencia: " + spelling.getBestFit(input2));
		System.out.println("Input: " + input3);
		System.out.println("Sugerencia: " + spelling.getBestFit(input3));
		System.out.println("Input: " + "cala");
		System.out.println("Sugerencia: " + "gato");
	}

}
