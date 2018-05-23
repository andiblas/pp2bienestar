package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.model.ExportModel;
import org.bienestar.cocina.view.ExportFilePage;

public class ExportFileController extends Controller<ExportFilePage, ExportModel> {
	
	public ExportFileController(final ExportFilePage view, final ExportModel exportModel) {
		super(view, exportModel);
		
		view.addBtnExportarActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDate dateFrom = view.getDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate dateTo = view.getDateTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				getModel().export(dateFrom, dateTo);
			}
		});
	}

}
