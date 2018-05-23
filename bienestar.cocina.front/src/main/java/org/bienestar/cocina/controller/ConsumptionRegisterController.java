package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.bienestar.cocina.autocorrect.IngredientAdviser;
import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.repository.RepositoryStore;
import org.bienestar.cocina.view.ConsumptionRegisterPage;
import org.bienestar.cocina.view.base.SimpleDocumentListener;

public class ConsumptionRegisterController extends Controller<ConsumptionRegisterPage> {

	public ConsumptionRegisterController(final ConsumptionRegisterPage view) {
		super(view);

		view.addBtnSaveActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		String filePath = new File("").getAbsolutePath();
		String file = filePath.concat(File.separator + "big.txt");
		try {
			final IngredientAdviser adviser = new IngredientAdviser(file,
					RepositoryStore.getInstance().getPreparationRepository());
			view.addTxtIngredienteUpdateListener(new SimpleDocumentListener() {
				@Override
				public void change(DocumentEvent e) {
					List<String> bestFit = adviser.getBestFit(null, view.getTxtIngrediente());
					if (bestFit != null)
						view.setSuggestionsList(bestFit);
				}
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
