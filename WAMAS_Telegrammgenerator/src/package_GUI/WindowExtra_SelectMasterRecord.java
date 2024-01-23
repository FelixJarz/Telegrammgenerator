package package_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Scrollbar;
import java.awt.List;
import java.awt.PopupMenu;
import java.awt.Button;
import java.awt.Choice;
import java.awt.TextArea;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class WindowExtra_SelectMasterRecord {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowExtra_SelectMasterRecord window = new WindowExtra_SelectMasterRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowExtra_SelectMasterRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		
		List list = new List();
		//Zum hinzufügen zu der liste für die Masterrecords list.add();
		frame.getContentPane().add(list, BorderLayout.CENTER);
	}
}
