package package_background;

import package_GUI.WindowMain_ProjectSelect;
import package_GUI.WindowExtra_ProjectCreate;
import package_GUI.WindowMain_SelectDirectory;
import package_GUI.WindowMain_FillOrdertype;
import package_GUI.WindowMain_FillBody;

public class Main {
	
	public static void main(String[] args) {
		
		Sort sort = new Sort();
		sort.start();
		
		try {
			WindowMain_ProjectSelect window = new WindowMain_ProjectSelect();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
