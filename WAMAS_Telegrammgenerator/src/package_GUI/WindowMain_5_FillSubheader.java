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
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_5_FillSubheader window = new WindowMain_5_FillSubheader();
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
		shell.setSize(454, 325);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(7, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo = new Combo(shell, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1);
		gd_combo.widthHint = 86;
		combo.setLayoutData(gd_combo);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo_3 = new Combo(shell, SWT.NONE);
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo_4 = new Combo(shell, SWT.NONE);
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
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
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonReturn = new Button(shell, SWT.NONE);
		ButtonReturn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		ButtonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_4_FillBody windowMain_3_FillBody = new WindowMain_4_FillBody();
				windowMain_3_FillBody.open();
			}
		});
		ButtonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonNext = new Button(shell, SWT.NONE);
		ButtonNext.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		ButtonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//WindowMain_5_SelectDirectory windowMain_5_SelectDirectory = new WindowMain_5_SelectDirectory();
				//windowMain_5_SelectDirectory.open();
			}
		});
		ButtonNext.setText("Next");
	}
}
