package data_driven_excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1: Get the physical Excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.xlsx");

		// Step 2: Get access to the workbook
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: Get access to the sheet
		Sheet sheet = wb.getSheet("ORGname");

		// Step 4: Get access to the row
		Row row = sheet.getRow(7);

		// Step 5: Get access to the cell
		Cell cell = row.getCell(0);

		// Step 6: Get the data
		String data = cell.getStringCellValue();

		// Print the data
		System.out.println(data);

		// Step 7: Close workbook
		wb.close();

		// Close FileInputStream
		fis.close();
	}
}