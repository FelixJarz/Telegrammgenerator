package package_background;

import java.io.FileInputStream;

public class FileContentReader {
	public FileContentReader() {
		
	}
	
	public void ReadContent() {
		try {
			Workbook wb = new Workbook("workbook.xlsx");

			// Get all worksheets
			WorksheetCollection collection = wb.getWorksheets();

			// Loop through all the worksheets
			for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

			  // Get worksheet using its index
			  Worksheet worksheet = collection.get(worksheetIndex);

			  // Print worksheet name
			  System.out.print("Worksheet: " + worksheet.getName());

			  // Get number of rows and columns
			  int rows = worksheet.getCells().getMaxDataRow();
			  int cols = worksheet.getCells().getMaxDataColumn();

			  // Loop through rows
			  for (int i = 0; i < rows; i++) {

			    // Loop through each column in selected row
			    for (int j = 0; j < cols; j++) {
			        // Pring cell value
				System.out.print(worksheet.getCells().get(i, j).getValue() + " | ");
			    }
			    // Print line break
			    System.out.println(" ");
			  }
			}
			
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                    // Your code here
		                }
		            }
		        }
		    }
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		}   
	}
}
