package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.validaciones.Validador;
import org.bienestar.cocina.validaciones.impl.ValidadorFecha;
import org.bienestar.cocina.view.PlantillaDiariaView;

public class PlanillaDiariaController extends Controller<PlantillaDiariaView>{
	
	private Validador fechaValidador;

	public PlanillaDiariaController(PlantillaDiariaView view) {
		super(view);
		fechaValidador = new ValidadorFecha();
		fechaValidador.addObserver(view);
		view.asociarEnviarListener(new EnviarListener());
	}
	
	class EnviarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			fechaValidador.validar(getView().getTxtFecha().getText());
		}
    	
    }
}
