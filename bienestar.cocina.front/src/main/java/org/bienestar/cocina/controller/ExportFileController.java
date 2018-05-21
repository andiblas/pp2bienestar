package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.export.CSVExporterFacade;
import org.bienestar.cocina.view.ExportFilePage;

public class ExportFileController extends Controller<ExportFilePage> {

	public ExportFileController(ExportFilePage view) {
		super(view);
		
		view.addBtnExportarActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CSVExporterFacade exporterFacade = new CSVExporterFacade();
				//exporterFacade.export(view.getDateFrom(), view.getDateTo());
			}
		});
	}

}
