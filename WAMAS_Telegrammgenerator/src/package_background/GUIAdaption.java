package package_background;

public class GUIAdaption {
	SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
	
	public GUIAdaption() {
		
	}
	
	public org.eclipse.swt.widgets.Label setVisibilityLabel(org.eclipse.swt.widgets.Label lbl, int definingNum) {
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
	}
}
