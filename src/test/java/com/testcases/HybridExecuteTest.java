package com.testcases;

import java.io.IOException;
import java.util.Properties;

import com.excelExportAndFileIO.ReadGuru99ExcelFile;
import com.operation.ReadObject;
import com.operation.UIOperation;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HybridExecuteTest {
    WebDriver webdriver = null;
    @Test(dataProvider="hybridData")
    public void testLogin(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception {
        // TODO Auto-generated method stub


        if(testcaseName!=null&&testcaseName.length()!=0){
            webdriver=new FirefoxDriver();
        }
        ReadObject object = new ReadObject();
        Properties allObjects =  object.getObjectRepository();
        UIOperation operation = new UIOperation(webdriver);
        operation.perform(allObjects, keyword, objectName,
                objectType, value);

    }


    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException{
        Object[][] object = null;
        ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\","C:\\Users\\HP\\eclipse-workspace\\src\\test\\java\\Selenium\\Hybrid_Driven_Framework\\src\\TestCase.xlsx" , "Sheet1");
        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
        object = new Object[rowCount][5];
        for (int i = 0; i < rowCount; i++) {
            Row row = guru99Sheet.getRow(i+1);
            for (int j = 0; j < row.getLastCellNum(); j++) {

                object[i][j] = row.getCell(j).toString();
            }

        }
        System.out.println("");
        return object;
    }
}