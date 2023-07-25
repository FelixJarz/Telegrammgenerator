package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import package_background.ProjectSelector;
import package_background.SessionData_Singleton;

public class WindowExtra_ProjectCreate {

	private Text textProjectName;
	private Text textVersionNumber;
	private Text textIEDir;
	
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
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		// Create the window and its components
		shell = new Shell();
		shell.setSize(450, 265);
		shell.setText("Extra Window");
		shell.setLayout(new GridLayout(4, false));
		
		// Label and text field for project name
		Label labelProjectName = new Label(shell, SWT.NONE);
		labelProjectName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelProjectName.setText("Project name:");
		
		textProjectName = new Text(shell, SWT.BORDER);
		textProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Label and text field for version number
		Label labelVersion = new Label(shell, SWT.NONE);
		labelVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelVersion.setText("Version:");
		
		textVersionNumber = new Text(shell, SWT.BORDER);
		textVersionNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Label and text field for Interface Exports directory
		Label labelInterfaceExports = new Label(shell, SWT.NONE);
		labelInterfaceExports.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelInterfaceExports.setText("Interface Exports:");
		
		textIEDir = new Text(shell, SWT.BORDER);
		textIEDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(shell, SWT.NONE);
		
//-----------------------------------------------Buttons with Listener / Labels-------------------------------------------------------------------
		//In case the button is pressed -> File Explorer opens and you can choose a location 
		// Button to choose Interface Exports directory using File Explorer
		Button buttonLocationIE = new Button(shell, SWT.NONE);
		buttonLocationIE.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Open File Explorer and let the user select a directory
				JFileChooser chooser = new JFileChooser();
				String windowTitle = "Explorer";
				chooser.setDialogTitle(windowTitle);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					try {
						File f = chooser.getSelectedFile();
						textIEDir.setText(f.getCanonicalPath());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      }
				else {
				    System.out.println("No Selection ");
				}
			}
		});
		buttonLocationIE.setText("Interface Export folder Directory");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		// Button to return to the previous window
		Button buttonReturn = new Button(shell, SWT.NONE);
		buttonReturn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		//In case the button is pressed -> Go back to the previous window 
		buttonReturn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Close the current window and open the previous window (WindowMain_1_ProjectSelect)
				shell.close();
				WindowMain_1_ProjectSelect windowMain_1_ProjectSelect = new WindowMain_1_ProjectSelect();
				windowMain_1_ProjectSelect.open();
			}
		});
		buttonReturn.setText("Return");
		
		Button buttonNext = new Button(shell, SWT.NONE);
		
		//In case the button is pressed -> Go to the next window 
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Check if all required fields are filled, and if so, proceed to the next window
				if(textProjectName.getText().isEmpty()) {
					textProjectName.setMessage("All fields must be filled!");
					textVersionNumber.setMessage("All fields must be filled!");
					textIEDir.setMessage("All fields must be filled!");
				}else if(textVersionNumber.getText().isEmpty()){
					textVersionNumber.setMessage("All fields must be filled!");
					textIEDir.setMessage("All fields must be filled!");
				}else if(textIEDir.getText().isEmpty()) {
					textIEDir.setMessage("All fields must be filled!");
				}else {		
					ProjectSelector projectSel = new ProjectSelector(textProjectName.getText() + "_" + textVersionNumber.getText());
					
					projectSel.createFolder();
					projectSel.unzipFolder(textIEDir.getText());
					
					SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
					sessionData.setSelectedProject(textProjectName.getText() + "_" + textVersionNumber.getText());
					
					try {
						ProjectSelector.getFinishedProjectList();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 // Das ist die getFinishedProjectList -> xsd alle outgoing raus
					
					WindowMain_1_ProjectSelect project = new WindowMain_1_ProjectSelect();
					shell.close();
					project.open();
				}
			}
				
		});
		buttonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonNext.setText("Next");
	
	}
}


/*
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


*/