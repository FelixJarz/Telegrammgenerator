package package_GUI;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.File;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import package_background.ProjectSelector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WindowMain_1_ProjectSelect {

	protected Shell shell;
	Display display = Display.getDefault();

	/**
	 * @wbp.parser.entryPoint
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

	protected void createContents() {
		
		
		shell = new Shell();
		shell.setSize(495, 353);
		shell.setText("Project");
		shell.setLayout(new GridLayout(3, false));
		
		Label ButtonSelectProject = new Label(shell, SWT.NONE);
		ButtonSelectProject.setAlignment(SWT.CENTER);
		ButtonSelectProject.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		ButtonSelectProject.setText("Select Project:");

		Combo Combo1 = new Combo(shell, SWT.NONE);
		Combo1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		
		Combo1.setText("...");
		
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
							ButtonCreateNewProject.setEnabled(false);
							WindowExtra_ProjectCreate windowextra1 = new WindowExtra_ProjectCreate();
							windowextra1.open();
							ButtonCreateNewProject.setEnabled(true);
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
	 


