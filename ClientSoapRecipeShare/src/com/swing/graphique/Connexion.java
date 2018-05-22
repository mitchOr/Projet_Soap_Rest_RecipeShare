package com.swing.graphique;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Controller.ConnexionController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Connexion extends JFrame {

	private static final long serialVersionUID = 3480295180835212758L;
	private JPanel contentPane;
	private JTextField textField_Login;
	private ConnexionController controller;
	private JPasswordField passwordField_Password;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * close
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
	      dispose();
	  }

	/**
	 * Create the frame.
	 */
	public Connexion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		controller=new ConnexionController();
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		
		textField_Login = new JTextField();
		textField_Login.setColumns(10);
		/**
		 * gère la connection
		 */
		JButton Btn_SignIn = new JButton("Log in");
		Btn_SignIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				controller.authentifier(textField_Login.getText(), passwordField_Password.getText());
				dispose();
			}
		});
		Btn_SignIn.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		
		JLabel labelTitre = new JLabel("Connection");
		labelTitre.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		
		 passwordField_Password = new JPasswordField();
		
		JButton Btn_CreerCompte = new JButton("Create new account");
		Btn_CreerCompte.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		Btn_CreerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.createAccount();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37)
									.addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(labelTitre, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Login, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(passwordField_Password)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(Btn_SignIn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(Btn_CreerCompte, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(labelTitre)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelPassword)
						.addComponent(passwordField_Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(Btn_SignIn)
					.addGap(18)
					.addComponent(Btn_CreerCompte, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public ConnexionController getController() {
		return controller;
	}

	public void setController(ConnexionController controller) {
		this.controller = controller;
	}
}
