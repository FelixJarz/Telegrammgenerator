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

public class WindowMain_2_ChooseOrdertype {

	protected Shell shell;
	Display display = Display.getDefault();
	protected Combo combo;
	protected int prevOrdertypeSize = 3;

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
		shell = new Shell();
		shell.setSize(450, 229);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(3, false));
		
		Label labelChooseOdertype = new Label(shell, SWT.NONE);
		labelChooseOdertype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelChooseOdertype.setText("Choose Ordertype");
				
		//Start class ProjectSelector to sort all the ordertypes
		ProjectSelector select = new ProjectSelector();
		select.getFinishedProjectList();
		
		String[] listOfOdertypes = ProjectSelector.getString();
		
		//fill the dropdown menu with the ordertypes
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(listOfOdertypes);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		//Previous Odertypes will be shown
		String[] prevOrdertypes = new String[prevOrdertypeSize];
		String[] newOrdertypes = new String[10];
		for(int i = 0; i < 10 - 1; i++) {
			newOrdertypes[i] = "Ordertype" + i+1;
		}
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; i < prevOrdertypeSize - 1; i++) {
					if(i == prevOrdertypeSize - 1) {
						prevOrdertypes[i] = newOrdertypes[i];
					}else {
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
		//ButtonNext.setEnabled(false);
		
//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
		Button buttonReturn = new Button(shell, SWT.NONE);
		buttonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
			}
		});
		buttonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonNext.setEnabled(false);
		
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonNext.setEnabled(true);
			}
		});
		
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			String selectedText = combo.getText();
				
			String selectedOrdertype = selectedText;
			
			String headerSource = "HOST";
			String headerDestination = "WAMAS";
			int headerSequence = 0;
			
			String headerOrdertype = selectedOrdertype;
			String filePath = "C:\\wamas\\workspace\\Telegrammgenerator Material\\XML_Test.xml";

			String selectedMasterrecordType = null;
			GenerateXmlFile generator = new GenerateXmlFile(selectedMasterrecordType, selectedOrdertype, headerSource,
					headerDestination, filePath, headerSequence, headerOrdertype, filePath);
			generator.generateXmlFile();
			
			display.close();
			WindowMain_3_FillHeader window3 = new WindowMain_3_FillHeader();
			window3.open();
			
			}
		});
		buttonNext.setText("Next");
	}
}
