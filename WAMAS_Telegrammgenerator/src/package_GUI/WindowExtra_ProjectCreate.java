package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.File;
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
		shell = new Shell();
		shell.setSize(450, 265);
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
		
		//In case the button is pressed -> Go to the next window 
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
					ProjectSelector projectSel = new ProjectSelector(textProjectName.getText() + textVersionNumber.getText());
					
					projectSel.createFolder(SessionData_Singleton.PROJECT_FOLDER + File.separator + textProjectName.getText() + textVersionNumber.getText());
					projectSel.unzipFolder(textIEDir.getText());
					//projectSel.removeOutgoingTypes(); // Das ist die getFinishedProjectList -> xsd alle outgoing raus
					
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