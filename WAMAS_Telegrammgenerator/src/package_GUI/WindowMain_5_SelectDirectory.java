package package_GUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class WindowMain_5_SelectDirectory {

	protected Shell shell;
	private Button ButtonReturn;
	private Combo combo;
	private Label LabelFile;
	Display display = Display.getDefault();


	public static void main(String[] args) {
		try {
			WindowMain_5_SelectDirectory window = new WindowMain_5_SelectDirectory();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
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
		shell.setSize(600, 179);
		
		shell.setText("Select Directory");

		shell.setLayout(new GridLayout(2, false));
		String[] a = {"1","2","3"};
		new Label(shell, SWT.NONE);
		
		new Label(shell, SWT.NONE);
		
		LabelFile = new Label(shell, SWT.NONE);
		LabelFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		LabelFile.setText("File:");
		
		combo = new Combo(shell, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 189;
		combo.setLayoutData(gd_combo);
		combo.setItems(a);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
		ButtonReturn = new Button(shell, SWT.BORDER);
		ButtonReturn.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		ButtonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			display.close();
			WindowMain_4_FillBody window3 = new WindowMain_4_FillBody();
			window3.open();
			}
			
		});
		ButtonReturn.setText("Return");
		
		
		Button ButtonNext = new Button(shell, SWT.BORDER);
		ButtonNext.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		
		ButtonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {				
			}
		});
		ButtonNext.setText("Next");
		
	}
}
;