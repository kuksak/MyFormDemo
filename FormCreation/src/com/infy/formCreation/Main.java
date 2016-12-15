package com.infy.formCreation;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpringLayout;

import com.infy.formCreation.TreeCreation;
import com.infy.formCreation.CustomRenderer;

public class Main {
	public static void main(String args[]) {

		JTree jTree;

		JLabel username = new JLabel("Name");
		JTextField usernameText = new JTextField(20);

		JFrame jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(400, 400);

		jframe.setLocation(400, 250);

		TreeCreation tree = new TreeCreation();

		jTree = tree.treeCreation();
		jTree.setCellRenderer(new CustomRenderer(jTree));

		Container contentPane = jframe.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		layout.putConstraint(SpringLayout.WEST, username, 5, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, username, 5, SpringLayout.NORTH, contentPane);

		layout.putConstraint(SpringLayout.WEST, usernameText, 5, SpringLayout.EAST, username);
		layout.putConstraint(SpringLayout.NORTH, usernameText, 5, SpringLayout.NORTH, contentPane);
		
		layout.putConstraint(SpringLayout.WEST, jTree, 5, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, jTree, 30, SpringLayout.NORTH, contentPane);
		
		

		contentPane.add(username);
		contentPane.add(usernameText);
		contentPane.add(jTree);

		// jframe.add(jTree);
		jframe.setVisible(true);

	}

}