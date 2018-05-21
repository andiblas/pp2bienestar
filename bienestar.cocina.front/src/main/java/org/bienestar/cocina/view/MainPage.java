package org.bienestar.cocina.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import org.bienestar.cocina.view.base.View;
import javax.swing.JMenuItem;

public class MainPage extends View implements Observer {


	private static final long serialVersionUID = 1L;
	private JMenu mnConsumos;
	private JMenu mnExportacion;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmExportarACsv;
	
	public MainPage() {
		setMinimumSize(new Dimension(700, 500));
		setTitle("Registro de Consumos");
		setBounds(100, 100, 785, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0, getWidth(), getHeight());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, getWidth(), 21);
		getContentPane().add(menuBar);
		
		mnConsumos = new JMenu("Consumos");
		menuBar.add(mnConsumos);
		
		mntmRegistro = new JMenuItem("Registro");
		mnConsumos.add(mntmRegistro);
		
		mnExportacion = new JMenu("Exportacion");
		menuBar.add(mnExportacion);
		
		mntmExportarACsv = new JMenuItem("Exportar a CSV");
		mnExportacion.add(mntmExportarACsv);
	}

	public void addMnRegistroListener(ActionListener action) {
		mntmRegistro.addActionListener(action);
	}
	
	public void addMnExportacionListener(ActionListener action) {
		mntmExportarACsv.addActionListener(action);
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}
}
