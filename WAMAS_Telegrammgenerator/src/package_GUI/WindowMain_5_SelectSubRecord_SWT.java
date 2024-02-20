package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import package_background.SessionData_Singleton;
import package_background.ProjectSelector;
import package_background.GUIAdaption;



public class WindowMain_5_SelectSubRecord_SWT {

	protected Shell shell;
	Display display = Display.getDefault();
	SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_5_SelectSubRecord_SWT window = new WindowMain_5_SelectSubRecord_SWT();
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
		
		List list = new List(shell, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		list.setBounds(21, 10, 107, 200);
		list.setItems(ProjectSelector.getRecordTypeList());
		
		//leave list_1 alone for the time being 
		List list_1 = new List(shell, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		list_1.setBounds(304, 10, 107, 200);
		GUIAdaption.listActionPerformed(list, list_1);
		
		Button btnReturn = new Button(shell, SWT.NONE);
		btnReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WindowMain_4_FillMasterrecord window4 = new WindowMain_4_FillMasterrecord();
				window4.open();
			}
		});
		btnReturn.setBounds(21, 216, 75, 25);
		btnReturn.setText("Return");
		
		Button btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				display.close();
				WindowMain_6_FillSubrecords window6 = new WindowMain_6_FillSubrecords();
				window6.open();
			}
		});
		btnNext.setBounds(336, 216, 75, 25);
		btnNext.setText("Next");
		
		

	}
}
