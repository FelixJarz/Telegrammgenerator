package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import package_background.GUIAdaption;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class WindowMain_5_FillSubrecords {
	
	Display display = Display.getDefault();
	protected Shell shell;

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
	
//-----------------------------------------------GUI Objects-------------------------------------------------------------------
	protected void createContents() {
		shell = new Shell();
		shell.setSize(700, 438);
		shell.setLocation(500, 300);
		shell.setText("Fill Subrecords");
		shell.setLayout(new GridLayout(5, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		List listOfSubheader = new List(shell, SWT.BORDER);
		listOfSubheader.setItems(new String[] {"Subheader_1", "Subheader_2", "Subheader_3", "Subheader_4", "Subheader_5", "Subheader_6", "Subheader_7", "Subheader_8", "Subheader_9", "Subheader_10"});
		GridData gd_listOfSubheader = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 7);
		
		gd_listOfSubheader.widthHint = 126;
		listOfSubheader.setLayoutData(gd_listOfSubheader);
		
		/*for(int i = 0; i <= 10; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9 ) {
				GUIAdaption.createLabelWithFunction(shell, SWT.CENTER, "TEST: " + i);
				GUIAdaption.createTextField(shell, SWT.BORDER);
			}else {
				GUIAdaption.createLabelWithFunction(shell, SWT.CENTER, "TEST: " + i);
				GUIAdaption.createTextField(shell, SWT.BORDER);
				}
			}*/
		
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
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
		Button buttonReturn = new Button(shell, SWT.BORDER);
		buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		buttonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				shell.close();
				WindowMain_4_FillMasterrecord nw = new WindowMain_4_FillMasterrecord();
				nw.open();
				
			}
		});
		buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		
		Button buttonAdd = new Button(shell, SWT.NONE);
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		buttonAdd.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 1, 1));
		buttonAdd.setText("add");
		new Label(shell, SWT.NONE);
		
		Button buttonNext = new Button(shell, SWT.BORDER);
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1));
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
			}
		});
		buttonNext.setText("Next");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
	}
}
