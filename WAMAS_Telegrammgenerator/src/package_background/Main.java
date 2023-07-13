package package_background;

import package_GUI.WindowMain_1_ProjectSelect;
import package_GUI.WindowExtra_ProjectCreate;
import package_GUI.WindowMain_5_SelectDirectory;
import package_GUI.WindowMain_2_FillOrdertype;
import package_GUI.WindowMain_3_FillBody;

public class Main {
	
	public static void main(String[] args) {
		
		Sort sort = new Sort();
		sort.start();
		
		try {
			WindowMain_1_ProjectSelect window = new WindowMain_1_ProjectSelect();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
