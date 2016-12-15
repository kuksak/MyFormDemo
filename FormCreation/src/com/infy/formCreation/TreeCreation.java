package com.infy.formCreation;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.infy.formCreation.RowElement;
public class TreeCreation {
	
	public JTree treeCreation(){
		JTree tree = new JTree();
		
	    
		JLabel address = new JLabel("Address");
		JTextField addressLine = new JTextField("Enter address");
		JTextField country = new JTextField("country");
		JTextField district = new JTextField("district");
		
		RowElement row1 = new RowElement(address,addressLine,country,district);
		
		
		
		JLabel homeAddress = new JLabel("Home Address");
		JTextField homeAddressLine = new JTextField("Enter home address");
		JTextField homeCountry = new JTextField("country");
		JTextField homeDistrict = new JTextField("district");
		
		RowElement row2 = new RowElement(homeAddress,homeAddressLine,homeCountry,homeDistrict);
		
		
		JLabel officeAddress = new JLabel("Office Address");
		JTextField officeAddressLine = new JTextField("Enter office address");
		JTextField officeCountry = new JTextField("country");
		JTextField officeDistrict = new JTextField("district");
		
		RowElement row3 = new RowElement(officeAddress,officeAddressLine,officeCountry,officeDistrict);
		
		
		DefaultMutableTreeNode addresss = new DefaultMutableTreeNode("Address");
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(row1.setPanel());
		DefaultMutableTreeNode homeNode = new DefaultMutableTreeNode(row2.setPanel());
		DefaultMutableTreeNode officeNode = new DefaultMutableTreeNode(row3.setPanel());
		
		addresss.add(rootNode);
		rootNode.add(homeNode);
		rootNode.add(officeNode);
		
		DefaultTreeModel model = new DefaultTreeModel(addresss);
	
		return new JTree(model);
		
	}
	
		
}
