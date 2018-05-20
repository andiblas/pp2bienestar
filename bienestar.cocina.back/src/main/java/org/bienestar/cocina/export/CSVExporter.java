package org.bienestar.cocina.export;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.verifier.ConsumptionRepository;

public class CSVExporter {

	private final FilenameAssigner filenameAssigner;
	private final FileSaver fileSaver;
	private final TransformView<Consumption> transformView;
	private final ConsumptionRepository repository;

	public CSVExporter(FilenameAssigner filenameAssigner, FileSaver fileSaver, TransformView<Consumption> transformView,
			ConsumptionRepository repository) {
		this.filenameAssigner = filenameAssigner;
		this.fileSaver = fileSaver;
		this.transformView = transformView;
		this.repository = repository;
	}

	public String Export(Date from, Date to) throws IOException {
		String fileName = filenameAssigner.getName(from, to);
		List<String> content = repository.getConsumptions().stream().map(x -> transformView.transform(x))
				.collect(Collectors.toList());
		return fileSaver.save(fileName, content);
	}
}
