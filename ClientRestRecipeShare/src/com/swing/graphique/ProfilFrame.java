package com.swing.graphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.Controller.ProfilController;
import com.model.User;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;

/**
 * 
 * Class ProfilFrame
 *
 */
public class ProfilFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldfirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldBirthDay;
	private JTable table;
	private ProfilController controller;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * fill the frame
	 * 
	 * @param fname
	 * @param lname
	 * @param birthday
	 */
	public void edit(int id, String fname, String lname, String birthday) {
		controller.setId(id);
		textFieldBirthDay.setText(birthday);
		textFieldfirstName.setText(fname);
		textFieldLastName.setText(lname);
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
	public ProfilFrame(User user) {
		controller = new ProfilController(this, user.getId());

		setModal(true);
		setBounds(100, 100, 718, 614);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel labelTitre = new JLabel("Profile");
		labelTitre.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		JLabel labelFirstName = new JLabel("First Name :  ");
		labelFirstName.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		JLabel labellastName = new JLabel("Last Name : ");
		labellastName.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		JLabel labelBirthDay = new JLabel("Birth Day  : ");
		labelBirthDay.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JLabel lblMyRecipes = new JLabel("My Recipes : ");
		lblMyRecipes.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		textFieldfirstName = new JTextField();
		textFieldfirstName.setEditable(false);
		textFieldfirstName.setColumns(10);
		textFieldLastName = new JTextField();
		textFieldLastName.setEditable(false);
		textFieldLastName.setColumns(10);
		textFieldBirthDay = new JTextField();
		textFieldBirthDay.setEditable(false);
		textFieldBirthDay.setColumns(10);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblMyRecipes)
						.addContainerGap(636, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_contentPanel.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(labelBirthDay).addComponent(labelFirstName,
												GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldBirthDay).addComponent(textFieldfirstName,
												GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
								.addComponent(labellastName).addGap(18)
								.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 109,
										GroupLayout.PREFERRED_SIZE)
								.addGap(99))
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(285)
						.addComponent(labelTitre, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(306, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addComponent(labelTitre).addGap(36)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(labellastName)
						.addComponent(textFieldfirstName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(labelBirthDay)
						.addComponent(textFieldBirthDay, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(lblMyRecipes).addGap(26)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE).addContainerGap()));
		{
			// int table = this.UserId;
			update();
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonCreate = new JButton("Create");
				ButtonCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controller.createRecipe(user);
					}
				});
				ButtonCreate.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
				buttonPane.add(ButtonCreate);
			}
			{
				JButton ButtonEdit = new JButton("Edit");
				ButtonEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.editRecipe(user);
					}
				});
				ButtonEdit.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
				buttonPane.add(ButtonEdit);
			}
			{
				JButton ButtonDelete = new JButton("Delete");
				ButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.deletRecipe();
					}
				});
				ButtonDelete.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
				buttonPane.add(ButtonDelete);
			}
			{
				JButton ButtonClose = new JButton("Close");
				ButtonClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				ButtonClose.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
				ButtonClose.setActionCommand("Cancel");
				buttonPane.add(ButtonClose);
			}
		}
		edit(user.getId(), user.getfName(), user.getlName(), user.getBirthDate());

	}

	/**
	 * update
	 */
	public void update() {
		controller.updateJTable();
		table = controller.getTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				controller.mousePress(e);
			}
		});
	}

	/**
	 * Method to get table
	 * 
	 * @return
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Method to set table
	 * 
	 * @param table
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

}
