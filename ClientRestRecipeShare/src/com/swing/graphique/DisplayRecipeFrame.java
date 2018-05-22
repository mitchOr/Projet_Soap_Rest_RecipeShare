package com.swing.graphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Class DisplayRecipeFrame
 */
public class DisplayRecipeFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAuthor;
	private JTextField txtDateOfCreation;
	private JTextPane text_BodyRecipe;

	/**
	 * initialize the attribute of the Frame
	 * 
	 * @param author
	 * @param date
	 * @param body
	 */
	public void setRecipeField(String author, String date, String body) {
		txtAuthor.setText(author);
		txtDateOfCreation.setText(date);
		text_BodyRecipe.setText(body);
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
	public DisplayRecipeFrame() {
		setBounds(100, 100, 583, 546);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel labelTitle = new JLabel("Display Recipe");
		labelTitle.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		JLabel labelAuthor = new JLabel("Author  : ");
		labelAuthor.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		txtAuthor = new JTextField();
		txtAuthor.setText("Name - last Name of Author");
		txtAuthor.setEditable(false);
		txtAuthor.setColumns(10);
		JLabel labelDateCreation = new JLabel("Date Creation : ");
		labelDateCreation.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		txtDateOfCreation = new JTextField();
		txtDateOfCreation.setText("Date of Creation Recipe");
		txtDateOfCreation.setEditable(false);
		txtDateOfCreation.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		JLabel labeContent = new JLabel("Content : ");
		labeContent.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);

		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(25).addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(labelAuthor).addComponent(labelDateCreation)
												.addComponent(labeContent))
										.addGap(9)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDateOfCreation, GroupLayout.PREFERRED_SIZE, 133,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, 168,
														GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(216).addComponent(labelTitle,
								GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(33, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addComponent(labelTitle).addGap(28)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(labelAuthor)
						.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(labelDateCreation)
						.addComponent(txtDateOfCreation, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGap(30).addComponent(labeContent).addGap(38)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE).addContainerGap()));

		text_BodyRecipe = new JTextPane();
		text_BodyRecipe.setText("Content of recipe");
		text_BodyRecipe.setEditable(false);
		scrollPane.setViewportView(text_BodyRecipe);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton CloseButton = new JButton("Close");
				CloseButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				CloseButton.setActionCommand("Cancel");
				buttonPane.add(CloseButton);
			}
		}
	}

}
