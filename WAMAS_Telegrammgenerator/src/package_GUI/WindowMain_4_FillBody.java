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
	private Text text;
	private Text Text1;
	private Text Text2;
	private Text Text3;
	private Text Text4;
	private Text Text5;
	private Text Text6;
	private Text Text7;
	private Text Text8;
	private Text Text9;
	private Text Text10;
	private Text Text11;
	private Text Text12;
	private Text Text13;
	private Text Text14;

	/**
	 * Launch the application.
	 * @param args
	 */
	public void main(String[] args) {
		
		try {
			WindowMain_4_FillBody window = new WindowMain_4_FillBody();
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
		shell.setSize(700, 400);
		shell.setText("Fill Body and select Subheader");
		shell.setLayout(new GridLayout(9, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label LabelFillSubheader = new Label(shell, SWT.NONE);
		LabelFillSubheader.setText("Fill Subheader");
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
		
		Label Label1 = new Label(shell, SWT.NONE);
		Label1.setText("a:");
		new Label(shell, SWT.NONE);
		
		Text1 = new Text(shell, SWT.BORDER);
		Text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label8 = new Label(shell, SWT.NONE);
		Label8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label8.setText("h:");
		new Label(shell, SWT.NONE);
		
		Text8 = new Text(shell, SWT.BORDER);
		Text8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		List list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {"Subheader_1", "Subheader_2", "Subheader_3", "Subheader_4", "Subheader_5", "Subheader_6", "Subheader_7", "Subheader_8", "Subheader_9", "Subheader_10"});
		GridData gd_list = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 7);
		
		gd_list.widthHint = 145;
		list.setLayoutData(gd_list);
		
		Label Label2 = new Label(shell, SWT.NONE);
		Label2.setText("b:");
		new Label(shell, SWT.NONE);
		
		Text2 = new Text(shell, SWT.BORDER);
		Text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label9 = new Label(shell, SWT.NONE);
		Label9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label9.setText("i:");
		new Label(shell, SWT.NONE);
		
		Text9 = new Text(shell, SWT.BORDER);
		Text9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Label3 = new Label(shell, SWT.NONE);
		Label3.setText("c:");
		new Label(shell, SWT.NONE);
		
		Text3 = new Text(shell, SWT.BORDER);
		Text3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label10 = new Label(shell, SWT.NONE);
		Label10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label10.setText("j:");
		new Label(shell, SWT.NONE);
		
		Text10 = new Text(shell, SWT.BORDER);
		Text10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Label4 = new Label(shell, SWT.NONE);
		Label4.setText("d:");
		new Label(shell, SWT.NONE);
		
		Text4 = new Text(shell, SWT.BORDER);
		Text4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label11 = new Label(shell, SWT.NONE);
		Label11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label11.setText("k:");
		new Label(shell, SWT.NONE);
		
		Text11 = new Text(shell, SWT.BORDER);
		Text11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Label5 = new Label(shell, SWT.NONE);
		Label5.setText("e:");
		new Label(shell, SWT.NONE);
		
		Text5 = new Text(shell, SWT.BORDER);
		Text5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label12 = new Label(shell, SWT.NONE);
		Label12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label12.setText("l:");
		new Label(shell, SWT.NONE);
		
		Text12 = new Text(shell, SWT.BORDER);
		Text12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Label6 = new Label(shell, SWT.NONE);
		Label6.setText("f:");
		new Label(shell, SWT.NONE);
		
		Text6 = new Text(shell, SWT.BORDER);
		Text6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label13 = new Label(shell, SWT.NONE);
		Label13.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label13.setText("m:");
		new Label(shell, SWT.NONE);
		
		Text13 = new Text(shell, SWT.BORDER);
		Text13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Label7 = new Label(shell, SWT.NONE);
		Label7.setText("g:");
		new Label(shell, SWT.NONE);
		
		Text7 = new Text(shell, SWT.BORDER);
		Text7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label Label14 = new Label(shell, SWT.NONE);
		Label14.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Label14.setText("n:");
		new Label(shell, SWT.NONE);
		
		Text14 = new Text(shell, SWT.BORDER);
		Text14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		String[] a = {"1","2","3"};
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button ButtonReturn = new Button(shell, SWT.BORDER);
		ButtonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				shell.close();
				WindowMain_3_FillHeader nw = new WindowMain_3_FillHeader();
				nw.open();
				
			}
		});
		ButtonReturn.setText("Return");
		new Label(shell, SWT.NONE);
		
		Label lblAnzahl = new Label(shell, SWT.NONE);
		lblAnzahl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAnzahl.setText("Anzahl:");
		
		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label LabelSubheader = new Label(shell, SWT.NONE);
		LabelSubheader.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelSubheader.setText("Subheader:");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.setItems(a);
		
		Button ButtonAdd = new Button(shell, SWT.NONE);
		ButtonAdd.setText("add");
		new Label(shell, SWT.NONE);
		
		Button ButtonNext = new Button(shell, SWT.BORDER);
		ButtonNext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		ButtonNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				WindowMain_5_FillSubheader windowMain_4_FillSubheader = new WindowMain_5_FillSubheader();
				windowMain_4_FillSubheader.open();
				
			}
		});
		ButtonNext.setText("Next");

	}

}
