package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;

public class WindowMain2_OrderType {

	protected Shell shell;
	Display display = Display.getDefault();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain2_OrderType window = new WindowMain2_OrderType();
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
		shell.setSize(499, 346);
		shell.setText("Application Window 2");
		shell.setLayout(new GridLayout(3, false));
		
		Label ButtonOrderType = new Label(shell, SWT.NONE);
		ButtonOrderType.setAlignment(SWT.CENTER);
		ButtonOrderType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		ButtonOrderType.setText("Choose Odertype:");
		
		Combo Combo2 = new Combo(shell, SWT.NONE);
		Combo2.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		Combo2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		Combo2.setText("...");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblPreviousOrdertypes = new Label(shell, SWT.NONE);
		lblPreviousOrdertypes.setText("Previous ordertypes:");
		
		Label Label1 = new Label(shell, SWT.NONE);
		Label1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		Label1.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label2 = new Label(shell, SWT.NONE);
		Label2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		Label2.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label3 = new Label(shell, SWT.NONE);
		Label3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		Label3.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label4 = new Label(shell, SWT.NONE);
		Label4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		Label4.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label5 = new Label(shell, SWT.NONE);
		Label5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		Label5.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonReturn1 = new Button(shell, SWT.PUSH);
		ButtonReturn1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonReturn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain1_Project window1 = new WindowMain1_Project();
				window1.open();
			}
		});
		ButtonReturn1.setText("Return");
		new Label(shell, SWT.NONE);
		
		Button ButtonNext2 = new Button(shell, SWT.NONE);
		ButtonNext2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				window1 window1 = new window1();
				window1.open();
			}
		});
		ButtonNext2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		ButtonNext2.setText("Next");
				
		
		}
}
