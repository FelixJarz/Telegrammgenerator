package package_GUI;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
		shell.setText("Fill Masterrecordtype - " + sessionData.getSelectedRecordtype());
		shell.setSize(708, 287);

		shell.setLocation(500, 300);
		shell.setLayout(new GridLayout(7, false));
		FileContentReader fileContentReader = new FileContentReader();
		GUIAdaption guiAdaption = new GUIAdaption(); 
		fileContentReader.ReadContent();
		//fileContentReader.ReadXSDContent(); 
		
		ArrayList <String> masterrecordNameList = sessionData.getMasterrecordDescriptions();		
		
		
		for(int i = 0; i < (sessionData.getTotalEntries()-1); i++) {
			if(i%2 == 1) {
				GUIAdaption.createLabelWithFunction("masterrecord", i, shell, SWT.CENTER, masterrecordNameList.get(i));
				GUIAdaption.createTextField(shell, SWT.BORDER, masterrecordNameList.get(i));
				
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
			}else {
				GUIAdaption.createLabelWithFunction("masterrecord", i, shell, SWT.CENTER, masterrecordNameList.get(i));
				GUIAdaption.createTextField(shell, SWT.BORDER, masterrecordNameList.get(i));
				
				new Label(shell, SWT.NONE);
				}
			}
		
		for(int i = 0; i < (masterrecordNameList.size() - 1); i++) {
			int pos = i;
			GUIAdaption.getHashMap().get("textField" + masterrecordNameList.get(i)).addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
						sessionData.setMasterrecordList(GUIAdaption.getHashMap().get("textField" + masterrecordNameList.get(pos)).getText(), pos);
				}
			});
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
				WindowMain_5_SelectSubrecord_SWT_Simple window5 = new WindowMain_5_SelectSubrecord_SWT_Simple();
				window5.open();
			}
		});
		buttonNext.setText("Next");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
	}
}
