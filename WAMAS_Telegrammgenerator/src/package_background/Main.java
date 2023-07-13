package package_background;

import package_GUI.WindowMain1_Project;
import package_GUI.WindowMain2_OrderType;
import package_GUI.WindowExtra1_Project;
import package_GUI.window1;
import package_GUI.window2;
import package_GUI.window3;

public class Main {
	
	public static void main(String[] args) {
		
		Sort sort = new Sort();
		sort.start();
		
		try {
			WindowMain1_Project window = new WindowMain1_Project();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
