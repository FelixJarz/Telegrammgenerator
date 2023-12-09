/*
 * Hardcoded Header Tags -> Maybe change later on
 */

package package_GUI;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import package_background.GUIAdaption;
import package_background.SessionData_Singleton;
import org.eclipse.swt.widgets.Composite;

public class WindowMain_3_FillHeader { 	

	protected Shell shell;
	private Button buttonNext;
	private Button buttonReturn;
	
	Display display = Display.getDefault();
	private Text text;
	private Label lblNewLabel;
	private Text text_1;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Text text_2;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
//-----------------------------------------------GUI Objects-------------------------------------------------------------------
	protected void createContents() {
		// Create the window and its components
		shell = new Shell();
		shell.setSize(733, 317);
		shell.setLocation(500, 300);
		shell.setText("Fill Header");
		shell.setLayout(new GridLayout(7, false));
		new Label(shell, SWT.NONE);

		SessionData_Singleton sessionDataSingleton = SessionData_Singleton.getInstance(); 
		
		/*-----------------------------------------------Test erstellen von labels und textfeldern---------------------------------------------
		GUIAdaption.createLabelWithFunction(shell, SWT.NONE, "TEST");
		GUIAdaption.createTextField(shell, SWT.NONE);
		-----------------------------------------------Test erstellen von labels und textfeldern---------------------------------------------*/
		
		for(int i = 0; i <= 10; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9 ) {
				GUIAdaption.createLabelWithFunction(shell, SWT.CENTER, "TEST: " + i);
				GUIAdaption.createTextField(shell, SWT.BORDER);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
			}else {
				GUIAdaption.createLabelWithFunction(shell, SWT.CENTER, "TEST: " + i);
				GUIAdaption.createTextField(shell, SWT.BORDER);
				new Label(shell, SWT.NONE);
				}
			}
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
		// Button to return to the previous window (WindowMain_2_ChooseOrdertype)
		buttonReturn = new Button(shell, SWT.BORDER);
		buttonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		buttonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// Close the current window and open the previous window (WindowMain_2_ChooseOrdertype)
				display.close();
				WindowMain_2_ChooseMasterrecordtype windowMain_2_ChooseOdtertype = new WindowMain_2_ChooseMasterrecordtype();
				windowMain_2_ChooseOdtertype.open();
			}
		});
		
		buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Button to proceed to the next window (WindowMain_4_FillBody)
		buttonNext = new Button(shell, SWT.BORDER);
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1));
		buttonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// Close the current window and open the next window (WindowMain_4_FillBody)
				display.close();
				WindowMain_4_FillMasterrecord nw = new WindowMain_4_FillMasterrecord();
				nw.open();		
			}
		});	
		buttonNext.setText("Next");
		new Label(shell, SWT.NONE);
	}
}
