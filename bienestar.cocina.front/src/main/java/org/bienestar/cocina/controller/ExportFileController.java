package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.export.CSVExporterFacade;
import org.bienestar.cocina.view.ExportFilePage;

public class ExportFileController extends Controller<ExportFilePage> {

	public ExportFileController(final ExportFilePage view) {
		super(view);
		
		view.addBtnExportarActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CSVExporterFacade exporterFacade = new CSVExporterFacade();
				
				LocalDate dateFrom = view.getDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate dateTo = view.getDateTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				try {
					exporterFacade.export(dateFrom, dateTo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
