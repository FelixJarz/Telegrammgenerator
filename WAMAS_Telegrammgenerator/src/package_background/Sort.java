package package_background;

import java.io.File;
import java.util.ArrayList;

public class Sort {
	
	private static ArrayList<String> List = new ArrayList<String>();
	
	//-----------------------------------Folder 1--------------------------------------------
	File folder1 = new File("C:\\Users\\fjarz\\Downloads\\interfaceExport\\xsd");
	String[] strListOfFiles1 = folder1.list();
	
	//-----------------------------------Folder 2--------------------------------------------
	File folder2 = new File("C:\\Users\\fjarz\\Downloads\\interfaceExport\\Incoming");
	String[] strListOfFiles2 = folder2.list(); 
	
	public void start() {
		
				if(strListOfFiles1.equals(strListOfFiles2)) {
					System.out.println(strListOfFiles2);
				}else if(strListOfFiles2.equals("")) {
					System.out.println("List 2 empty"); 
				}else{ 
					String[] new1 = folder1.list();
		        	for (int i = 0; i <= strListOfFiles1.length - 1; i++) {
		        		new1[i] = strListOfFiles1[i].substring(0,strListOfFiles1[i].lastIndexOf("."));
		        	}
		        	ArrayList<String> n1 = new ArrayList<String>(); 
		        	for(int i = 0; i <= new1.length - 1; i++) {
			        	n1.add(new1[i]); 
		 			} 
				
		        
		        	String[] new2 = folder2.list();
		        	for (int i = 0; i <= strListOfFiles2.length - 1; i++) {
		        		new2[i] = strListOfFiles2[i].substring(0,strListOfFiles2[i].lastIndexOf("."));
		        	}
		        	ArrayList<String> n2 = new ArrayList<String>(); 
		        	for(int i = 0; i <= new2.length - 1; i++) {
			        	n2.add(new2[i]); 
		 			} 
				
					//-----------------------------------Compare--------------------------------------------
					ArrayList<String> allList = new ArrayList<String>(n2);
					allList.retainAll(n1);
					System.out.println("Finished List: " + allList);
					setString(allList);
				}
		}
	
	public ArrayList<String> setString(ArrayList<String> alllist) {
		List = alllist;
		return List;
	}
	
	public static ArrayList<String> getString() {
		return List;
	}
}
	
