package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class WindowMain_1_ProjectSelect {

	protected Shell shell;
	Display display = Display.getDefault();
	String projectName;

	public void open() {
		shell = new Shell();
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
		shell.setSize(495, 353);
		shell.setText("Project");
		shell.setLayout(new GridLayout(3, false));
		
		Label buttonSelectProject = new Label(shell, SWT.NONE);
		buttonSelectProject.setAlignment(SWT.CENTER);
		buttonSelectProject.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonSelectProject.setText("Select Project:");
	
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label labelPrevious = new Label(shell, SWT.NONE);
		labelPrevious.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		labelPrevious.setText("Previous projects:");
		
		Label label1 = new Label(shell, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label1.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
				
		Label label2 = new Label(shell, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label2.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label3 = new Label(shell, SWT.NONE);
		label3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label3.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label4 = new Label(shell, SWT.NONE);
		label4.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		label4.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
				
		Label label5 = new Label(shell, SWT.NONE);
		GridData gd_label5 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_label5.heightHint = 20;
		label5.setLayoutData(gd_label5);
		label5.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
//---------------------------------------------------Buttons with Listener--------------------------------------------------------
				
		Button buttonCreateNewProject = new Button(shell, SWT.NONE);
		buttonCreateNewProject.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonCreateNewProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					display.close();
					WindowExtra_ProjectCreate windowextra1 = new WindowExtra_ProjectCreate();
					windowextra1.open();
			}
		});
		buttonCreateNewProject.setText("Create new project");
		new Label(shell, SWT.NONE);
		Button buttonNext1 = new Button(shell, SWT.CENTER);
				
						
		buttonNext1.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		buttonNext1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				display.close();
				WindowMain_2_ChooseOrdertype window2 = new WindowMain_2_ChooseOrdertype();
				window2.open();
			}
		});
		buttonNext1.setText("Next");
	}

//----------------------------------------------------Functions------------------------------------------------------------
	public void CreateFolder (String folderPath, String folderName)
	{
			String folderPathGenerated = folderPath + "/" + folderName;
				File folder = new File(folderPathGenerated);
				
	        if (!folder.exists()) {
	            boolean created = folder.mkdirs();
	            if (created) {
	                System.out.println("Ordner wurde erfolgreich erstellt.");
	            } else {
	                System.out.println("Fehler beim Erstellen des Ordners.");
	            }
	        } else {
	            System.out.println("Der Ordner existiert bereits.");
	        }
	    }
	
	public void getProjectname(String input) {
		projectName = input;
		}
	}
	 


