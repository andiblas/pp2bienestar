package org.bienestar.cocina.autocorrect;

import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SpellFixer {

	private Map<Character, List<String>> repository;
	private Comparator<Entry<String, Integer>> comparator;

	public SpellFixer(Map<Character, List<String>> repository, Comparator<Entry<String, Integer>> comparator)
			throws IOException {
		this.repository = repository;
		this.comparator = comparator;
	}

	public List<String> getBestFit(String keyword) {
		Map<String, Integer> candidates = new HashMap<String, Integer>();
		for (Character c : keyword.toLowerCase().toCharArray()) {
			if (repository.containsKey(c)) {
				this.fillCandidates(candidates, repository.get(c));
			}
		}
		if (!candidates.isEmpty()) {
			return candidates.entrySet().stream().sorted(comparator).map(x -> x.getKey())
					.filter(x -> Normalizer.normalize(x, Form.NFD).toLowerCase().contains(keyword.toLowerCase()))
					.collect(Collectors.toList());
		}
		return null;
	}

	private void fillCandidates(Map<String, Integer> candidates, List<String> list) {
		for (String word : list) {
			candidates.put(word, candidates.containsKey(word) ? candidates.get(word) + 1 : 1);
		}
	}

}
