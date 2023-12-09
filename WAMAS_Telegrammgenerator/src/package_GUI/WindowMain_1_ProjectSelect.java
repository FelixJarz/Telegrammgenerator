package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import package_background.ProjectSelector;
import package_background.SessionData_Singleton;

import org.eclipse.swt.widgets.Button;

import java.io.FileNotFoundException;

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
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(495, 226);
		shell.setText("Project");
		shell.setLayout(new GridLayout(3, false));
		shell.setLocation(500, 300);
		
		Label buttonSelectProject = new Label(shell, SWT.NONE);
		buttonSelectProject.setAlignment(SWT.CENTER);
		buttonSelectProject.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		buttonSelectProject.setText("Select Project:");
	
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
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
		
		
//---------------------------------------------------Buttons with Listener--------------------------------------------------------
				
		Button buttonCreateNewProject = new Button(shell, SWT.NONE);
		buttonCreateNewProject.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
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
						
		buttonNext1.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1));
		buttonNext1.setEnabled(false);
		
		combo.setItems(ProjectSelector.getProjectList());
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonNext1.setEnabled(true);
				
				System.out.println("Selected Project: " + combo.getText());
				
				SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
				sessionData.setSelectedProject(combo.getText());
			}
		});
		buttonNext1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				shell.close();
				WindowMain_2_ChooseMasterrecordtype window2 = new WindowMain_2_ChooseMasterrecordtype();
				window2.open();
			}
		});
		buttonNext1.setText("Next");
	}
}


	 

