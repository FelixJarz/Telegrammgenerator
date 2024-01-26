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

import package_background.SessionData_Singleton;

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
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

import package_background.ProjectSelector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WindowMain_5_SelectSubRecord {

	private JFrame frame;
	private final Button Return = new Button("buttonReturn");
	private final Button Next = new Button("buttonNext");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain_5_SelectSubRecord window = new WindowMain_5_SelectSubRecord();
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
	public WindowMain_5_SelectSubRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
		
		DefaultListModel listModel = new DefaultListModel<String>();
		
		String interessen[] = {ProjectSelector.getRecordTypeList().toString()};
		
		JList list_2 = new JList(interessen);
		frame.getContentPane().add(list_2);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowMain_4_FillMasterrecord window4 = new WindowMain_4_FillMasterrecord();
				window4.open();
			}
		}	);
		frame.getContentPane().add(Return);
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator);
		frame.getContentPane().add(Next);
		
		JList list_1 = new JList();
		frame.getContentPane().add(list_1);
	}
}
