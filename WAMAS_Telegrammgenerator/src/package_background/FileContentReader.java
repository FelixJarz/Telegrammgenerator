package package_background;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibm.icu.impl.Row;

public class FileContentReader {

	public FileContentReader() {
		
	}
	
	public void ReadContent() {
		
		SessionData_Singleton sessionData = SessionData_Singleton.getInstance();
		File selFile = new File(sessionData.getSelectedProjectPath() + SessionData_Singleton.INCOMING + File.separator + sessionData.getSelectedRecordtype());

		//Try 1 (uses Scanners and uses the csv)
		/*
			Scanner sc;
			try {
				sc = new Scanner(selFile);
				sc.useDelimiter(";");
				while(sc.hasNext()) {
					String s = sc.next();
					int ind = s.indexOf("Decimalplaces (SAP)\r\n");
					if(ind != -1) {
						String contentOfFile = s.substring(ind); 
					}
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			
			//Try 2 (uses Excel Workbook Sheet (extra libs) and uses xcs) 
			try {
	            Workbook wb = WorkbookFactory.create(inputStream);
	            Sheet sheet = (Sheet) wb.getSheetAt(0);
	            org.apache.poi.ss.usermodel.Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0);
	            List<String> columnNames = new ArrayList<>();
	            //get column names  
	            for (java.util.Iterator<Cell> iterator = row.cellIterator();iterator.hasNext();) {
	                Cell cell = iterator.next();
	                String value = cell.getStringCellValue();
	                columnNames.add(value);
	            }
	            //idk
	            Iterator<Row> iterator = sheet.iterator();
	            if (iterator.hasNext()) {
	                iterator.next();
	            }
	            //take all elements which are mandatory 
	            for (java.util.Iterator<Cell> iteratorMandatory = row.cellIterator();iterator.hasNext();) {
	            	if(iteratorMandatory.equals("Mandatory")) {
	            		
	            }
	            
	            List<String> rows = new ArrayList<>();
	            while (iterator.hasNext()) {
	                row = (org.apache.poi.ss.usermodel.Row) iterator.next();
	                Cell code = row.getCell(0);
	                double d = code.getNumericCellValue();
	                int k = Double.valueOf(d).intValue();
	                StringBuilder sb = new StringBuilder();
	                for (int i = 1; i < columnNames.size(); i++) {
	                    sb = new StringBuilder();
	                    sb.append(k);
	                    sb.append(',');
	                    sb.append(columnNames.get(i));
	                    sb.append(',');
	                    Cell cell = row.getCell(i);
	                    sb.append(String.format("%.2f", cell.getNumericCellValue()));
	                    rows.add(sb.toString());
	                }
	            }
	            rows.forEach(System.out::println);
	        }
	        catch (IOException xIo) {
	            xIo.printStackTrace();
	        }
			
			//Try 3
			/*
			ReadCellExample rc=new ReadCellExample();   //object of the class  
			//reading the value of 2nd row and 2nd column  
			String vOutput=rc.ReadCellData(2, 2);   
			System.out.println(vOutput);  
			}  
			//method defined for reading a cell  
			public String ReadCellData(int vRow, int vColumn)  
			{  
			String value=null;          //variable for storing the cell value  
			Workbook wb=null;           //initialize Workbook null  
			try  
			{  
			//reading data from a file in the form of bytes  
			FileInputStream fis=new FileInputStream("C:\\demo\\EmployeeData.xlsx");  
			//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
			wb=new XSSFWorkbook(fis);  
			}  
			catch(FileNotFoundException e)  
			{  
			e.printStackTrace();  
			}  
			catch(IOException e1)  
			{  
			e1.printStackTrace();  
			}  
			Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
			Row row=sheet.getRow(vRow); //returns the logical row  
			Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
			value=cell.getStringCellValue();    //getting cell value  
			return value;               //returns the cell value  
			}  
			*/
			
			//Try 4 (step by step)
			//open file via stream
			FileInputStream inputStream = new FileInputStream(selFile); 
			//get the workbook from the file 
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			//get the sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			//get the cells in the sheet -> find out rows and columns 
			/*
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum(); //-> # of columns in this particular row 
			//save contents of rows and cols
			for(int r = 0; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r); 
				for(int c = 0; c <= cols; c++) {
					XSSFCell cell = row.getCell(c);
					//find out type of data in cell ->String,Int,Boolean,...
					switch(cell.getCellType()) {
					case STRING: System.out.println(cell.getStringCellValue()); break;
					case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
					case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
					}
					System.out.println(", "); //divider
				}
				System.out.println();
			}
			*/
			
			//with iterator instead of for
			Iterator iterator = sheet.iterator(); //cycles through rows
			while (iterator.hasNext()) {
				XSSFRow row = (XSSFRow) iterator.next(); //reads the values of the entire row
				Iterator cellIterator = row.cellIterator(); //will capture all cells in this row
				while(cellIterator.hasNext()) {
					XSSFCell cell = (XSSFCell) cellIterator.next();	//reads the value of the cell in the row from above 
					switch(cell.getCellType()) {
					case STRING: System.out.println(cell.getStringCellValue()); break;
					case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
					case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
					}
					System.out.println(", "); //divider
				}
				System.out.println();
			}
			
			
			
	}
}
