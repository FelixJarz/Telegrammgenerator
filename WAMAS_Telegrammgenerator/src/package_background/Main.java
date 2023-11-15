package package_background;

import package_GUI.WindowMain_1_ProjectSelect;

public class Main {
	
public static void main(String[] args) {
		try {
			WindowMain_1_ProjectSelect window = new WindowMain_1_ProjectSelect();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}