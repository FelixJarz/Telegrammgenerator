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
	private String projectName;
	private Combo combo;
	Display display = Display.getDefault();

	/**
	 * @wbp.parser.entryPoint
	 */
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

	protected void createContents() {
		
		
		shell = new Shell();
		shell.setSize(495, 353);
		shell.setText("Project");
		shell.setLayout(new GridLayout(3, false));
		
		Label ButtonSelectProject = new Label(shell, SWT.NONE);
		ButtonSelectProject.setAlignment(SWT.CENTER);
		ButtonSelectProject.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		ButtonSelectProject.setText("Select Project:");

		combo = new Combo(shell, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		

		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label LabelPrevious = new Label(shell, SWT.NONE);
		LabelPrevious.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		LabelPrevious.setText("Previous projects:");
		
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
		Label4.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		Label4.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
				
				Label Label5 = new Label(shell, SWT.NONE);
				GridData gd_Label5 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_Label5.heightHint = 20;
				Label5.setLayoutData(gd_Label5);
				Label5.setText("New Label");
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				new Label(shell, SWT.NONE);
				
		
				
				Button ButtonCreateNewProject = new Button(shell, SWT.NONE);
				ButtonCreateNewProject.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
				ButtonCreateNewProject.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
							display.close();
							WindowExtra_ProjectCreate windowextra1 = new WindowExtra_ProjectCreate();
							windowextra1.open();
					}
				});
				ButtonCreateNewProject.setText("Create new project");
				new Label(shell, SWT.NONE);
				Button ButtonNext1 = new Button(shell, SWT.CENTER);
				
						
						ButtonNext1.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
						ButtonNext1.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {

								display.close();
								WindowMain_2_ChooseOrdertype window2 = new WindowMain_2_ChooseOrdertype();
								window2.open();
			}
		});
						ButtonNext1.setText("Next");
	}


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
	 


