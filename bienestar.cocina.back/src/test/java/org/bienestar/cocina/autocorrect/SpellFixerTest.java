package org.bienestar.cocina.autocorrect;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import org.bienestar.cocina.specifications.validations.Equals;
import org.bienestar.cocina.specifications.validations.GreaterThan;
import org.junit.Test;

public class SpellFixerTest {

	private Comparator<Entry<String, Integer>> comparator;
	private ResourceReader reader;
	private SpellFixer spelling;

	public SpellFixerTest() throws IOException {
		super();
		comparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return new GreaterThan(entry1.getValue()).isSatisfiedBy(entry2.getValue())
						|| (new Equals(entry1.getValue()).isSatisfiedBy(entry2.getValue())
								&& new GreaterThan(entry2.getKey().length()).isSatisfiedBy(entry1.getKey().length()))
										? 1
										: -1;
			}
		};
		String filePath = new File("").getAbsolutePath();
		reader = new ResourceReader(filePath.concat("\\big.txt"));
		spelling = new SpellFixer(reader.getWords(), comparator);
	}

	@Test
	public void inputa() {
		List<String> result = spelling.getBestFit("a");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputA() {
		List<String> result = spelling.getBestFit("A");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputZ() {
		List<String> result = spelling.getBestFit("Z");
		assertTrue(result.contains("Azúcar"));
	}

	@Test
	public void inputAzu() {
		List<String> result = spelling.getBestFit("Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}

}
