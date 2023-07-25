package package_background;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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


	public void saveIncomingRecordTypes() throws FileNotFoundException {

		File folderXSD = new File(SessionData_Singleton.TEMP_FOLDER + SessionData_Singleton.XSD);
		List<File> filesXSD = Arrays.asList(folderXSD.listFiles());

		File folderIncoming = new File(SessionData_Singleton.TEMP_FOLDER + SessionData_Singleton.INCOMING);
		List<File> filesIncoming = Arrays.asList(folderIncoming.listFiles());

		File destDirXSD = new File(
				SessionData_Singleton.PROJECT_FOLDER + File.separator + projectName + File.separator + SessionData_Singleton.XSD);

		if (!destDirXSD.exists()) {
			destDirXSD.mkdir();
		}

		for (File fileXSD : filesXSD) {
			for (File fileIncoming : filesIncoming) {
				System.out.println("Comparing file: "
						+ fileXSD.toString().substring(fileXSD.toString().lastIndexOf('\\') + 1,
								fileXSD.toString().indexOf('.'))
						+ " - " + fileIncoming.toString().substring(fileIncoming.toString().lastIndexOf('\\') + 1,
								fileIncoming.toString().indexOf('.')));
				if (fileXSD.toString()
						.substring(fileXSD.toString().lastIndexOf('\\') + 1, fileXSD.toString().indexOf('.'))
						.equals(fileIncoming.toString().substring(fileIncoming.toString().lastIndexOf('\\') + 1,
								fileIncoming.toString().indexOf('.')))) {

					try {
						Path destination = Paths.get(destDirXSD.toString() + File.separator + fileXSD.getName());
						Files.copy(fileXSD.toPath(), destination);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					break;
				}
			}
		}
		
		File destDirIncoming = new File(
				SessionData_Singleton.PROJECT_FOLDER + File.separator + projectName + File.separator + SessionData_Singleton.INCOMING);

		if (!destDirIncoming.exists()) {
			destDirIncoming.mkdir();
		}
		
		for (File fileIncoming : filesIncoming) {
			
			Path destination = Paths.get(destDirIncoming.toString() + File.separator + fileIncoming.getName());
			try {
				Files.copy(fileIncoming.toPath(), destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// Set an outside-variable to the matching list
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

	public void createFolder() {
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
				String entryPath = SessionData_Singleton.TEMP_FOLDER + File.separator + zipEntry.getName();
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

	public void clearTempFolder() {
		Path dir = Paths.get(SessionData_Singleton.TEMP_FOLDER); // path to the directory
		try {
			Files.walk(dir) // Traverse the file tree in depth-first order
					.sorted(Comparator.reverseOrder()).forEach(path -> {
						try {
							Files.delete(path); // delete each file or directory
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] getProjectList() {

		File projectFolder = new File(SessionData_Singleton.PROJECT_FOLDER);

		return projectFolder.list();

	}

	public static String[] getRecordTypeList() {

		SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
		File projectFolderIncoming = new File(sessionData.getSelectedProjectPath() + SessionData_Singleton.XSD);

		return projectFolderIncoming.list();

	}

}
