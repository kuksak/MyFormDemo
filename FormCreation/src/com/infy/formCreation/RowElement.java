package com.infy.formCreation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RowElement {
	
	JLabel address;
	JTextField addressLine;
	JTextField country;
	JTextField district;
	

	public RowElement(JLabel address, JTextField addressLine, JTextField country, JTextField district) {
		this.address = address;
		this.addressLine = addressLine;
		this.country = country;
		this.district = district;
	}
	public JPanel setPanel(){
		JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpanel.add(address);
		jpanel.add(addressLine);
		jpanel.add(country);
		jpanel.add(district);
		//jpanel.setSize(200, 30);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		jpanel.setBorder(blackline);
		jpanel.setEnabled(true);
		return jpanel;
	}
}