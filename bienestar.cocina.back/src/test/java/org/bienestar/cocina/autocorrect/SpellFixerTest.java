package org.bienestar.cocina.autocorrect;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class SpellFixerTest {

	private ResourceReader reader;
	private SpellFixer spelling;

	public SpellFixerTest() throws IOException {
		super();
		String filePath = new File("").getAbsolutePath();
		reader = new ResourceReader(filePath.concat(File.separator + "big.txt"));
		spelling = new SpellFixer(reader.getWords());
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
