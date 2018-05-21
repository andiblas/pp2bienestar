package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.view.ConsumptionRegisterPage;

public class ConsumptionRegisterController extends Controller<ConsumptionRegisterPage> {

	public ConsumptionRegisterController(ConsumptionRegisterPage view) {
		super(view);
		
		view.addBtnSaveActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

}
