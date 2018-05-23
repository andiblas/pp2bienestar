package org.bienestar.cocina.model;

import java.io.IOException;
import java.time.LocalDate;

import org.bienestar.cocina.export.CSVExporterFacade;
import org.bienestar.cocina.model.base.Model;

public class ExportModel extends Model {

	public void export(LocalDate from, LocalDate to) {
		CSVExporterFacade exporterFacade = new CSVExporterFacade();
		
		try {
			exporterFacade.export(from, to);
		} catch (IOException e) {
			notifyObservers(e);
			e.printStackTrace();
		}
	}
	
}
