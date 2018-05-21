package org.bienestar.cocina;

import javax.swing.SwingUtilities;

import org.bienestar.cocina.controller.MainPageController;
import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.view.MainPage;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MainPage view = new MainPage();
                Controller<MainPage> controller = new MainPageController(view);
                view.setVisible(true);
            }
        });
	}
}
