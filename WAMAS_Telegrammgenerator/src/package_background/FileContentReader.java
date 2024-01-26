package package_background;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.xmlet.xsdparser.core.XsdParser;
import org.xmlet.xsdparser.xsdelements.XsdChoice;
import org.xmlet.xsdparser.xsdelements.XsdComplexType;
import org.xmlet.xsdparser.xsdelements.XsdElement;
import org.xmlet.xsdparser.xsdelements.XsdSchema;

public class FileContentReader {
	SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
	private String path = sessionData.getSelectedProjectPath() + sessionData.INCOMING + File.separator + sessionData.getSelectedRecordtype(); 
	private String xsdPath = sessionData.getSelectedProjectPath() + sessionData.XSD + File.separator + "ADVISEDLU00012.xsd"; //-> Eig Subrecord Type
	private String csvPath = path.replace(".xsd", ".csv");
	private String line = ""; 
	private ArrayList<String> descriptions= new ArrayList<String>();	//list for all description names
	private ArrayList<String> shortnames= new ArrayList<String>();		//list for all shortnames shown in the xml file
	private ArrayList<String> mandatoryCells = new ArrayList<String>(); //list for all mandatory cells 


	public FileContentReader() {
		
	}
	
	//not needed anymore 
	private void RenameToXLSX() {
		// Path of folder where files are located 
        String folder_path = 
               sessionData.getSelectedProjectPath() + SessionData_Singleton.INCOMING; 
  
        // creating new folder 
        File myfolder = new File(folder_path); 
  
        File[] file_array = myfolder.listFiles(); 
        for (int i = 0; i < file_array.length; i++) 
        { 
  
            if (file_array[i].isFile()) 
            { 
  
                File myfile = new File(folder_path + 
                         "\\" + file_array[i].getName()); 
                String long_file_name = file_array[i].getName(); 
                String new_file_name = long_file_name.replace(".csv", ".xlsx"); 
                //System.out.println(long_file_name); 
                //System.out.print(new_file_name); 
  
                // file name format: "Snapshot 11 (12-05-2017 11-57).png" 
                // To Shorten it to "11.png", get the substring which 
                // starts after the first space character in the long 
                // _file_name. 
                myfile.renameTo(new File(folder_path + 
                             "\\" + new_file_name)); 
            } 
        } 
	}
	
	public ArrayList<String> ReadXSDContent(){
		
        XsdParser parserInstance1 = new XsdParser(xsdPath);
		
        Stream<XsdElement> elementsStream = parserInstance1.getResultXsdElements();
        Stream<XsdSchema> schemasStream = parserInstance1.getResultXsdSchemas();
                
        XsdElement htmlElement = elementsStream.findFirst().get();
        //1
        XsdComplexType htmlComplexType = htmlElement.getXsdComplexType();
        System.out.println(htmlComplexType);
        //2
        XsdChoice choiceElement = htmlComplexType.getChildAsChoice();
        System.out.println(choiceElement);
        //3
        XsdElement elements = choiceElement.getChildrenElements().findFirst().get();
        ArrayList<String> elementsList = new ArrayList<String>();
        elementsList.add(elements.toString());
        
        System.out.println(elementsList);
        
        return elementsList; 
	}
	
	public List<ArrayList> ReadContent() {
		
		//
		//Read CSV File via Reader
		//
		//if file not found -> try/catch
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvPath));
			while((line = br.readLine()) != null) {
				String[] values = line.split(";"); 
				System.out.println("Description: " + values[1] + " | " + "Shortname: " + values[4] + " | " + "Mandatory: " + values[8]);
				if(values[1].equals("Description") == false) {
					descriptions.add(values[1]);
					shortnames.add(values[4]);
					if(values[8].equals("X")) {
						mandatoryCells.add(values[1]);
					}else {
						mandatoryCells.add("");
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(mandatoryCells);
		
		List<ArrayList> returnList = new ArrayList<ArrayList>(); 
		sessionData.setMasterrecordDescriptions(descriptions);
		sessionData.setMasterrecordShortnames(shortnames);
		sessionData.setMasterrecordMandatory(mandatoryCells);
		sessionData.setTotalEntries(descriptions.size());
		return returnList; 
		
		
		
		
		
		
		
		
		
//
//Read xsd File via Apache POI 
//

		/*
		if(sessionData.getSelectedRecordtype().contains(".xsd")) {
			RenameToXLSX();
		}
		//String ext = ".xsd";
		//String filePath = sessionData.getSelectedRecordtype();
		//String fileName = filePath.replace(".csv", "");
		//File file = new File(filePath);
		//file.renameTo(new File(fileName + ext));
		
		String fileName = sessionData.getSelectedRecordtype();
		String newFileName = fileName.replace(".xsd", ".xlsx"); 
		
		
		File selFile = new File(sessionData.getSelectedProjectPath() + SessionData_Singleton.INCOMING + File.separator + newFileName);
		//open file via stream
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(selFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//get the workbook from the file 
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get the sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//with iterator instead of for
		Iterator<?> iterator = sheet.iterator(); //cycles through rows
		int cellCount; 
		int rowCount = -1;
		ArrayList<String> descriptions= new ArrayList<String>();	//list for all description names
		ArrayList<String> shortnames= new ArrayList<String>();		//list for all shortnames shown in the xml file
		ArrayList<String> mandatoryCells = new ArrayList<String>(); //list for all mandatory cells 
		while (iterator.hasNext()) {
			rowCount++; 
			XSSFRow row = (XSSFRow) iterator.next(); //reads the values of the entire row
			Iterator<?> cellIterator = row.cellIterator(); //will capture all cells in this row
			cellCount = -1; 
			while(cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();	//reads the value of the cell in the row from above
				cellCount++; 
				switch(rowCount) {
				case 0: break;
				default:
					switch(cellCount) {
					case 1:
						switch(cell.getCellType()) {
						case STRING: descriptions.add(cell.getStringCellValue()); break;
						case NUMERIC: System.out.println("Descriprion is a numeric value"); break;
						case BOOLEAN: System.out.println("Description is a boolean value"); break;
						default: System.out.println("Description has no value"); break; 
						}
					case 4:  
						switch(cell.getCellType()) {
						case STRING: shortnames.add(cell.getStringCellValue()); break;
						case NUMERIC: System.out.println("Shortname is a numeric value"); break;
						case BOOLEAN: System.out.println("Shortname is a boolean value"); break;
						default: System.out.println("Shortname has no value"); break; 
						}
					case 8:
						if(cell.equals("X")) {
							mandatoryCells.add(descriptions.get(rowCount)); 
						}
					}
				}
			}
		}
		List<ArrayList> returnList = new ArrayList<ArrayList>(); 
		returnList.add(descriptions);
		returnList.add(shortnames);
		returnList.add(mandatoryCells);
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnList;
		*/
	}
}
