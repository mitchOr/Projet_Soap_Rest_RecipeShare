package com.swing.graphique;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.Controller.CreateRecipeFrameController;
import com.model.User;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateRecipeFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8471312968628544322L;
	private JPanel contentPane;
	private CreateRecipeFrameController controller;
	private JTextPane text_BodyRecipe;

	/**
	 * close
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	/**
	 * 
	 * @param body
	 */
	public void setBody(String body) {
		text_BodyRecipe.setText(body);
	}

	/**
	 * Create the frame.
	 */
	public CreateRecipeFrame(User user) {
		controller = new CreateRecipeFrameController(this);
		// text_BodyRecipe.setText(body);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setModal(true);

		JLabel labelCreateNewRecipe = new JLabel("Create New Recipe");
		labelCreateNewRecipe.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton ButtonCancel = new JButton("Cancel");
		ButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonCancel.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JButton ButtonPost = new JButton("Post");
		ButtonPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.post(user, text_BodyRecipe.getText());
			}
		});
		ButtonPost.setFont(new Font("Yu Gothic", Font.ITALIC, 17));

		JLabel labelContent = new JLabel("Content : ");
		labelContent.setFont(new Font("Yu Gothic", Font.ITALIC, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(labelContent)
								.addGap(68).addComponent(labelCreateNewRecipe, GroupLayout.PREFERRED_SIZE, 188,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(ButtonCancel)
												.addGap(28).addComponent(ButtonPost))
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 438,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(37, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(labelCreateNewRecipe)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(labelContent)))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(ButtonPost)
						.addComponent(ButtonCancel, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE))
				.addContainerGap()));

		text_BodyRecipe = new JTextPane();
		scrollPane.setViewportView(text_BodyRecipe);
		contentPane.setLayout(gl_contentPane);
	}
}
