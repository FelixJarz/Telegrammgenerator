package package_GUI;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import package_background.SessionData_Singleton;
import package_background.FileContentReader;
import package_background.GenerateXmlFile;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class WindowMain_6_FillSubrecords_Simple {

	protected Shell shell;
	static Display display = Display.getDefault();
	SessionData_Singleton sessionData = SessionData_Singleton.getInstance();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowMain_6_FillSubrecords_Simple window = new WindowMain_6_FillSubrecords_Simple();
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Fill Subrecords");
		
		addControlsToTab();
	}
	

		  public static void addControlsToTab() {
			SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
			GenerateXmlFile gen = new GenerateXmlFile(sessionData.getSelectedProjectPath());  
			  
		    final Shell shell = new Shell(display);
		    shell.setSize(319, 236);
		    final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);
		    tabFolder.setBounds(0, 0, 303, 176);
		    
		    Button btnNext = new Button(shell, SWT.NONE);
		    btnNext.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		shell.close();
		    		gen.generateXmlFile();
		    	}
		    });
		    btnNext.setBounds(242, 180, 61, 20);
		    btnNext.setText("Next");
		    
		    Button btnReturn = new Button(shell, SWT.NONE);
		    btnReturn.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		shell.close(); 
		    		WindowMain_5_SelectSubrecord_SWT_Simple window5 = new WindowMain_5_SelectSubrecord_SWT_Simple();
		    		window5.open();
		    	}
		    });
		    btnReturn.setBounds(10, 180, 61, 20);
		    btnReturn.setText("Return");
			FileContentReader fileContentReader = new FileContentReader();
		    for (int i = 0; i < sessionData.getSelectedSubrecords().size(); i++) {
		      TabItem item = new TabItem(tabFolder, SWT.NONE);
		      item.setText(sessionData.getSelectedSubrecords().get(i));
		      Composite com = new Composite(tabFolder, SWT.NONE); 
		      com.setLayout(new GridLayout());
			  String path = sessionData.getSelectedProjectPath() + sessionData.INCOMING + File.separator + sessionData.getSelectedSubrecords().get(i); 
			  fileContentReader.ReadContent(/*get path of current subrecord*/path.replace(".xsd", ".csv"));
		      for(int j = 0; j < /*read length of all tags*/ (sessionData.getTotalEntries()-1); j++) {
			      Label label = new Label(com, SWT.PUSH); 
			      if(sessionData.getMasterrecordMandatory().get(i) == "") {
				      label.setText(/*read text from tag*/sessionData.getMasterrecordDescriptions().get(j) + ":");
			      }else {
				      label.setText(/*read text from tag*/sessionData.getMasterrecordDescriptions().get(j) + "*:");
			      }
			      Text text = new Text(com, SWT.PUSH);
			      text.setEditable(true);
			      //bigger text size 
		      }
		      item.setControl(com);
		    }
		    //tabFolder.pack();
		    shell.pack();
		    shell.open();
		    
		    while (!shell.isDisposed()) {
		      if (!display.readAndDispatch())
		        display.sleep();
		    }
		    display.dispose();
		  
		  }
		
}
