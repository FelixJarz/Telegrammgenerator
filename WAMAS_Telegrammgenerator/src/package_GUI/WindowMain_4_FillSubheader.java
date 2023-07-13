package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WindowMain_4_FillSubheader {
	
	Display display = Display.getDefault();

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_4_FillSubheader window = new WindowMain_4_FillSubheader();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_5_SelectDirectory windowMain_5_SelectDirectory = new WindowMain_5_SelectDirectory();
				windowMain_5_SelectDirectory.open();
			}
		});
		btnNewButton.setBounds(137, 128, 90, 30);
		btnNewButton.setText("New Button");
		
		Button ButtonNext = new Button(shell, SWT.NONE);
		ButtonNext.setBounds(137, 54, 90, 30);
		ButtonNext.setText("Next");

	}
}
