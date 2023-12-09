package package_background;

import java.io.File;
import java.util.ArrayList;

public class SessionData_Singleton {
    
    static final String ROOT_DIR = "C:\\Telegrammgenerator";
    static final String PROJECT_FOLDER = ROOT_DIR + "\\Projects";
    static final String TEMP_FOLDER = ROOT_DIR + "\\Temp";
    static final String OUTPUT_FOLDER = ROOT_DIR + "\\Output";
    static final String XSD = "\\xsd";
    static final String INCOMING = "\\Incoming";
    static String HEADER_SOURCE = "";
    static String HEADER_DESTINATION = "";
    static String HEADER_SEQUENCE = "";
    static String HEADER_CREATIONTIME = "";
    static String HEADER_RECORDTYPENAME = ""; 
    
    private static SessionData_Singleton instance = null;
    private String selectedProject;
    private String selectedRecordtype; 
    private ArrayList<String> masterrecordDescriptions = new ArrayList<String>();
    private ArrayList<String> masterrecordShortnames = new ArrayList<String>(); 
    private ArrayList<String> masterrecordMandatory = new ArrayList<String>();
    private int totalEntries = 0; 
    
    private SessionData_Singleton(){
        // Private constructor prevents creating instances from outside this class
    }

    public static synchronized SessionData_Singleton getInstance(){
        // Get the Singleton instance of SessionData_Singleton
        if (instance == null) {
            instance = new SessionData_Singleton();
        }
        return instance;
    }  
    
    public void setSelectedProject(String selProject) {
        // Set the name of the selected project
        selectedProject = selProject;
    }
    
    public void setSelectedRecordtype(String recType) {
    	selectedRecordtype = recType; 
    }
    
    public String getSelectedProject() {
        // Get the name of the selected project
        return selectedProject;
    }
    
    public String getSelectedProjectPath() {
        // Get the path of the selected project
        return PROJECT_FOLDER + File.separator + selectedProject;
    }
    
    public String getSelectedRecordtype() {
		return selectedRecordtype;
    }
    
    //GenerateXMLFile.java-Class Data
    
    public void setHeaderSource(String headerSource) {
    	HEADER_SOURCE = headerSource; 
    }
    
    public void setHeaderDestination(String headerDestination) {
    	HEADER_DESTINATION = headerDestination; 
    }
    
    public void setHeaderSequence(String headerSequence) {
    	HEADER_SEQUENCE = headerSequence; 
    }
    
    public void setHeaderCreationtime(String headerCreationtime) {
    	HEADER_CREATIONTIME = headerCreationtime; 
    }
    
    public void setHeaderRecordtypename(String headerRecordtypename) {
    	HEADER_RECORDTYPENAME = headerRecordtypename; 
    }
    
    //FileContentReader.java-Class Data
    
    public void setMasterrecordDescriptions(ArrayList<String> masterrecDes) {
    	masterrecordDescriptions = masterrecDes; 
    }
    
    public void setMasterrecordShortnames(ArrayList<String> masterrecShort) {
    	masterrecordShortnames = masterrecShort; 
    }
    
    public void setMasterrecordMandatory(ArrayList<String> masterrecMan) {
    	masterrecordMandatory = masterrecMan; 
    }
    
    public void setTotalEntries(int entries) {
    	totalEntries = entries;
    }
    
    public ArrayList<String> getMasterrecordDescriptions() {
    	return masterrecordDescriptions; 
    }
    
    public ArrayList<String> getMasterrecordShortnames() {
    	return masterrecordShortnames; 
    }
    
    public ArrayList<String> getMasterrecordMandatory() {
    	return masterrecordMandatory; 
    }
    
    public int getTotalEntries() {
    	return totalEntries; 
    }
    
}
