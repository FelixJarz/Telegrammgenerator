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

public class WindowExtra_ProjectCreate {

	private Text TextProjectName;
	private Text TextVersionNumber;
	private Text TextIEDir;
	private Text TextSaveDir;
	
	private String filePath;
	private String fileName;
	private String fileVersionNumber;
	private String fileFullName;
	
	private Display display;
	protected Shell shell;
	
	public void open() {
		shell = new Shell();
		display = Display.getDefault();
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
	public void close() {
		shell.close();
	}
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
		
//-----------------------------------------------Buttons with Listener / Labels-------------------------------------------------------------------
		Button ButtonLocationIE = new Button(shell, SWT.NONE);
		ButtonLocationIE.addSelectionListener(new SelectionAdapter() {
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
		ButtonLocationIE.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label LabelSave = new Label(shell, SWT.NONE);
		LabelSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelSave.setText("Save:");
		
		TextSaveDir = new Text(shell, SWT.BORDER);
		TextSaveDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
		
		
		Button ButtonLocationSave = new Button(shell, SWT.NONE);
		ButtonLocationSave.addSelectionListener(new SelectionAdapter() {
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
		ButtonLocationSave.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonReturn = new Button(shell, SWT.NONE);
		ButtonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
	
			}
		});
		ButtonReturn.setText("Return");
		
		Button ButtonNext = new Button(shell, SWT.NONE);
		ButtonNext.setEnabled(false);
		ButtonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				filePath = TextSaveDir.getText();
				fileName = TextProjectName.getText();
				fileVersionNumber = TextVersionNumber.getText();
				fileFullName = fileName + "_" + fileVersionNumber;
				
				WindowMain_1_ProjectSelect project = new WindowMain_1_ProjectSelect();
				shell.close();
				project.open();
				project.CreateFolder(filePath, fileFullName);
				project.getProjectname(fileFullName);

			}
		});
		
		
		ButtonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonNext.setText("Next");
		
		Button ButtonConfirm = new Button(shell, SWT.NONE);
		ButtonConfirm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		ButtonConfirm.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(TextProjectName.getText().isEmpty()) {
					ButtonNext.setEnabled(false);
					TextProjectName.setMessage("All fields must be filled!");
					TextVersionNumber.setMessage("All fields must be filled!");
					TextIEDir.setMessage("All fields must be filled!");
					TextSaveDir.setMessage("All fields must be filled!");
				}else if(TextVersionNumber.getText().isEmpty()){
					ButtonNext.setEnabled(false);
					TextVersionNumber.setMessage("All fields must be filled!");
					TextIEDir.setMessage("All fields must be filled!");
					TextSaveDir.setMessage("All fields must be filled!");
				}else if(TextIEDir.getText().isEmpty()) {
					ButtonNext.setEnabled(false);
					TextIEDir.setMessage("All fields must be filled!");
					TextSaveDir.setMessage("All fields must be filled!");
				}else if(TextSaveDir.getText().isEmpty()) {
					ButtonNext.setEnabled(false);
					TextSaveDir.setMessage("All fields must be filled!");
				}else {		
					ButtonNext.setEnabled(true);
				}
			}
		});
		ButtonConfirm.setText("Confirm");
	}
}
