package package_background;

import java.io.File;
import java.util.ArrayList;

public class ProjectSelector {
	
//-----------------------------------------------read xsd folder-------------------------------------------------------------------
	private static ArrayList<String> tempList = new ArrayList<String>();
	
	File folderXSD = new File("C:\\wamas\\workspace\\Telegrammgenerator Material\\interfaceExport\\xsd");
    String[] strXSD = folderXSD.list();

    

//-----------------------------------------------read Incoming folder-------------------------------------------------------------------
    File folderIncoming = new File("C:\\wamas\\workspace\\Telegrammgenerator Material\\interfaceExport\\Incoming");
	String[] strIncoming = folderIncoming.list(); 
	
//-----------------------------------------------Function for sorting all the Header-------------------------------------------------------------------
	public void getFinishedProjectList() {
		
				if(strXSD.equals(strIncoming)) {	//In case the folders match -> Saves the entire compare-process
					System.out.println(strIncoming);
					//Convert to array list for setString-function
					ArrayList<String> arrMatch = new ArrayList<String>(); 
		        	for(int i = 0; i <= strIncoming.length - 1; i++) {
			        	arrMatch.add(strIncoming[i]); //Transmitting the array list with extensions 
		 			} 
					setString(arrMatch);
				}else if(strIncoming.equals("")) {	//If the "Incoming"-folder is empty 
					System.out.println("The Incoming-folder is empty."); 
				}else{ 								//Compares the two folders and finds matching elements
					//Remove the extensions
					String[] strXSDRemoved = folderXSD.list();
		        	for (int i = 0; i <= strXSD.length - 1; i++) {
		        		strXSDRemoved[i] = strXSD[i].substring(0,strXSD[i].lastIndexOf("."));
		        	}
		        	String[] strIncomingRemoved = folderIncoming.list();
		        	for (int i = 0; i <= strIncoming.length - 1; i++) {
		        		strIncomingRemoved[i] = strIncoming[i].substring(0,strIncoming[i].lastIndexOf("."));
		        	}
		        	
		        	//Convert the string arrays to array lists 
		        	ArrayList<String> arrXSD = new ArrayList<String>(); 
		        	for(int i = 0; i <= strXSDRemoved.length - 1; i++) {
			        	arrXSD.add(strXSDRemoved[i]); 
		 			} 
		        	ArrayList<String> arrIncoming = new ArrayList<String>(); 
		        	for(int i = 0; i <= strIncomingRemoved.length - 1; i++) {
			        	arrIncoming.add(strIncomingRemoved[i]); 
		 			} 
				
					//Save the matching elements in a new array list 
					ArrayList<String> arrMatchedList = new ArrayList<String>(arrIncoming);
					arrMatchedList.retainAll(arrXSD);
					System.out.println("Finished List: " + arrMatchedList);
					setString(arrMatchedList);
				}
		}
	
	//Set an outside-variable to the matching list
	public ArrayList<String> setString(ArrayList<String> alllist) {
		tempList = alllist;
		return tempList;
	}
	
//------------Getter function to get the finished list (converted to string array) from outside this class -----------------------------
	public static String[] getString() {
		
		String[] tempStr = new String[tempList.size()];

		for (int i = 0; i < tempList.size(); i++) {
            tempStr[i] = tempList.get(i);
		}
		return tempStr;   
	}
}
