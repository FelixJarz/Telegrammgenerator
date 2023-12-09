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
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;

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
		shell.setLayout(new GridLayout(9, false));
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
		FileContentReader fileContentReader = new FileContentReader();
		GUIAdaption guiAdaption = new GUIAdaption(); 
		fileContentReader.ReadContent();
		
		ArrayList<String> des= new ArrayList<String>();
		sessionData.setMasterrecordDescriptions(des);
		sessionData.setTotalEntries(des.size());
		
		
		// Create labels to display the previous Ordertypes
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
		
		/*Label lblNewLabel = new Label(shell, SWT.NONE);
		guiAdaption.setVisibilityLabel(lblNewLabel, 0); 
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = new Text(shell, SWT.BORDER);
		guiAdaption.setVisibilityText(text, 0); 
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);*/
		
		Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		//label.setText("(Mandatory)" + sessionData.getMasterrecordDescriptions().get(2) + ": ");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("New Label");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("New Label");
		new Label(shell, SWT.NONE);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("New Label");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_5.setText("New Label");
		new Label(shell, SWT.NONE);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("New Label");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("New Label");
		new Label(shell, SWT.NONE);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
		
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
				buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, true, true, 1, 1));
				buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Button to proceed to the next window
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, true, 1, 1));
		

		
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
	}
}
