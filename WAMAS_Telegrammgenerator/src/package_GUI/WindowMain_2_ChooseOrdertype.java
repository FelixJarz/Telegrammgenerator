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
import org.eclipse.swt.events.SelectionListener;
import java.util.function.Consumer;

public class WindowMain_2_ChooseOrdertype {

	protected Shell shell;

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
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(4, false));
		
		Label lblChooseOrdertype = new Label(shell, SWT.NONE);
		lblChooseOrdertype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblChooseOrdertype.setText("Choose Ordertype");
		
		String[] str = ProjectSelector.getString(); 

		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(str);
		/*combo.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unused")
			public SelectionListener widgetDefaultSelectedAdapter(Consumer<SelectionEvent> c) {
				String selElement = combo.getText(); 
				System.out.println("Approved");
				return (SelectionListener) null;
			}
		});*/
		
		//SelectionListener listener = new SelectionListener(); 
		//combo.addSelectionListener(listener);
		
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
		
		Label lblPreviousOrdertypes = new Label(shell, SWT.NONE);
		lblPreviousOrdertypes.setText("Previous Ordertypes:");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setText("Back");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
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
		btnNewButton_1.setText("Next");

	}
}
