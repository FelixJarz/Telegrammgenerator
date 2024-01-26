package package_background;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class GUIAdaption {
	
	static org.eclipse.swt.widgets.Text textField; 
	static org.eclipse.swt.widgets.Label labelField; 
	static Map<String, org.eclipse.swt.widgets.Text> mapText = new HashMap<>();
	
	
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
	
    public static org.eclipse.swt.widgets.Label createLabelWithFunction(String winName, int pos, org.eclipse.swt.widgets.Shell parent, int style, String text) {
    	org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(parent, style);
    	SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 

    	switch(winName) {
    	case "header":
    		label.setText(text + "*");
    		break;
    	case "masterrecord":
    		if(sessionData.getMasterrecordMandatory().get(pos).equals("")){
            	label.setText(text);
        	}else {
        		label.setText(text + "*");
        	}
    	}
        label.setAlignment(SWT.CENTER);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelField = label; 
        return label;
    }
    
   	 public static void createTextField(org.eclipse.swt.widgets.Shell parent, int style, String name) {   		
   		org.eclipse.swt.widgets.Text text = new org.eclipse.swt.widgets.Text(parent, style);
   		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
   		textField = text; 
   		
        mapText.put("textField" + name, textField);
    }
   	 
   	 public static Map<String, org.eclipse.swt.widgets.Text> getHashMap(){
   		return mapText; 
   	 }
   	 
   	 public static org.eclipse.swt.widgets.Text getTextField(){
   		 return textField; 
   	 }
   	 
   	public static org.eclipse.swt.widgets.Label getLabel(){
  		 return labelField; 
  	 }
}

