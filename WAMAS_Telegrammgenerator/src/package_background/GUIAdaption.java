package package_background;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class GUIAdaption {
	
	
	public GUIAdaption() {
		
	}
	
	//-----------------------------------------------Labels und Text setVisible--------------------------------------------------------
	/*public org.eclipse.swt.widgets.Label setVisibilityLabel(org.eclipse.swt.widgets.Label lbl, int definingNum) {
		if(sessionData.getTotalEntries() > definingNum) {
			lbl.setVisible(true);
			lbl.setText("(Mandatory)" + sessionData.getMasterrecordDescriptions().get(1) + ": ");
		}else {
			lbl.setVisible(false);
		}
		return lbl;
	}
	
	public org.eclipse.swt.widgets.Text setVisibilityText(org.eclipse.swt.widgets.Text txt, int definingNum) {
		if(sessionData.getTotalEntries() > definingNum) {
			txt.setVisible(true);
			txt.setText("(Mandatory)" + sessionData.getMasterrecordDescriptions().get(1) + ": ");
		}else {
			txt.setVisible(false);
		}
		return txt;
	}*/
	
    public static org.eclipse.swt.widgets.Label createLabelWithFunction(org.eclipse.swt.widgets.Shell parent, int style, String text) {
    	org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(parent, style);
        label.setText(text);
        label.setAlignment(SWT.CENTER);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        return label;
    }
    
   	 public static org.eclipse.swt.widgets.Text createTextField(org.eclipse.swt.widgets.Shell parent, int style) {
   		SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
   		
   		org.eclipse.swt.widgets.Text text = new org.eclipse.swt.widgets.Text(parent, style);
   		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
   		sessionData.setHeaderSource(text.getText());
        return text;
    }
}

