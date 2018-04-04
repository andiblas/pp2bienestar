package org.bienestar.cocina;

import javax.swing.SwingUtilities;

import org.bienestar.cocina.controller.Controller;
import org.bienestar.cocina.controller.PlanillaDiariaController;
import org.bienestar.cocina.view.PlantillaDiariaView;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                PlantillaDiariaView view = PlantillaDiariaView.getInstance();
                Controller<PlantillaDiariaView> controller = new PlanillaDiariaController(view);

            }
        });
	}
}
