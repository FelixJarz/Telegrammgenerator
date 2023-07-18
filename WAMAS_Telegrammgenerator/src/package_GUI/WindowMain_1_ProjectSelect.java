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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(495, 226);
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
		buttonNext1.setEnabled(false);
		
		//combo.setItems(ProjectDir);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonNext1.setEnabled(true);
			}
		});
		buttonNext1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				shell.close();
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
	

	public void UnzipFolder(String folderPath, String folderName) {
		String zipFilePath = folderPath + File.separator + folderName + ".zip";
	    File zipFile = new File(zipFilePath);
	    
	    if (!zipFile.exists() || !zipFile.isFile()) {
	        System.out.println("Die angegebene Datei ist keine ZIP-Datei.");
	        return;
	    }
	    
	    byte[] buffer = new byte[1024];
	    try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
	        File outputFolder = new File(folderPath);
	        if (!outputFolder.exists()) {
	            outputFolder.mkdirs();
	        }
	        
	        ZipEntry zipEntry = zipInputStream.getNextEntry();
	        while (zipEntry != null) {
	            String entryPath = folderPath + File.separator + zipEntry.getName();
	            if (!zipEntry.isDirectory()) {
	                File entryFile = new File(entryPath);
	                entryFile.getParentFile().mkdirs();
	                
	                try (FileOutputStream outputStream = new FileOutputStream(entryFile)) {
	                    int length;
	                    while ((length = zipInputStream.read(buffer)) > 0) {
	                        outputStream.write(buffer, 0, length);
	                    }
	                }
	            } else {
	                File dir = new File(entryPath);
	                dir.mkdirs();
	            }
	            
	            zipEntry = zipInputStream.getNextEntry();
	        }
	        
	        System.out.println("Die ZIP-Datei wurde erfolgreich entpackt.");
	    } catch (IOException e) {
	        System.out.println("Fehler beim Entpacken der ZIP-Datei: " + e.getMessage());
	    }
    }
	
}}
	public void getProjectname(String input) {
		projectName = input;
		}
	}
	 


