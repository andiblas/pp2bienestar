package org.bienestar.cocina.export;

import java.io.IOException;
import java.time.LocalDate;

import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;
import org.bienestar.cocina.repository.RepositoryStore;

public class CSVExporterFacade {

	public void export(LocalDate from, LocalDate to) throws IOException {
		CSVExporter exporter = new CSVExporter(new FilenameAssigner(), new FileSaver(),
				new PreparationRegistryTransformer(),
				RepositoryStore.getInstance().getPreparationRegistryRepository());

		exporter.export(from, to);
	}

}
