package org.bienestar.cocina.view;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import org.bienestar.cocina.view.base.View;

import com.mxrck.autocompleter.TextAutoCompleter;

public class ConsumptionRegisterPage extends View {

	private static final long serialVersionUID = 1L;
	private JTextField txtFecha;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField txtIngrediente;
	private TextAutoCompleter txtIngredienteAutoCompleter;

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

		JLabel lblIngrediente = new JLabel("Ingrediente");
		lblIngrediente.setBounds(26, 78, 115, 33);
		getContentPane().add(lblIngrediente);

		txtIngrediente = new JTextField();
		txtIngrediente.setColumns(10);
		txtIngrediente.setBounds(162, 75, 236, 39);
		getContentPane().add(txtIngrediente);

		txtIngredienteAutoCompleter = new TextAutoCompleter(txtIngrediente);
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

	public void addTxtIngredienteUpdateListener(DocumentListener documentListener) {
		txtIngrediente.getDocument().addDocumentListener(documentListener);
	}

	public String getTxtIngrediente() {
		return txtIngrediente.getText();
	}

	public void setSuggestionsList(List<String> suggestions) {
		txtIngredienteAutoCompleter.setItems(suggestions.toArray());
	}

	public void update(Observable arg0, Object arg1) {

	}

}
