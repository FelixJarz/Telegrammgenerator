package package_background;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProjectSelector {
	
	String projectName;
	
	public ProjectSelector(String pN) {
		projectName = pN;
	}
	

//-----------------------------------------------read xsd folder-------------------------------------------------------------------
//	
//	
//	static File folderXSD = new File("C:\\Users\\jhaase\\git\\Telegrammgenerator_Material\\interfaceExport\\xsd");
//    String[] strXSD = folderXSD.list();
//
////-----------------------------------------------read Incoming folder-------------------------------------------------------------------
//    File folderIncoming = new File("C:\\Users\\jhaase\\git\\Telegrammgenerator_Material\\interfaceExport\\Incoming");
//	String[] strIncoming = folderIncoming.list(); 
//	
//-----------------------------------------------Function for sorting all the Header-------------------------------------------------------------------
	private static ArrayList<String> tempList = new ArrayList<String>();
	
	public static void getFinishedProjectList() {
		

		
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
		ProjectSelector projectSel = new ProjectSelector("test"); 
		
		File folderXSD = new File(sessionData.getSelectedProjectPath() + File.separator + "xsd");
		String[] strXSD = folderXSD.list();
		
		File folderIncoming = new File(sessionData.getSelectedProjectPath() + File.separator + "Incoming");
		String[] strIncoming = folderIncoming.list();
		
		File[] files = folderXSD.listFiles();
				if(strXSD.equals(strIncoming)) {	
					//In case the folders match -> Saves the entire compare-process
					System.out.println(strIncoming);
					//Convert to array list for setString-function
					ArrayList<String> arrMatch = new ArrayList<String>(); 
		        	for(int i = 0; i <= strIncoming.length - 1; i++) {
			        	arrMatch.add(strIncoming[i]);  
		 			} 
					projectSel.setString(arrMatch);
				}else if(strIncoming.equals("")) {	
					//If the "Incoming"-folder is empty
					System.out.println("The Incoming-folder is empty."); 
				}else{ 								
					//Compares the two folders and finds matching elements
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
					projectSel.setString(arrMatchedList);
					
					java.nio.file.Path srcDir = FileSystems.getDefault().getPath(sessionData.getSelectedProjectPath() + File.separator +"xsd");
					java.nio.file.Path destDir = FileSystems.getDefault().getPath(sessionData.getSelectedProjectPath() + File.separator + "XSD2");
					
					File srcDir2 = new File(sessionData.getSelectedProjectPath() + File.separator + sessionData.getSelectedProject() + File.separator +"xsd");					
					File destDir2 = new File(sessionData.getSelectedProjectPath() + File.separator + sessionData.getSelectedProject() + File.separator + "XSD2");
					
					File[] filesSrcDir = srcDir2.listFiles();
					File[] filesMatching = folderIncoming.listFiles();
					
					for (int i = 0; i <= filesSrcDir.length - 1; i++) {
						for (int i2 = 0; i2 <= arrMatchedList.toArray().length - 1; i2++) {
							File f = new File(sessionData.getSelectedProjectPath() + File.separator + sessionData.getSelectedProject() + File.separator + "XSD2" + arrMatchedList.toArray()[i2]);
							if(filesSrcDir[i].getName() == f.getName()) {
								System.out.println("The 2 files are the same");
								filesMatching[i] = f; 
							}
						}
					}
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
	public void createFolder()
	{
			String folderPathGenerated = SessionData_Singleton.PROJECT_FOLDER + File.separator + projectName;
				File folder = new File(folderPathGenerated);
				
	        if (!folder.exists()) {
	            boolean created = folder.mkdirs();
	            if (created) {
	                System.out.println("Ordner wurde erfolgreich erstellt.");
	            } else {
	                System.out.println("Fehler beim Erstellen des Ordners.");
	            }
	        } else {
	            System.out.println("Der Ordner existiert bereits.");
	        }
	  }
	

	public void unzipFolder(String folderPath) {
	    File zipFile = new File(folderPath);
	    
	    if (!zipFile.exists() || !zipFile.isFile()) {
	        System.out.println("Die angegebene Datei ist keine ZIP-Datei.");
	        return;
	    }
	    
	    byte[] buffer = new byte[1024];
	    try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
	     
	        ZipEntry zipEntry = zipInputStream.getNextEntry();
	        while (zipEntry != null) {
	            String entryPath = SessionData_Singleton.PROJECT_FOLDER + File.separator + projectName + File.separator + zipEntry.getName(); 
	            if (!zipEntry.isDirectory()) {
	                File entryFile = new File(entryPath); 
	                entryFile.getParentFile().mkdirs();
	                
	                try (FileOutputStream outputStream = new FileOutputStream(entryFile)) {
	                    int length;
	                    while ((length = zipInputStream.read(buffer)) > 0) {
	                        outputStream.write(buffer, 0, length);
	                    }
	                }
	            } else {
	                File dir = new File(entryPath);
	                dir.mkdirs();
	            }
	            
	            zipEntry = zipInputStream.getNextEntry();
	        }
	        
	        System.out.println("Die ZIP-Datei wurde erfolgreich entpackt.");
	    } catch (IOException e) {
	        System.out.println("Fehler beim Entpacken der ZIP-Datei: " + e.getMessage());
	    }
	    
	}
	
    public static String[] getProjectList() {
    	
    	File projectFolder = new File(SessionData_Singleton.PROJECT_FOLDER);
        
		return projectFolder.list();
    	
    }
    
    public static String[] getRecordTypeList() {
    	
    	SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
    	File projectFolderIncoming = new File(sessionData.getSelectedProjectPath() + File.separator + "xsd");
        
		return projectFolderIncoming.list();
    	
    }
    
}

