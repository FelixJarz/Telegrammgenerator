package package_GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import package_background.ProjectSelector;
import package_background.SessionData_Singleton;

public class WindowMain_2_ChooseMasterrecordtype {

	protected Shell shell;
	Display display = Display.getDefault();
	protected Combo combo;
	protected int prevOrdertypeSize = 3;
	
	public void open() {
		// Open the window
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
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		// Create the window and its components
		shell = new Shell();
		shell.setText("Choose Masterrecordtype");
		shell.setSize(450, 148);
		shell.setLocation(500, 300);
		shell.setLayout(new GridLayout(2, false));
		
		// Label for choosing Recordtype
		Label labelChooseOdertype = new Label(shell, SWT.NONE);
		labelChooseOdertype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelChooseOdertype.setText("Choose Masterrecord");
					
		// Create a dropdown menu (Combo) and fill it with the Ordertypes
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(ProjectSelector.getRecordTypeList());
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Create arrays to store previous and new Ordertypes
		String[] prevOrdertypes = new String[prevOrdertypeSize];
		String[] newOrdertypes = new String[10];
		for(int i = 0; i < 10 - 1; i++) {
			newOrdertypes[i] = "Recordtype" + (i+1);
		}
		
		// Add a SelectionListener to the Combo to update the previous Ordertypes array
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; i < prevOrdertypeSize - 1; i++) {
					if(i == prevOrdertypeSize - 1) {
						prevOrdertypes[i] = newOrdertypes[i];
					} else {
						newOrdertypes[i+1] = prevOrdertypes[i];
					}
				}
				newOrdertypes[0] = combo.getText();
				for(int i = 0; i < prevOrdertypeSize - 1; i++) {
					prevOrdertypes[i] = newOrdertypes[i];
				}
			}
		});
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
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
			}
		});
		buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		buttonReturn.setText("Return");
		
		// Button to proceed to the next window
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setEnabled(false);
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1));
		
		// Add a SelectionListener to the Next button to perform actions and open the next window
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Get the selected Recordtype from the Combo
				String selectedOrdertype = combo.getText();
				
				SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
				sessionData.setSelectedRecordtype(selectedOrdertype);
				// Generate an XML file with selected parameters
				//String headerSource = "HOST";
				//String headerDestination = "WAMAS";
				//int headerSequence = 0;
				//String headerOrdertype = selectedOrdertype;
				//String filePath = "C:\\Users\\jhaase\\git\\Telegrammgenerator_Material\\XMLOutput_Test\\Test.xml";
				//String selectedMasterrecordType = null;
				//String selectedSubrecordType = null;
				//GenerateXmlFile generator = new GenerateXmlFile(selectedMasterrecordType, headerSource,
				//		headerDestination, filePath, headerSequence, headerOrdertype, filePath, selectedSubrecordType);
				//generator.generateXmlFile();
				
				// Close the current window and open the next window (WindowMain_3_FillHeader)
				display.close();
				WindowMain_3_FillHeader window3 = new WindowMain_3_FillHeader();
				window3.open();
			}
		});
		buttonNext.setText("Next");
		
		// Enable the Next button when an Recordtype is selected from the Combo
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonNext.setEnabled(true);
			}
		});
	}
}
