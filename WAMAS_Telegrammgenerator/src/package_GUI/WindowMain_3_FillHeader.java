/*
 * Hardcoded Header Tags -> Maybe change later on
 */

package package_GUI;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
		
		String[] headerNameList = {"Source", "Destination", "Sequence", "Creation Time", "Recordtype Name"};
		
		
		for(int i = 0; i < 5; i++) {
			if(i%2 == 1) {
				GUIAdaption.createLabelWithFunction("header", i, shell, SWT.CENTER, headerNameList[i]);
				GUIAdaption.createTextField(shell, SWT.BORDER, headerNameList[i]);
				
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
			}else {
				GUIAdaption.createLabelWithFunction("header", i, shell, SWT.CENTER, headerNameList[i]);
				GUIAdaption.createTextField(shell, SWT.BORDER, headerNameList[i]);
				
				new Label(shell, SWT.NONE);
				}
			}
		
		GUIAdaption.getHashMap().get("textFieldSource").addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sessionDataSingleton.setHeaderSource(GUIAdaption.getHashMap().get("textFieldSource").getText());
			}
		});
		
		GUIAdaption.getHashMap().get("textFieldDestination").addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sessionDataSingleton.setHeaderDestination(GUIAdaption.getHashMap().get("textFieldDestination").getText());
			}
		});
		
		GUIAdaption.getHashMap().get("textFieldSequence").addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sessionDataSingleton.setHeaderSequence(GUIAdaption.getHashMap().get("textFieldSequence").getText());
			}
		});
		
		GUIAdaption.getHashMap().get("textFieldCreation Time").addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sessionDataSingleton.setHeaderCreationtime(GUIAdaption.getHashMap().get("textFieldCreation Time").getText());
			}
		});
		
		GUIAdaption.getHashMap().get("textFieldRecordtype Name").addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sessionDataSingleton.setHeaderRecordtypename(GUIAdaption.getHashMap().get("textFieldRecordtype Name").getText());
			}
		});
			
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
