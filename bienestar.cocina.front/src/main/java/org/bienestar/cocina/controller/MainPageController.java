package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.view.MainPage;

public class MainPageController extends Controller<MainPage> {

	public MainPageController(MainPage view) {
		super(view);
		
		view.addMnExportacionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		view.addMnRegistroListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
