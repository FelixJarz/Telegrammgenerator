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

	private static final Object[] String = null;
	protected Shell shell;
	Display display = Display.getDefault();
	protected Combo combo;
	protected int prevOrdertypeSize = 3;


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
		
		Label lblPreviousOrdertypes = new Label(shell, SWT.NONE);
		lblPreviousOrdertypes.setText("Previous Ordertypes:");
		
		Label lblOrdertype = new Label(shell, SWT.NONE);
		lblOrdertype.setText(newOrdertypes[0]);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblOrdertype_1 = new Label(shell, SWT.NONE);
		lblOrdertype_1.setText(newOrdertypes[1]);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblOrdertype_2 = new Label(shell, SWT.NONE);
		lblOrdertype_2.setText(newOrdertypes[2]);
		
		new Label(shell, SWT.NONE);
		//ButtonNext.setEnabled(false);
		
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
		
		Button ButtonNext = new Button(shell, SWT.NONE);
		ButtonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonNext.setEnabled(false);
		
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ButtonNext.setEnabled(true);
			}
		});
		
		ButtonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			String selectedText = combo.getText();
				
			String selectedOrdertype = selectedText;
			
			String headerSource = "HOST";
			String headerDestination = "WAMAS";
			int headerSequence = 0;
			
			String headerOrdertype = selectedOrdertype;
			String filePath = "C:\\Users\\jhaase\\git\\Telegrammgenerator_Material\\XMLOutput_Test\\Test.xml";

			String selectedMasterrecordType = null;
			GenerateXmlFile generator = new GenerateXmlFile(selectedMasterrecordType, selectedOrdertype, headerSource,
					headerDestination, filePath, headerSequence, headerOrdertype, filePath);
			generator.generateXmlFile();
			
			shell.close();
			WindowMain_3_FillHeader window3 = new WindowMain_3_FillHeader();
			window3.open();
			
			}
		});
		ButtonNext.setText("Next");
	}
}
