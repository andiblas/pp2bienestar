package org.bienestar.cocina.export;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.NoItemFoundException;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;

public class CSVExporter {

	private final FilenameAssigner filenameAssigner;
	private final FileSaver fileSaver;
	private final CSVTransformer<PreparationRegistry> transformer;
	private final PreparationRegistryRepository repository;

	public CSVExporter(FilenameAssigner filenameAssigner, FileSaver fileSaver,
			CSVTransformer<PreparationRegistry> transformer, PreparationRegistryRepository repository) {
		this.filenameAssigner = filenameAssigner;
		this.fileSaver = fileSaver;
		this.transformer = transformer;
		this.repository = repository;
	}

	public String export(LocalDate from, LocalDate to) throws IOException, NoItemFoundException {
		String fileName = filenameAssigner.getName(from, to);
		List<String> content = getPreparationFilter(from, to).stream()
				.map(x -> transformer.transform(x))
				.collect(Collectors.toList());
		if(content == null || content.isEmpty()){
			throw new NoItemFoundException();
		}
		
		return fileSaver.save(fileName, content);
	}
	
	public String export(LocalDate day) throws IOException, NoItemFoundException {
		return this.export(day, day);
	}
	
	public List<PreparationRegistry> getPreparationFilter(LocalDate from, LocalDate to){
		return repository.getPreparationRegistries().stream()
				.filter(x -> (x.getDate().isAfter(from)||x.getDate().equals(from)) && (x.getDate().isBefore(to) || x.getDate().equals(to) )).collect(Collectors.toList());
	}
	
	public List<PreparationRegistry> getPreparationFilter(LocalDate day){
		return this.getPreparationFilter(day, day);
	}
}
