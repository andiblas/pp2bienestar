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
		PreparationRegistry reg2 = new PreparationRegistry();
		PreparationRegistry reg3 = new PreparationRegistry();
		PreparationRegistry reg4 = new PreparationRegistry();

		reg1.setDate(LocalDate.parse("2018-03-15"));
		reg2.setDate(LocalDate.parse("2018-03-16"));
		reg3.setDate(LocalDate.parse("2018-03-16"));
		reg4.setDate(LocalDate.parse("2018-03-18"));
		
		Preparation teConLeche = new Preparation();
		Preparation albondigasArroz = new Preparation();
		Preparation lecheChocolatada = new Preparation();

		List<Consumption> consumptions = new ArrayList<Consumption>();
		Ingredient azucar = new Ingredient();
		azucar.setName("Azucar");
		Consumption azucarConsumption = new Consumption();
		azucarConsumption.setIngredient(azucar);
		azucarConsumption.setQuantity(300d);
		
		Ingredient saquito = new Ingredient();
		saquito.setName("Saquito de Te");
		Consumption saquitoConsumption=new Consumption();
		saquitoConsumption.setIngredient(saquito);
		saquitoConsumption.setQuantity(20d);
		
		Ingredient lecheEnPolvo = new Ingredient();
		lecheEnPolvo.setName("Leche en Polvo");
		Consumption lecheEnPolvoConsumption=new Consumption();
		lecheEnPolvoConsumption.setIngredient(lecheEnPolvo);
		lecheEnPolvoConsumption.setQuantity(100d);
		
		Ingredient agua = new Ingredient();
		agua.setName("Agua");
		Consumption aguaConsumption=new Consumption();
		aguaConsumption.setIngredient(agua);
		aguaConsumption.setQuantity(10d);
		
		consumptions.add(azucarConsumption);
		consumptions.add(saquitoConsumption);
		consumptions.add(lecheEnPolvoConsumption);
		consumptions.add(aguaConsumption);
		teConLeche.setConsumptions(consumptions);
		reg1.setPreparation(teConLeche);
		reg2.setPreparation(teConLeche);
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
