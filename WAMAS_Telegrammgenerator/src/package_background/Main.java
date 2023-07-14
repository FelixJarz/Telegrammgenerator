package package_background;

import package_GUI.WindowMain_1_ProjectSelect;
import package_GUI.WindowExtra_ProjectCreate;
import package_GUI.WindowMain_5_SelectDirectory;
import package_GUI.WindowMain_3_FillHeader;
import package_GUI.WindowMain_4_FillBody;

public class Main {
	
	public static void main(String[] args) {
		
		ProjectSelector select = new ProjectSelector();
		select.getFinishedProjectList();
		
		try {
			WindowMain_1_ProjectSelect window = new WindowMain_1_ProjectSelect();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
