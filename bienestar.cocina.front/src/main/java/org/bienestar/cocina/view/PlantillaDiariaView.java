package org.bienestar.cocina.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlantillaDiariaView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static PlantillaDiariaView instance;
	
	private JTextField txtFecha;
	private JButton btnEnviar;
	
	public static PlantillaDiariaView getInstance(){
		if(instance == null){
			instance = new PlantillaDiariaView();
		}
		return instance;
	}
	
	private PlantillaDiariaView() {
		setWindowPreferences();
		
		getContentPane().setLayout(null);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setBounds(26, 24, 46, 14);
        getContentPane().add(lblFecha);
        
        txtFecha = new JTextField();
        txtFecha.setBounds(94, 21, 86, 20);
        getContentPane().add(txtFecha);
        txtFecha.setColumns(10);
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(492, 530, 89, 23);
        getContentPane().add(btnEnviar);
	}
	
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(null, "MENSAJE");
	}

	
	public void asociarEnviarListener(ActionListener actionListener){
		btnEnviar.addActionListener(actionListener);
	}
	
	public JTextField getTxtFecha() {
		return txtFecha;
	}

	private void setWindowPreferences() {
        setVisible(true);
        setSize(new Dimension(1024, 640));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(420, 220);
    }
}
