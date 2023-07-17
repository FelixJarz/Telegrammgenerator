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


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_2_ChooseOrdertype window = new WindowMain_2_ChooseOrdertype();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 229);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(3, false));
		
		Label LabelChooseOdertype = new Label(shell, SWT.NONE);
		LabelChooseOdertype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelChooseOdertype.setText("Choose Ordertype");
				
		//Start class ProjectSelector to sort all the ordertypes
		ProjectSelector select = new ProjectSelector();
		select.getFinishedProjectList();
		
		String[] listOfOdertypes = ProjectSelector.getString();
		
		//fill the dropdown menu with the ordertypes
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(listOfOdertypes);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
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
		new Label(shell, SWT.NONE);
		
		Button ButtonNext = new Button(shell, SWT.NONE);
		ButtonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		

		ButtonNext.addSelectionListener(new SelectionAdapter() {
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
		ButtonNext.setText("Next");
		ButtonNext.setEnabled(false);
		
		Button ButtonReturn = new Button(shell, SWT.NONE);
		ButtonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
			}
		});
		ButtonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		
		Button ButtonConfirm = new Button(shell, SWT.NONE);
		ButtonConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo.getText().isEmpty()) {
					ButtonNext.setEnabled(false);
				}else {
					ButtonNext.setEnabled(true);
				}
			}
		});
		ButtonConfirm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonConfirm.setText("Confirm");

	}
}
