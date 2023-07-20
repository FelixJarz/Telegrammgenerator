package package_background;

public class SessionData_Singleton {
	
	static final String ROOT_DIR = "C:\\Telegrammgenerator";
	static final String PROJECT_FOLDER = ROOT_DIR + "\\Projects";
	static final String OUTPUT_FOLDER = ROOT_DIR + "\\Output";
	static private SessionData_Singleton selectedProject = null;
	
	private SessionData_Singleton(){
    }

	public static synchronized SessionData_Singleton getInstance(){

        if (selectedProject == null)
            selectedProject = new SessionData_Singleton();

        return selectedProject;
    }	
	
	public void setSelectedProject() {
		
	}
	
	public void getSelectedproject() {
		
	}
	
}
