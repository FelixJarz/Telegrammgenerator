package package_GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class WindowMain_3_FillHeader {

	protected Shell shell;
	private Button buttonNext;
	private Button buttonReturn;
	private Text text1;
	private Text text3;
	private Text text5;
	private Text text7;
	private Text text9;
	private Text text11;
	private Label label2;
	private Label label4;
	private Label label6;
	private Label label8;
	private Label label10;
	private Label label12;
	private Text text2;
	private Text text4;
	private Text text6;
	private Text text8;
	private Text text10;
	private Text text12;
	private Label labelFillFull;
	
	Display display = Display.getDefault();

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
		shell.setSize(500, 361);
		shell.setText("Fill Odertype");
		shell.setLayout(new GridLayout(13, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		labelFillFull = new Label(shell, SWT.CENTER);
		labelFillFull.setText("Fill full");
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
		
		Label label1 = new Label(shell, SWT.CENTER);
		label1.setAlignment(SWT.CENTER);
		label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label1.setText("label1");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text1 = new Text(shell, SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label2 = new Label(shell, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label2.setText("label2");
		new Label(shell, SWT.NONE);
		
		text2 = new Text(shell, SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label3 = new Label(shell, SWT.CENTER);
		label3.setAlignment(SWT.CENTER);
		label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label3.setText("label3");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text3 = new Text(shell, SWT.BORDER);
		text3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label4 = new Label(shell, SWT.NONE);
		label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label4.setText("label4");
		new Label(shell, SWT.NONE);
		
		text4 = new Text(shell, SWT.BORDER);
		text4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label5 = new Label(shell, SWT.NONE);
		label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label5.setText("label5");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text5 = new Text(shell, SWT.BORDER);
		text5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label6 = new Label(shell, SWT.NONE);
		label6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label6.setText("label6");
		new Label(shell, SWT.NONE);
		
		text6 = new Text(shell, SWT.BORDER);
		text6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label7 = new Label(shell, SWT.NONE);
		label7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label7.setText("label7");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text7 = new Text(shell, SWT.BORDER);
		text7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label8 = new Label(shell, SWT.NONE);
		label8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label8.setText("label8");
		new Label(shell, SWT.NONE);
		
		text8 = new Text(shell, SWT.BORDER);
		text8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label9 = new Label(shell, SWT.NONE);
		label9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label9.setText("label9");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text9 = new Text(shell, SWT.BORDER);
		text9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label10 = new Label(shell, SWT.NONE);
		label10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label10.setText("label10");
		new Label(shell, SWT.NONE);
		
		text10 = new Text(shell, SWT.BORDER);
		text10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label label11 = new Label(shell, SWT.NONE);
		label11.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		label11.setText("label11");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		text11 = new Text(shell, SWT.BORDER);
		text11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		label12 = new Label(shell, SWT.NONE);
		label12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label12.setText("label12");
		new Label(shell, SWT.NONE);
		
		text12 = new Text(shell, SWT.BORDER);
		text12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		buttonReturn = new Button(shell, SWT.BORDER);
		buttonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		buttonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				display.close();
				WindowMain_2_ChooseOrdertype  windowMain_2_ChooseOdtertype = new WindowMain_2_ChooseOrdertype();
				windowMain_2_ChooseOdtertype.open();
				}
		});
		
		buttonReturn.setText("Return");
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
		
		buttonNext = new Button(shell, SWT.BORDER);
		buttonNext.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		buttonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				display.close();
				WindowMain_4_FillBody nw = new WindowMain_4_FillBody();
				nw.open();		
			}
		});	
		buttonNext.setText("Next");
	}
}
