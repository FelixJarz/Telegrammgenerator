package package_GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import package_background.GenerateXmlFile;
import package_background.ProjectSelector;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WindowMain_2_ChooseRecordtype {

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
		shell.setSize(450, 229);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(3, false));
		
		// Label for choosing Recordtype
		Label labelChooseOdertype = new Label(shell, SWT.NONE);
		labelChooseOdertype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelChooseOdertype.setText("Choose Recordtype");
					
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
		
		// Create labels to display the previous Ordertypes
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelPreviousOrdertypes = new Label(shell, SWT.NONE);
		labelPreviousOrdertypes.setText("Previous Ordertypes:");
		
		Label labelOrdertype1 = new Label(shell, SWT.NONE);
		labelOrdertype1.setText(newOrdertypes[0]);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelOrdertype2 = new Label(shell, SWT.NONE);
		labelOrdertype2.setText(newOrdertypes[1]);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelOrdertype3 = new Label(shell, SWT.NONE);
		labelOrdertype3.setText(newOrdertypes[2]);
		
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
		buttonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		
		// Button to proceed to the next window
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonNext.setEnabled(false);
		
		// Enable the Next button when an Recordtype is selected from the Combo
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonNext.setEnabled(true);
			}
		});
		
		// Add a SelectionListener to the Next button to perform actions and open the next window
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Get the selected Recordtype from the Combo
				String selectedText = combo.getText();
				String selectedOrdertype = selectedText;
			
				// Generate an XML file with selected parameters
				String headerSource = "HOST";
				String headerDestination = "WAMAS";
				int headerSequence = 0;
				String headerOrdertype = selectedOrdertype;
				String filePath = "C:\\Users\\jhaase\\git\\Telegrammgenerator_Material\\XMLOutput_Test\\Test.xml";
				String selectedMasterrecordType = null;
				GenerateXmlFile generator = new GenerateXmlFile(selectedMasterrecordType, selectedOrdertype, headerSource,
						headerDestination, filePath, headerSequence, headerOrdertype, filePath);
				generator.generateXmlFile();
				
				// Close the current window and open the next window (WindowMain_3_FillHeader)
				display.close();
				WindowMain_3_FillHeader window3 = new WindowMain_3_FillHeader();
				window3.open();
			}
		});
		buttonNext.setText("Next");
	}
}
