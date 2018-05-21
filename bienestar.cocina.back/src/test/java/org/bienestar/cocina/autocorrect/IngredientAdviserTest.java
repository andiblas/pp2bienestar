package org.bienestar.cocina.autocorrect;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.preparation.PreparationRepository;
import org.junit.Test;

public class IngredientAdviserTest {

	private IngredientAdviser adviser;

	public IngredientAdviserTest() throws IOException {
		super();
		String filePath = new File("").getAbsolutePath();
		String file = filePath.concat(File.separator + "big.txt");
		PreparationRepository repository = new PreparationRepository();
		Preparation te = new Preparation();
		Preparation albondigas = new Preparation();
		repository.getPreparations().add(te);
		Consumption azucarC = new Consumption();
		Ingredient azucar = new Ingredient();
		azucar.setName("Azúcar");
		azucarC.setIngredient(azucar);
		azucarC.setQuantity(300d);
		te.getConsumptions().add(azucarC);
		Ingredient saquito = new Ingredient();
		saquito.setName("Saquito de te");
		Consumption saquitoC = new Consumption();
		saquitoC.setIngredient(saquito);
		saquitoC.setQuantity(20d);
		te.getConsumptions().add(saquitoC);
		repository.getPreparations().add(albondigas);
		adviser = new IngredientAdviser(file, repository);
	}

	@Test
	public void inputa() {
		List<String> result = adviser.getBestFit(null, "a");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputA() {
		List<String> result = adviser.getBestFit(null, "A");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputZ() {
		List<String> result = adviser.getBestFit(null, "Z");
		assertTrue(result.contains("Azúcar"));
	}

	@Test
	public void inputAzu() {
		List<String> result = adviser.getBestFit(null, "Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}

	// input inteligente 2.0
	@Test
	public void inputa20() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "a");
		assertTrue(result.indexOf("Azúcar") == 0);
		assertTrue(result.indexOf("Agua") == 1);
		assertTrue(result.indexOf("Arroz") == 2);
		assertTrue(result.indexOf("Carne Picada") == 3);
	}

	@Test
	public void inputz20Te() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "z");
		assertTrue(result.indexOf("Azúcar") == 0);
		assertTrue(result.indexOf("Arroz") == 1);
	}

	@Test
	public void inputz20Albondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albondigas con arroz");
		List<String> result = adviser.getBestFit(prep, "z");
		assertTrue(result.indexOf("Azúcar") == 1);
		assertTrue(result.indexOf("Arroz") == 0);
	}

	@Test
	public void input20Clbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albondigas con arroz");
		List<String> result = adviser.getBestFit(prep, "c");
		assertTrue(result.indexOf("Carne Picada") == 0);
		assertTrue(result.indexOf("Azúcar") == 1);
	}

	@Test
	public void input20CTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "c");
		assertTrue(result.indexOf("Azúcar") == 0);
		assertTrue(result.indexOf("Carne Picada") == 1);
	}

	@Test
	public void input20rTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "r");
		assertTrue(result.indexOf("Azúcar") == 0);
		assertTrue(result.indexOf("Carne Picada") == 1);
	}

	@Test
	public void input20rAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albondigas con arroz");
		List<String> result = adviser.getBestFit(prep, "r");
		assertTrue(result.indexOf("Carne Picada") == 0);
		assertTrue(result.indexOf("Azúcar") == 1);
	}

	@Test
	public void input20pAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albondigas con arroz");
		List<String> result = adviser.getBestFit(prep, "p");
		assertTrue(result.indexOf("Carne Picada") == 0);
		assertTrue(result.indexOf("Leche en Polvo") == 1);
	}

	@Test
	public void input20pTe() {// Te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "p");
		assertTrue(result.indexOf("Leche en Polvo") == 0);
		assertTrue(result.indexOf("Carne Picada") == 1);
	}

	@Test
	public void input20AzuTe() {// te con leche
		Preparation prep = new Preparation();
		prep.setName("Te con leche");
		List<String> result = adviser.getBestFit(prep, "Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}

	@Test
	public void input20AzuAlbondiga() {// Albondiga
		Preparation prep = new Preparation();
		prep.setName("Albondigas con arroz");
		List<String> result = adviser.getBestFit(prep, "Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}
}
