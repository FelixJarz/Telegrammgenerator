package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class WindowMain_5_FillSubheader {
	
	Display display = Display.getDefault();
	protected Shell shell;

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
		shell.setSize(454, 325);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(6, false));

		// Combo boxes for selecting subheaders
		Combo combo = new Combo(shell, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1);
		gd_combo.widthHint = 86;
		combo.setLayoutData(gd_combo);

		// Add more Combo boxes for additional subheaders if needed
		Combo combo1 = new Combo(shell, SWT.NONE);
		combo1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));

		Combo combo2 = new Combo(shell, SWT.NONE);
		combo2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));

		Combo combo3 = new Combo(shell, SWT.NONE);
		combo3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));

		Combo combo4 = new Combo(shell, SWT.NONE);
		combo4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		
				// Buttons to navigate between windows
				Button buttonReturn = new Button(shell, SWT.NONE);
				buttonReturn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
				buttonReturn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Close the current window and open the previous window (WindowMain_4_FillBody)
						display.close();
						WindowMain_4_FillBody windowMain_3_FillBody = new WindowMain_4_FillBody();
						windowMain_3_FillBody.open();
					}
				});
				buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
				// Add a separator (e.g., Label or separator) if needed between the buttons
		
				Button buttonNext = new Button(shell, SWT.NONE);
				buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				buttonNext.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Close the current window (WindowMain_5_FillSubheader) to proceed to the next step
						display.close();
					}
				});
				buttonNext.setText("Next");
	}
}
