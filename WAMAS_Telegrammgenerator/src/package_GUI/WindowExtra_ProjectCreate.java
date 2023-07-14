package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class WindowExtra_ProjectCreate {

	protected Shell shell;
	Display display = Display.getDefault();
	private Text TextProjectName;
	private Text TextVersionNumber;
	private Text TextIEDir;
	private Text TextSaveDir;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) { 
		try {
			WindowExtra_ProjectCreate window = new WindowExtra_ProjectCreate();
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

	public void close() {
		shell.close();
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 344);
		shell.setText("Extra Window");
		shell.setLayout(new GridLayout(4, false));
		
		Label LabelProjectName = new Label(shell, SWT.NONE);
		LabelProjectName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelProjectName.setText("Project name:");
		
		TextProjectName = new Text(shell, SWT.BORDER);
		TextProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label LabelVersion = new Label(shell, SWT.NONE);
		LabelVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelVersion.setText("Version:");
		
		TextVersionNumber = new Text(shell, SWT.BORDER);
		TextVersionNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label LabelInterfaceExports = new Label(shell, SWT.NONE);
		LabelInterfaceExports.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelInterfaceExports.setText("Interface Exports:");
		
		TextIEDir = new Text(shell, SWT.BORDER);
		TextIEDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
		Button btnChooseLocation_1 = new Button(shell, SWT.NONE);
		btnChooseLocation_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String windowTitle = "Explorer";
				chooser.setDialogTitle(windowTitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					File f = chooser.getSelectedFile();
					String ieDir = f.getAbsolutePath();	
					TextIEDir.setText(ieDir);
				      }
				else {
				    System.out.println("No Selection ");
				}
			}
		});
		btnChooseLocation_1.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblSave = new Label(shell, SWT.NONE);
		lblSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSave.setText("Save:");
		
		TextSaveDir = new Text(shell, SWT.BORDER);
		TextSaveDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
		Button btnChooseLocation = new Button(shell, SWT.NONE);
		btnChooseLocation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String windowTitle = "Explorer";
				chooser.setDialogTitle(windowTitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					File f = chooser.getSelectedFile();
					String saveDir = f.getAbsolutePath();	
					TextSaveDir.setText(saveDir);
				      }
				else {
				    System.out.println("No Selection ");
				}
			}
		});
		btnChooseLocation.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonReturn = new Button(shell, SWT.NONE);
		ButtonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		ButtonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonConfirm = new Button(shell, SWT.NONE);
		ButtonConfirm.setEnabled(false);
		ButtonConfirm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		ButtonConfirm.setText("Confirm");
	}
}
