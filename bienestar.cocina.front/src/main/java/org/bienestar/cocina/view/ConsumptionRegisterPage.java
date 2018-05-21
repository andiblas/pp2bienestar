package org.bienestar.cocina.view;

import java.util.Observable;

import javax.swing.JFrame;

import org.bienestar.cocina.view.base.View;

public class ConsumptionRegisterPage extends View {

	private static final long serialVersionUID = 1L;

	public ConsumptionRegisterPage() {
		setTitle("Registro de Consumo");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}

	public void update(Observable arg0, Object arg1) {
		
	}

}
