package com.infy.trial;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class ModifiedTreePanel  
{  
   

    public ModifiedTreePanel()  
    {  
 

        // south section  
        final JLabel colorLabel = new JLabel();  
        colorLabel.setHorizontalAlignment(JLabel.CENTER);  
        Dimension d = colorLabel.getPreferredSize();  
        d.height = 25;  
        colorLabel.setPreferredSize(d);  

        // center section  
        JTree tree = createTree();  
        tree.setCellRenderer(new CustomRenderer(tree));
        tree.getSelectionModel().addTreeSelectionListener(  
                                         new TreeSelectionListener()  
        {  
            public void valueChanged(TreeSelectionEvent e)  
            {  

            }  
        });  

        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.add(new JScrollPane(tree));  
        f.add(colorLabel, "South");  
        f.setSize(400,400);  
        f.setLocation(200,200);  
        f.setVisible(true);  
    }  

    protected JComponent createTabbedPanel (String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1", panel1);
        panel1.setPreferredSize(new Dimension(200, 100));

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", panel2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", panel3);

        panel.add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        panel.setEnabled(true);
        return panel;
    }

    protected JComponent makeTextPanel (String text) {
            JPanel panel = new JPanel(false);
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            panel.setLayout (new GridLayout(1,1));
            panel.add(filler);
            return panel;
    }

    private JTree createTree()  
    {  
        int children = 4;  
        int grandChildren = 1;  

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode node;  
        for(int j = 0; j < children; j++)  
        {  
            node = new DefaultMutableTreeNode("Child-"+String.valueOf(j));

            root.add(node);  
                for(int k = 0; k < grandChildren; k++)  
                    node.add(new DefaultMutableTreeNode(createTabbedPanel("Grand-" + String.valueOf(k))));  
        }  
        DefaultTreeModel model = new DefaultTreeModel(root);  
        return new JTree(model);  
    }  

    public static void main(String[] args)  
    {  
        new ModifiedTreePanel();  
    }  
}  

class CustomRenderer extends AbstractCellEditor 
    implements TreeCellRenderer, TreeCellEditor  
{     

    final JTree tree;

    public CustomRenderer (JTree tree) {
        this.tree = tree;
    }


    public Component getTreeCellRendererComponent(JTree tree,  
                                                  Object value,  
                                                  boolean selected,  
                                                  boolean expanded,  
                                                  boolean leaf,  
                                                  int row,  
                                                  boolean hasFocus)  
    {  
        Object nodeObject = ((DefaultMutableTreeNode)value).getUserObject();
        if (nodeObject instanceof JPanel){
            JPanel panel = (JPanel) nodeObject;    
            panel.setPreferredSize(new Dimension(200, 100)); 
            return panel;
        } else{
            return new JLabel(nodeObject.toString());
        }

    }

    public Component getTreeCellEditorComponent(
            JTree tree, Object value, boolean selected,
            boolean expanded, boolean leaf, int row) {
        return getTreeCellRendererComponent(
                tree, value, true, expanded, leaf, row, true);
    }

    public boolean isCellEditable(final EventObject event) {
        if (!(event instanceof MouseEvent)) {
            return false;
        }

        final MouseEvent mouseEvent = (MouseEvent) event;
        final TreePath path = tree.getPathForLocation(
                mouseEvent.getX(), mouseEvent.getY());
        if (path == null) {
            return false;
        }

        Object node = path.getLastPathComponent();
        if (node == null || (!(node instanceof DefaultMutableTreeNode))) {
            return false;
        }

        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
        Object userObject = treeNode.getUserObject();

        return (userObject instanceof JPanel);
    }


    @Override
    public Object getCellEditorValue() {
        return null;
    }


}
