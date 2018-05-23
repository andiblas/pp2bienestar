package org.bienestar.cocina;

import javax.swing.SwingUtilities;

import org.bienestar.cocina.controller.MainPageController;
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
                MainPageController controller = new MainPageController(view, null);
                view.setVisible(true);
            }
        });
	}
}
