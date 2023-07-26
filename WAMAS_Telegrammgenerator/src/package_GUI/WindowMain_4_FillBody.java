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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;

public class WindowMain_4_FillBody {
	
	Display display = Display.getDefault();
	protected Shell shell;
	private Text text1;
	private Text text3;
	private Text text5;
	private Text text7;
	private Text text9;
	private Text text11;
	private Text text13;
	private Text text2;
	private Text text4;
	private Text text6;
	private Text text8;
	private Text text10;
	private Text text12;
	private Text text14;

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
		shell.setSize(700, 364);
		shell.setText("Fill Subheader");
		shell.setLayout(new GridLayout(6, false));
		new Label(shell, SWT.NONE);
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
		new Label(shell, SWT.NONE);
		
		Label label1 = new Label(shell, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label1.setText("label1");
		
		text1 = new Text(shell, SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label2 = new Label(shell, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label2.setText("label2");
		
		text2 = new Text(shell, SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label3 = new Label(shell, SWT.NONE);
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label3.setText("label3");
		
		text3 = new Text(shell, SWT.BORDER);
		text3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label4 = new Label(shell, SWT.NONE);
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label4.setText("label4");
		
		text4 = new Text(shell, SWT.BORDER);
		text4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label5 = new Label(shell, SWT.NONE);
		label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label5.setText("label5");
		
		text5 = new Text(shell, SWT.BORDER);
		text5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label6 = new Label(shell, SWT.NONE);
		label6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label6.setText("label6");
		
		text6 = new Text(shell, SWT.BORDER);
		text6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label7 = new Label(shell, SWT.NONE);
		label7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label7.setText("label7");
		
		text7 = new Text(shell, SWT.BORDER);
		text7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label8 = new Label(shell, SWT.NONE);
		label8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label8.setText("label8");
		
		text8 = new Text(shell, SWT.BORDER);
		text8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label9 = new Label(shell, SWT.NONE);
		label9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label9.setText("label9");
		
		text9 = new Text(shell, SWT.BORDER);
		text9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label10 = new Label(shell, SWT.NONE);
		label10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label10.setText("label10");
		
		text10 = new Text(shell, SWT.BORDER);
		text10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label11 = new Label(shell, SWT.NONE);
		label11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label11.setText("label11");
		
		text11 = new Text(shell, SWT.BORDER);
		text11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label12 = new Label(shell, SWT.NONE);
		label12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label12.setText("label12");
		
		text12 = new Text(shell, SWT.BORDER);
		text12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Label label13 = new Label(shell, SWT.NONE);
		label13.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label13.setText("label13");
		
		text13 = new Text(shell, SWT.BORDER);
		text13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label14 = new Label(shell, SWT.NONE);
		label14.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label14.setText("label14");
		
		text14 = new Text(shell, SWT.BORDER);
		text14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		String[] a = {"1","2","3"};
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
//-----------------------------------------------Buttons with Listener-------------------------------------------------------------------
		Button buttonReturn = new Button(shell, SWT.BORDER);
		buttonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				shell.close();
				WindowMain_3_FillHeader nw = new WindowMain_3_FillHeader();
				nw.open();
				
			}
		});
		buttonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button buttonAdd = new Button(shell, SWT.NONE);
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		buttonAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonAdd.setText("add");
		new Label(shell, SWT.NONE);
		
		Button buttonNext = new Button(shell, SWT.BORDER);
		buttonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		buttonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
			}
		});
		buttonNext.setText("Next");
	}
}
