package org.bienestar.cocina.iteracion.segunda;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.bienestar.cocina.consumption.ConsumptionBuilder;
import org.bienestar.cocina.domain.Ingredient;
import org.bienestar.cocina.domain.MeasureType;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.InvalidIngredientQuantityException;
import org.bienestar.cocina.exceptions.NoItemFoundException;
import org.bienestar.cocina.export.CSVExporter;
import org.bienestar.cocina.export.CSVTransformer;
import org.bienestar.cocina.export.FileSaver;
import org.bienestar.cocina.export.FilenameAssigner;
import org.bienestar.cocina.export.PreparationRegistryTransformer;
import org.bienestar.cocina.preparation.PreparationBuilder;
import org.bienestar.cocina.preparation.PreparationFilter;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Story6Test {

	private CSVExporter exporter;
	private PreparationRegistryRepository repository;
	private PreparationFilter filter;
	
	@Test
	public void nameAssigner(){
		FilenameAssigner assigner = new FilenameAssigner();
		String name = assigner.getName(LocalDate.parse("16/03/2018",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Assert.assertEquals("2018-03-16.csv", name);
	}
	
	@Test
	public void oneItem(){
		List<PreparationRegistry> registries = filter.getPreparationFilter(repository.getPreparationRegistries(),LocalDate.parse("2018-03-15"));
		Assert.assertEquals(1, registries.size());
	}
	
	@Test
	public void transformItem() throws InvalidIngredientQuantityException{
		CSVTransformer<PreparationRegistry> transformer = new PreparationRegistryTransformer();
		String text = transformer.transform(this.getPreparationRegistry("2018-03-15"));
		Assert.assertEquals("2018-03-15,20,,Azucar,300.0", text);
	}
	
	@Test
	public void zeroItem(){
		List<PreparationRegistry> registries = filter.getPreparationFilter(repository.getPreparationRegistries(),LocalDate.parse("2017-03-15"));
		Assert.assertTrue(registries.isEmpty());
	}
	
	@Test
	public void fileGeneration() throws IOException, NoItemFoundException{
		List<PreparationRegistry> data = filter.getPreparationFilter(repository.getPreparationRegistries(), LocalDate.parse("2018-03-16"));
		String path = exporter.export(data,LocalDate.parse("2018-03-16"));
		File f = new File(path);
		assertTrue(f.exists() && !f.isDirectory());
	}
	
	@Test(expected = NoItemFoundException.class)
	public void noItemFoundException() throws IOException, NoItemFoundException{
		List<PreparationRegistry> data = filter.getPreparationFilter(repository.getPreparationRegistries(), LocalDate.parse("2017-03-15"));
		exporter.export(data, LocalDate.parse("2017-03-15"));
	}
	
	private Preparation createSimplePreparation() throws InvalidIngredientQuantityException{
		PreparationBuilder builder = new PreparationBuilder();
		builder.addConsumption(ConsumptionBuilder.build(new Ingredient("Azucar",MeasureType.GRAM), 300d));
		return builder.build();
	}
	
	private PreparationRegistry getPreparationRegistry(String date) throws InvalidIngredientQuantityException{
		PreparationRegistry reg1 = new PreparationRegistry();
		reg1.setDate(LocalDate.parse(date));
		reg1.setDiners(20);
		reg1.setPreparation(this.createSimplePreparation());
		return reg1;
	}
	
	@Before
	public void setContexto() throws InvalidIngredientQuantityException{
		repository = new PreparationRegistryRepository();
		filter = new PreparationFilter();
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-15"));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16"));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-16"));
		repository.getPreparationRegistries().add(this.getPreparationRegistry("2018-03-18"));
		exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(), new PreparationRegistryTransformer());
	}
}
