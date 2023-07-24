package package_background;

public class SessionData {
	
		static final String ROOT_DIR = "C:\\Program Files\\Telegrammgenerator";
		static final String PROJECT_FOLDER = ROOT_DIR + "\\Projects";
		static final String OUTPUT_FOLDER = ROOT_DIR + "\\Output"; 
	    private static SessionData selectedProject = null;
	  
	    private SessionData()
	    {
	       
	    	
	    	
	    	
	    }
	  
	   
	    public static synchronized SessionData getInstance()
	    {
	        if (selectedProject == null)
	        	selectedProject = new SessionData();
	  
	        return selectedProject;
	    }
	}

