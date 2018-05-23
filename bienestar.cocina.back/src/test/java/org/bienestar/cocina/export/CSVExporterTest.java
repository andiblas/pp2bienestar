package org.bienestar.cocina.export;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Test;

public class CSVExporterTest {

	private CSVExporter exporter;
	
	public CSVExporterTest() {
		PreparationRegistryRepository repository = new PreparationRegistryRepository();
		PreparationRegistry reg1 = new PreparationRegistry();
		reg1.setDate(LocalDate.parse("2018-05-22"));
		Preparation teConLeche = new Preparation();
		List<Consumption> consumptions = new ArrayList<Consumption>();
		Ingredient azucar = new Ingredient();
		azucar.setName("Azucar");
		Consumption azucarConsumption = new Consumption();
		azucarConsumption.setIngredient(azucar);
		azucarConsumption.setQuantity(300d);
		Ingredient saquito = new Ingredient();
		Ingredient lecheEnPolvo = new Ingredient();
		Ingredient agua = new Ingredient();
		consumptions.add(azucarConsumption);
		teConLeche.setConsumptions(consumptions);
		reg1.setPreparation(teConLeche);
		repository.getPreparationRegistries().add(reg1);
		exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(),
				new PreparationRegistryTransformView(), repository);
	}

	@Test
	public void test() throws IOException {
		LocalDate from = LocalDate.parse("2018-05-22");
		LocalDate to = LocalDate.parse("2018-05-22");
		String path = exporter.export(from, to);
		File f = new File(path);
		assertTrue(f.exists() && !f.isDirectory());
	}

}
