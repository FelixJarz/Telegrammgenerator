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

public class window2 {

	protected Shell shell;
	private Button ButtonNext;
	private Button ButtonReturn;
	private Text Text1;
	private Text Text2;
	private Text Text3;
	private Text Text4;
	private Text Text5;
	private Text Text6;
	private Label Label7;
	private Label Label8;
	private Label Label9;
	private Label Label10;
	private Label Label11;
	private Label Label12;
	private Text Text7;
	private Text Text8;
	private Text Text9;
	private Text Text10;
	private Text Text11;
	private Text Text12;
	private Label LabelFillFull;


	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main(String[] args) {
		try {
			window2 window = new window2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
		shell.setSize(500, 361);
		shell.setText("window 2");
		shell.setLayout(new GridLayout(13, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		LabelFillFull = new Label(shell, SWT.CENTER);
		LabelFillFull.setText("Fill Full");
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
		
		Label Label1 = new Label(shell, SWT.CENTER);
		Label1.setAlignment(SWT.CENTER);
		Label1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label1.setText("a");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text1 = new Text(shell, SWT.BORDER);
		Text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label7 = new Label(shell, SWT.NONE);
		Label7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label7.setText("g");
		new Label(shell, SWT.NONE);
		
		Text7 = new Text(shell, SWT.BORDER);
		Text7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label2 = new Label(shell, SWT.CENTER);
		Label2.setAlignment(SWT.CENTER);
		Label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label2.setText("b");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text2 = new Text(shell, SWT.BORDER);
		Text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label8 = new Label(shell, SWT.NONE);
		Label8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label8.setText("h");
		new Label(shell, SWT.NONE);
		
		Text8 = new Text(shell, SWT.BORDER);
		Text8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label3 = new Label(shell, SWT.NONE);
		Label3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label3.setText("c");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text3 = new Text(shell, SWT.BORDER);
		Text3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label9 = new Label(shell, SWT.NONE);
		Label9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label9.setText("i");
		new Label(shell, SWT.NONE);
		
		Text9 = new Text(shell, SWT.BORDER);
		Text9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label4 = new Label(shell, SWT.NONE);
		Label4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label4.setText("d");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text4 = new Text(shell, SWT.BORDER);
		Text4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label10 = new Label(shell, SWT.NONE);
		Label10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label10.setText("j");
		new Label(shell, SWT.NONE);
		
		Text10 = new Text(shell, SWT.BORDER);
		Text10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label5 = new Label(shell, SWT.NONE);
		Label5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label5.setText("e");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text5 = new Text(shell, SWT.BORDER);
		Text5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label11 = new Label(shell, SWT.NONE);
		Label11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label11.setText("k");
		new Label(shell, SWT.NONE);
		
		Text11 = new Text(shell, SWT.BORDER);
		Text11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label6 = new Label(shell, SWT.NONE);
		Label6.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		Label6.setText("f");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Text6 = new Text(shell, SWT.BORDER);
		Text6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label12 = new Label(shell, SWT.NONE);
		Label12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label12.setText("l");
		new Label(shell, SWT.NONE);
		
		Text12 = new Text(shell, SWT.BORDER);
		Text12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		
		
		ButtonReturn = new Button(shell, SWT.BORDER);
		ButtonReturn.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		ButtonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.close();
				window1 nw = new window1();
				nw.open();
				}
		});
		ButtonReturn.setText("Return");
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
		
		
		ButtonNext = new Button(shell, SWT.BORDER);
		ButtonNext.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		ButtonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.close();
				window3 nw = new window3();
				nw.open();
				
			
			}
			

		});	
		ButtonNext.setText("Next");
	}
}
