package org.bienestar.cocina.iteracion.segunda;

import java.time.LocalDate;

import org.bienestar.cocina.consumption.ConsumptionBuilder;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.InvalidIngredientQuantityException;
import org.bienestar.cocina.export.CSVExporter;
import org.bienestar.cocina.export.FileSaver;
import org.bienestar.cocina.export.FilenameAssigner;
import org.bienestar.cocina.export.PreparationRegistryTransformer;
import org.bienestar.cocina.preparation.PreparationBuilder;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Before;

public class Story7Test {

	private CSVExporter exporter;
	
	@Before
	public void setContexto() throws InvalidIngredientQuantityException{
		PreparationRegistryRepository repository = new PreparationRegistryRepository();
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-15",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createAlbondigasArrozPreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-18",this.createLecheChocolatadaPreparation()));
		exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(), new PreparationRegistryTransformer(),
				repository);
	}
	
	private Preparation createTeConLechePreparation() throws InvalidIngredientQuantityException{
		PreparationBuilder builder = new PreparationBuilder();
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Azucar",MeasureType.GRAM), 300d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Saquito de Te",MeasureType.UNIT), 20d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Leche en Polvo",MeasureType.GRAM), 100d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Agua",MeasureType.LITERS), 10d));
		return builder.build();
	}
	
	private Preparation createAlbondigasArrozPreparation() throws InvalidIngredientQuantityException{
		PreparationBuilder builder = new PreparationBuilder();
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Arroz",MeasureType.GRAM), 1d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Carne Picada",MeasureType.KILOGRAM), 300d));
		return builder.build();
	}
	
	private Preparation createLecheChocolatadaPreparation() throws InvalidIngredientQuantityException{
		PreparationBuilder builder = new PreparationBuilder();
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Cacao",MeasureType.GRAM), 100d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Leche en Polvo",MeasureType.GRAM), 100d));
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Agua",MeasureType.LITERS), 10d));
		return builder.build();
	}
	
	private PreparationRegistry getPreparationRegistry(String date, Preparation preparation) throws InvalidIngredientQuantityException{
		PreparationRegistry reg1 = new PreparationRegistry();
		reg1.setDate(LocalDate.parse(date));
		reg1.setDiners(20);
		reg1.setPreparation(preparation);
		return reg1;
	}
}
