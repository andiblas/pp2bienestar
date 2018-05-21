package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.view.ExportFilePage;

public class ExportFileController extends Controller<ExportFilePage> {

	public ExportFileController(ExportFilePage view) {
		super(view);
		
		view.addBtnExportarActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getView(), "Test", "Title", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

}
