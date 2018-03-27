package org.bienestar.cocina;

import javax.swing.SwingUtilities;

import org.bienestar.cocina.controller.Controller;
import org.bienestar.cocina.model.Model;
import org.bienestar.cocina.view.View;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                Model model = new Model();
                View view = new View(model);
                Controller controller = new Controller(model, view);

                model.addObserver(view);

            }
        });
	}
}
