package com.automation.commons;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class ExcelData extends BaseClass {
    Workbook workbook;
    String sFilePath;
    Sheet sheet;
    Object[][] cellData;

    public ExcelData() {
        sFilePath = System.getProperty("user.dir") +
                "/src/main/java/com/automation/utilities/ExcelData.xlsx";
        System.out.println("Excel sheet file path is: " + sFilePath);
        try {
            FileInputStream fis = new FileInputStream(new File(sFilePath));
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            System.out.println("Excel file not present");
        }
    }

    @DataProvider(name = "ExcelSheetData")
    public Object[][] getExcelSheetData() {
       sheet = workbook.getSheetAt(0);
       cellData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
       for(int i=0; i<sheet.getLastRowNum(); i++) {
           for (int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
               cellData[i][j] = sheet.getRow(i).getCell(j);
           }
       }
       return cellData;
    }
}
