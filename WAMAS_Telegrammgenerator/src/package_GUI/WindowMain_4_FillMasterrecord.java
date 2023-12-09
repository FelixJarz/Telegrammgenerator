package package_GUI;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import package_background.FileContentReader;
import package_background.SessionData_Singleton;
import package_background.GUIAdaption;

public class WindowMain_4_FillMasterrecord {

	protected Shell shell;
	Display display = Display.getDefault();
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_4_FillMasterrecord window = new WindowMain_4_FillMasterrecord();
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
		// Create the window and its components
		shell = new Shell();
		shell.setText("Fill Masterrecordtype");
		shell.setSize(708, 287);
		shell.setLocation(500, 300);
		shell.setLayout(new GridLayout(7, false));
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
		FileContentReader fileContentReader = new FileContentReader();
		GUIAdaption guiAdaption = new GUIAdaption(); 
		fileContentReader.ReadContent();
		
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
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
		
		ArrayList<String> des= new ArrayList<String>();
		sessionData.setMasterrecordDescriptions(des);
		sessionData.setTotalEntries(des.size());
		
		
		// Create labels to display the previous Ordertypes

		
		//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
				// Button to return to the previous window
				Button buttonReturn = new Button(shell, SWT.NONE);
				buttonReturn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Close the current window and open the previous window (WindowMain_1_ProjectSelect)
						shell.close();
						WindowMain_3_FillHeader window3 = new WindowMain_3_FillHeader();
						window3.open();
					}
				});
				buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
				buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Button to proceed to the next window
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1));
		

		
		// Add a SelectionListener to the Next button to perform actions and open the next window
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_5_FillSubrecords window3 = new WindowMain_5_FillSubrecords();
				window3.open();
			}
		});
		buttonNext.setText("Next");
		new Label(shell, SWT.NONE);
	}
}
