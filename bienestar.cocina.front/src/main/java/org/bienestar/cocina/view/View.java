package org.bienestar.cocina.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import org.bienestar.cocina.model.Display;
import org.bienestar.cocina.model.Model;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class View extends JFrame implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	public View(Model model) {
		
		setWindowPreferences();
		
		lblNewLabel = new JLabel("");
		
		btnNewButton = new JButton("Incrementar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(btnNewButton)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addGap(41)
					.addComponent(btnNewButton)
					.addGap(156))
		);
		getContentPane().setLayout(groupLayout);
	}

	public void setMiListener(ActionListener actionListener) {
        btnNewButton.addActionListener(actionListener);
    }
	
	public void update(Observable o, Object arg) {
		Display objectUpdate = (Display) arg;
		lblNewLabel.setText(objectUpdate.getValor().toString());
		
	}

	private void setWindowPreferences() {
        setVisible(true);
        setSize(new Dimension(267, 309));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(420, 220);
    }
}
