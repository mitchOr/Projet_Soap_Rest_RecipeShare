package com.swing.graphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import com.Controller.CreateController;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * @wbp.nonvisual location=31,-11
	 */
	private JTextField textFieldFisrtName;
	private JTextField textFieldLastName;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldPassword;
	private JPasswordField passwordFieldConfirmPassword;
	private JFormattedTextField formattedTextField;
	CreateController controller;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * Create the dialog.
	 */
	public CreateUser() {
		setBounds(100, 100, 450, 522);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		controller = new CreateController(this);
		JLabel lblCreateNewUser = new JLabel("Create New User");
		lblCreateNewUser.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JLabel lblFirstName = new JLabel("First Name : ");
		lblFirstName.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		textFieldFisrtName = new JTextField();
		textFieldFisrtName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);

		JLabel lblBirthDay = new JLabel("Birth Day : ");
		lblBirthDay.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		JLabel lblConfirmPassword = new JLabel("Confirm Password : ");
		lblConfirmPassword.setFont(new Font("Yu Gothic", Font.ITALIC, 14));

		passwordFieldPassword = new JPasswordField();

		passwordFieldConfirmPassword = new JPasswordField();

		DateFormatter dateFormatter = new DateFormatter(new SimpleDateFormat("yyyy-MM-dd"));

		DefaultFormatterFactory dateFormatterFactory = new DefaultFormatterFactory(dateFormatter, new DateFormatter(),
				dateFormatter);

		formattedTextField = new JFormattedTextField(dateFormatterFactory);

		// initialize with now
		formattedTextField.setValue(new Date());

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(28).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblConfirmPassword)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(passwordFieldConfirmPassword, 168, 168, 168).addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName).addComponent(lblLastName).addComponent(lblBirthDay)
										.addComponent(lblLogin).addComponent(lblPassword))
								.addGap(47)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addComponent(passwordFieldPassword, 168, 168, 168).addContainerGap())
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(textFieldLogin, 168, 168, 168).addContainerGap())
												.addGroup(Alignment.TRAILING,
														gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(textFieldLastName,
																		GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
																.addComponent(textFieldFisrtName,
																		GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
																.addComponent(formattedTextField, Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE, 99,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblCreateNewUser, Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE, 162,
																		GroupLayout.PREFERRED_SIZE))
																.addGap(97))))))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addComponent(lblCreateNewUser).addGap(29)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFirstName)
						.addComponent(textFieldFisrtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblLastName)
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addGap(48)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblBirthDay)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(51)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblLogin)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword).addComponent(
								passwordFieldPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(39)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblConfirmPassword)
						.addComponent(passwordFieldConfirmPassword, GroupLayout.PREFERRED_SIZE, 29,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(22, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {

						controller.createUser(textFieldFisrtName.getText(), textFieldLastName.getText(),
								formattedTextField.getText(), textFieldLogin.getText(), passwordFieldPassword.getText(),
								passwordFieldConfirmPassword.getText());
					}
				});
				okButton.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controller.close();
					}
				});
				cancelButton.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
