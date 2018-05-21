package org.bienestar.cocina.view;

import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;

import org.bienestar.cocina.view.base.View;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ConsumptionRegisterPage extends View {

	private static final long serialVersionUID = 1L;
	private JTextField txtFecha;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public ConsumptionRegisterPage() {
		setResizable(false);
		setTitle("Registro de Consumo");
		setBounds(100, 100, 550, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(162, 28, 236, 39);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setLabelFor(txtFecha);
		lblFecha.setBounds(26, 31, 115, 33);
		getContentPane().add(lblFecha);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(212, 269, 140, 41);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(378, 269, 140, 41);
		getContentPane().add(btnCancelar);
	}

	public String getDate() {
		return txtFecha.getText();
	}
	
	public void addBtnSaveActionListener(ActionListener action) { 
		btnGuardar.addActionListener(action);
	}
	
	public void addBtnCancelActionListener(ActionListener action) { 
		btnCancelar.addActionListener(action);
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}
}
