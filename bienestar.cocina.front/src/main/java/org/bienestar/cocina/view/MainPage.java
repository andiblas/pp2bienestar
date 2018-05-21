package org.bienestar.cocina.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainPage extends View implements Observer {


	private static final long serialVersionUID = 1L;
	private JMenu mnRegistro;
	private JMenu mnExportacion;
	
	public MainPage() {
		setMinimumSize(new Dimension(700, 500));
		setTitle("Registro de Consumos");
		setBounds(100, 100, 785, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		getContentPane().add(menuBar);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mnExportacion = new JMenu("Exportacion");
		menuBar.add(mnExportacion);
	}

	public void addMnRegistroListener(ActionListener action) {
		mnRegistro.addActionListener(action);
	}
	
	public void addMnExportacionListener(ActionListener action) {
		mnExportacion.addActionListener(action);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
