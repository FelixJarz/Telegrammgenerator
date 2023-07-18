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


	protected Shell shell;
	private Text textProjectName;
	private Text textVersionNumber;
	private Text textIEDir;
	private Text textSaveDir;
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
		
		Label labelProjectName = new Label(shell, SWT.NONE);
		labelProjectName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelProjectName.setText("Project name:");
		
		textProjectName = new Text(shell, SWT.BORDER);
		textProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelVersion = new Label(shell, SWT.NONE);
		labelVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelVersion.setText("Version:");
		
		textVersionNumber = new Text(shell, SWT.BORDER);
		textVersionNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelInterfaceExports = new Label(shell, SWT.NONE);
		labelInterfaceExports.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelInterfaceExports.setText("Interface Exports:");
		
		textIEDir = new Text(shell, SWT.BORDER);
		textIEDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
//-----------------------------------------------Buttons with Listener / Labels-------------------------------------------------------------------
		//In case the button is pressed -> File Explorer opens and you can choose a location 
		Button buttonLocationIE = new Button(shell, SWT.NONE);
		buttonLocationIE.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String windowTitle = "Explorer";
				chooser.setDialogTitle(windowTitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					File f = chooser.getSelectedFile();
					String ieDir = f.getAbsolutePath();	
					textIEDir.setText(ieDir);
				      }
				else {
				    System.out.println("No Selection ");
				}
			}
		});
		buttonLocationIE.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelSave = new Label(shell, SWT.NONE);
		labelSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSave.setText("Save:");
		
		textSaveDir = new Text(shell, SWT.BORDER);
		textSaveDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
		//In case the button is pressed -> File Explorer opens and you can choose a location 
		Button buttonLocationSave = new Button(shell, SWT.NONE);
		buttonLocationSave.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String windowTitle = "Explorer";
				chooser.setDialogTitle(windowTitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					File f = chooser.getSelectedFile();
					String saveDir = f.getAbsolutePath();	
					textSaveDir.setText(saveDir);
				      }
				else {
				    System.out.println("No Selection ");
				}
			}
		});
		buttonLocationSave.setText("Choose Location");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button buttonReturn = new Button(shell, SWT.NONE);
		buttonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		//In case the button is pressed -> Go back to the previous window 
		buttonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
			}
		});
		buttonReturn.setText("Return");
		
		Button buttonNext = new Button(shell, SWT.NONE);
		buttonNext.setEnabled(false);
		
		//In case the button is pressed -> Go to the next window 
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				filePath = textSaveDir.getText();
				fileName = textProjectName.getText();
				fileVersionNumber = textVersionNumber.getText();
				fileFullName = fileName + "_" + fileVersionNumber;
				
				WindowMain_1_ProjectSelect project = new WindowMain_1_ProjectSelect();
				shell.close();
				project.open();
				project.CreateFolder(filePath, fileFullName);
				project.getProjectname(fileFullName);

			}
		});
		
		buttonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonNext.setText("Next");
	
		//Button to confirm if all necessary fields are filled 
		Button buttonConfirm = new Button(shell, SWT.NONE);
		buttonConfirm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		buttonConfirm.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(textProjectName.getText().isEmpty()) {
					buttonNext.setEnabled(false);
					textProjectName.setMessage("All fields must be filled!");
					textVersionNumber.setMessage("All fields must be filled!");
					textIEDir.setMessage("All fields must be filled!");
					textSaveDir.setMessage("All fields must be filled!");
				}else if(textVersionNumber.getText().isEmpty()){
					buttonNext.setEnabled(false);
					textVersionNumber.setMessage("All fields must be filled!");
					textIEDir.setMessage("All fields must be filled!");
					textSaveDir.setMessage("All fields must be filled!");
				}else if(textIEDir.getText().isEmpty()) {
					buttonNext.setEnabled(false);
					textIEDir.setMessage("All fields must be filled!");
					textSaveDir.setMessage("All fields must be filled!");
				}else if(textSaveDir.getText().isEmpty()) {
					buttonNext.setEnabled(false);
					textSaveDir.setMessage("All fields must be filled!");
				}else {		
					buttonNext.setEnabled(true);
				}
			}
		});
		buttonConfirm.setText("Confirm");
	}
}
