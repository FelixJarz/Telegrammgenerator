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
		
		Combo combo1 = new Combo(shell, SWT.NONE);
		combo1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo2 = new Combo(shell, SWT.NONE);
		combo2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo3 = new Combo(shell, SWT.NONE);
		combo3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Combo combo4 = new Combo(shell, SWT.NONE);
		combo4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
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
		
//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
		Button buttonReturn = new Button(shell, SWT.NONE);
		buttonReturn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
		new Label(shell, SWT.NONE);
		
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
			}
		});
		buttonNext.setText("Next");
	}
}
