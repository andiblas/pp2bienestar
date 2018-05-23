package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.model.base.Model;
import org.bienestar.cocina.view.PlantillaDiariaView;

public class PlanillaDiariaController extends Controller<PlantillaDiariaView, Model>{
	

	public PlanillaDiariaController(PlantillaDiariaView view, Model model) {
		super(view, model);
		view.asociarEnviarListener(new EnviarListener());
	}
	
	class EnviarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		}
    	
    }
}
