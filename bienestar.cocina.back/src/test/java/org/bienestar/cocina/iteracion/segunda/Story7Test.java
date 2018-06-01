package org.bienestar.cocina.iteracion.segunda;

import java.time.LocalDate;
import java.util.List;

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
import org.bienestar.cocina.preparation.PreparationFilter;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Before;
import org.junit.Test;

public class Story7Test {

	private CSVExporter exporter;
	private PreparationRegistryRepository repository;
	private PreparationFilter filter;
	
	@Test
	public void invalidRange(){
		
	}
	
	@Test
	public void zeroItem(){
		
	}
	
	@Test
	public void twoItem(){
		
	}
	
	@Before
	public void setContexto() throws InvalidIngredientQuantityException{
		repository = new PreparationRegistryRepository();
		filter = new PreparationFilter();
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-15",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createAlbondigasArrozPreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-18",this.createLecheChocolatadaPreparation()));
		List<PreparationRegistry> data = filter.getPreparationFilter(repository.getPreparationRegistries(), LocalDate.parse("2017-03-15"));
		exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(), new PreparationRegistryTransformer());
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
