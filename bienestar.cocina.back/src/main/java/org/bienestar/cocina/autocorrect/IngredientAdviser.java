package org.bienestar.cocina.autocorrect;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.preparation.PreparationRepository;

public class IngredientAdviser {

	private final SpellFixer spelling;
	private final PreparationRepository repository;

	public IngredientAdviser(String sourcePath, PreparationRepository repository) throws IOException {
		this.repository = repository;
		ResourceReader reader = new ResourceReader(sourcePath);
		this.spelling = new SpellFixer(reader.getWords());
	}

	public List<String> getBestFit(Preparation preparation, String keyword) {

		List<String> result = spelling.getBestFit(keyword);
		
		if (preparation == null) return result;
		
		return sortByPreparation(preparation, result);
	}

	private List<String> sortByPreparation(Preparation query, List<String> result) {
		
		Optional<Preparation> preparation = repository.getPreparations().stream().filter(x -> x.getName() == query.getName()).findFirst();
		
		if (!preparation.isPresent()) return result;
		
		List<Ingredient> ingredients = preparation.get().getConsumptions().stream().map(x -> x.getIngredient())
				.collect(Collectors.toList());
		
		result.sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (ingredients.stream().anyMatch(x -> x.getName() == o1)) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		return result;
	}

}
