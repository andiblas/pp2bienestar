package org.bienestar.cocina.export;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.PreparationRegistry;
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

	public String export(LocalDate from, LocalDate to) throws IOException {
		String fileName = filenameAssigner.getName(from, to);
		List<String> content = repository.getPreparationRegistries().stream()
				.filter(x -> x.getDate().isAfter(from) && x.getDate().isBefore(to))
				.map(x -> transformer.transform(x))
				.collect(Collectors.toList());
		return fileSaver.save(fileName, content);
	}
}
