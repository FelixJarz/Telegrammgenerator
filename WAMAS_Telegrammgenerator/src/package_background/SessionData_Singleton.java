package package_background;

import java.io.File;

public class SessionData_Singleton {
	
	static final String ROOT_DIR = "C:\\Telegrammgenerator";
	public static final String PROJECT_FOLDER = ROOT_DIR + "\\Projects";
	static final String OUTPUT_FOLDER = ROOT_DIR + "\\Output";
	
	static private SessionData_Singleton instance = null;
	private String selectedProject;
	private String[] finishedProjectList; 
	
	
	
	private SessionData_Singleton(){
    }

	public static synchronized SessionData_Singleton getInstance(){

        if (instance == null) {
        	instance = new SessionData_Singleton();
        }

        return instance;
    }	
	
	public void setSelectedProject(String selProject) {
		selectedProject = selProject;
	}
	
	public String getSelectedProject() {
		return selectedProject;
	}
	
	public String getSelectedProjectPath() {
		return PROJECT_FOLDER + File.separator + selectedProject;
	}
	
	public void setFinishedProjectList(String[] finList) {
		finishedProjectList = finList; 
	}
	
	public String[] getFinishedProjectList() {
		return finishedProjectList;
	}
	
}
