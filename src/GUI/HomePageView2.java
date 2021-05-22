package GUI;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class HomePageView2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePageView2() {
		
		JTree tree = new JTree();
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setVisibleRowCount(2000);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("All Categories") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Electronic");
						node_2 = new DefaultMutableTreeNode("Small Appliances");
							node_3 = new DefaultMutableTreeNode("Broom");
								node_3.add(new DefaultMutableTreeNode("Xiaomi Mi Robot Vacuum Mop Pro Cleaner"));
								node_3.add(new DefaultMutableTreeNode("Arnica Bora Mor Et11133"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Telephone");
							node_2.add(new DefaultMutableTreeNode("dkh"));
							node_2.add(new DefaultMutableTreeNode("dfmgm"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Clothing");
						node_2 = new DefaultMutableTreeNode("Female");
							node_3 = new DefaultMutableTreeNode("Tshirt");
								node_3.add(new DefaultMutableTreeNode("dh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Jean");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Coat");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Dress");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Skirt");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Male");
							node_3 = new DefaultMutableTreeNode("Tshirt");
								node_3.add(new DefaultMutableTreeNode("dh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Jean");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Coat");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Kids");
							node_3 = new DefaultMutableTreeNode("Tshirt");
								node_3.add(new DefaultMutableTreeNode("dh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Jean");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Coat");
								node_3.add(new DefaultMutableTreeNode("dfh"));
							node_2.add(node_3);
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Shoes&Bags");
						node_2 = new DefaultMutableTreeNode("Female");
							node_3 = new DefaultMutableTreeNode("Sport");
								node_3.add(new DefaultMutableTreeNode("dfsg"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Classic");
								node_3.add(new DefaultMutableTreeNode("sdg"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Male");
							node_3 = new DefaultMutableTreeNode("Sport");
								node_3.add(new DefaultMutableTreeNode("dfsg"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Classic");
								node_3.add(new DefaultMutableTreeNode("sdg"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Kids");
							node_3 = new DefaultMutableTreeNode("Sport");
								node_3.add(new DefaultMutableTreeNode("dfsg"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Classic");
								node_3.add(new DefaultMutableTreeNode("sdg"));
							node_2.add(node_3);
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Watch&Accesoies");
						node_2 = new DefaultMutableTreeNode("Female");
							node_3 = new DefaultMutableTreeNode("Sunglasses");
								node_3.add(new DefaultMutableTreeNode("dfkg"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Male");
							node_3 = new DefaultMutableTreeNode("Sunglasses");
								node_3.add(new DefaultMutableTreeNode("dfkg"));
							node_2.add(node_3);
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Home&Life");
						node_2 = new DefaultMutableTreeNode("Furniture");
							node_2.add(new DefaultMutableTreeNode("fdsg"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Lighting");
							node_2.add(new DefaultMutableTreeNode("dfh"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosmetic");
						node_2 = new DefaultMutableTreeNode("Make-up");
							node_2.add(new DefaultMutableTreeNode("dfh"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Perfume&Deodorant");
							node_2.add(new DefaultMutableTreeNode("fds\t\t"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		add(tree);
		
	
	}

}
