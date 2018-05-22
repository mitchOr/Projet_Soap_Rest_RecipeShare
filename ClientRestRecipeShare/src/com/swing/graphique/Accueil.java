package com.swing.graphique;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.Controller.AccueilController;

/**
 * Frame for Accueil
 * 
 * @author MariamKonate
 *
 */
public class Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDate;
	private JLabel lblNameLast;
	private AccueilController controller;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	static int idUserConnecte;

	/**
	 * Method to set the user
	 * 
	 * @param fname
	 * @param Lname
	 * @param id
	 */
	public void setUserName(String fname, String Lname, int id) {
		lblNameLast.setText(fname + " " + Lname);
		idUserConnecte = id;
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * close
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controller = new AccueilController(this);
		this.setBounds(100, 100, 854, 653);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblWelcomeOnRecipe = new JLabel("Welcome on Recipe Share");
		lblWelcomeOnRecipe.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		lblNameLast = new JLabel("Name - last Name of User ");
		lblNameLast.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JLabel lblSearchByDate = new JLabel("Search by Date / Author  :");
		lblSearchByDate.setFont(new Font("Yu Gothic", Font.ITALIC, 13));

		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);

		JButton btnSeDconnecter = new JButton("Sign out");
		btnSeDconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deconnection();
			}
		});

		JButton btnNewButton = new JButton("filtrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filter(textFieldDate.getText());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addGap(97).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblWelcomeOnRecipe, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSearchByDate))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																lblNameLast, GroupLayout.DEFAULT_SIZE, 264,
																Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addGap(33)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
																		103, GroupLayout.PREFERRED_SIZE)
																.addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)))
								.addGap(243))
						.addGroup(
								Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addContainerGap(579, Short.MAX_VALUE).addComponent(btnSeDconnecter,
												GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addGap(117)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(btnSeDconnecter, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblWelcomeOnRecipe)
								.addComponent(lblNameLast))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSearchByDate)
								.addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton).addGap(30)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE).addContainerGap()));

		update();
		this.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu MenuProfile = new JMenu("Profile");
		MenuProfile.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
		menuBar.add(MenuProfile);
		/**
		 * opening the frame profil
		 */
		JMenuItem MenuItemOuvrirProfile = new JMenuItem("Ouvrir");
		MenuItemOuvrirProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.profilLook(idUserConnecte);

			}
		});
		MenuItemOuvrirProfile.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
		MenuProfile.add(MenuItemOuvrirProfile);
	}

	/**
	 * Method to update the table
	 */
	public void update() {
		controller.updateJTable();
		table = controller.getTable();
		scrollPane.setViewportView(table);
		// contr�le bouble clique
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				controller.mousePressed(e);
			}
		});

	}

	/**
	 * Method to get the date
	 * 
	 * @return
	 */
	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	/**
	 * Method to set the date
	 * 
	 * @param textFieldDate
	 */
	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}

}
