package org.bienestar.cocina.iteracion.segunda;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.bienestar.cocina.consumption.ConsumptionBuilder;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.InvalidIngredientQuantityException;
import org.bienestar.cocina.exceptions.InvalidRange;
import org.bienestar.cocina.exceptions.NoItemFoundException;
import org.bienestar.cocina.export.CSVExporter;
import org.bienestar.cocina.export.FileSaver;
import org.bienestar.cocina.export.FilenameAssigner;
import org.bienestar.cocina.export.PreparationRegistryTransformer;
import org.bienestar.cocina.preparation.PreparationBuilder;
import org.bienestar.cocina.preparation.PreparationFilter;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Story7Test {

	private CSVExporter exporter;
	private PreparationRegistryRepository repository;
	private PreparationFilter filter;
	
	@Test(expected = Exception.class)
	public void invalidRange() throws InvalidRange{
		filter.getPreparationFilter(repository.getPreparationRegistries(),LocalDate.parse("2017-03-15"),LocalDate.parse("2017-03-13"));
	}
	
	@Test
	public void zeroItem() throws InvalidRange{
		List<PreparationRegistry> registries = filter.getPreparationFilter(repository.getPreparationRegistries(),LocalDate.parse("2017-03-15"),LocalDate.parse("2017-03-17"));
		Assert.assertTrue(registries.isEmpty());
	}
	
	@Test
	public void threeItems() throws InvalidRange{
		List<PreparationRegistry> registries = filter.getPreparationFilter(repository.getPreparationRegistries(),LocalDate.parse("2018-03-16"),LocalDate.parse("2018-03-18"));
		Assert.assertEquals(3, registries.size());
	}
	
	@Test
	public void fileGeneration() throws IOException, NoItemFoundException, InvalidRange{
		List<PreparationRegistry> data = filter.getPreparationFilter(repository.getPreparationRegistries(), LocalDate.parse("2018-03-16"),LocalDate.parse("2018-03-17"));
		String path = exporter.export(data,LocalDate.parse("2018-03-16"),LocalDate.parse("2018-03-17"));
		File f = new File(path);
		assertTrue(f.exists() && !f.isDirectory());
	}
	
	@Test(expected = NoItemFoundException.class)
	public void noItemFoundException() throws IOException, NoItemFoundException, InvalidRange{
		List<PreparationRegistry> data = filter.getPreparationFilter(repository.getPreparationRegistries(), LocalDate.parse("2017-03-15"));
		exporter.export(data, LocalDate.parse("2017-03-15"),LocalDate.parse("2017-03-16"));
	}
	
	@Before
	public void setContexto() throws InvalidIngredientQuantityException{
		repository = new PreparationRegistryRepository();
		filter = new PreparationFilter();
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-15",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createTeConLechePreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16",this.createAlbondigasArrozPreparation()));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-18",this.createLecheChocolatadaPreparation()));
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
