package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import package_background.ProjectSelector;


public class WindowMain_5_SelectSubrecord_SWT_Simple {

	protected Shell shell;
	Display display = Display.getDefault();
	private Text text;
	int len = 0;
	//save via sessionData and not temp like this
	ArrayList<String> selectedSubrecords = new ArrayList<String>(); 


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_5_SelectSubrecord_SWT_Simple window = new WindowMain_5_SelectSubrecord_SWT_Simple();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnReturn = new Button(shell, SWT.NONE);
		btnReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WindowMain_4_FillMasterrecord window4 = new WindowMain_4_FillMasterrecord();
				window4.open();
			}
		});
		btnReturn.setText("Return");
		btnReturn.setBounds(10, 220, 75, 25);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(49, 49, 174, 23);
		combo.setItems(ProjectSelector.getRecordTypeList());
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(229, 49, 76, 21);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; i < Integer.parseInt(text.getText()); i++) {
					selectedSubrecords.add(i+len, combo.getText());
				}
				len = Integer.parseInt(text.getText()) + len; 
				//clear Text Field 
			}
		});
		btnAdd.setBounds(315, 47, 75, 25);
		btnAdd.setText("Add");
		
		Button btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(selectedSubrecords);
				display.close();
				WindowMain_6_FillSubrecords window6 = new WindowMain_6_FillSubrecords();
				window6.open();
			}
		});
		btnNext.setText("Next");
		btnNext.setBounds(347, 220, 75, 25);

	}
}
