package comparePS

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.pair_return as pair_return
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang3.time.StopWatch
import java.lang.Integer as Integer
import java.util.concurrent.TimeUnit

//import internal.GlobalVariable

public class KeywordPS {
	//CALL STATUS PASSED OR FAILED
	@Keyword
	def callStatus(String strNo, String namaMenu, int kolomAwal) {
		FileInputStream file = new FileInputStream (new File("C:\\ANDIKA\\PROJECT\\PS\\DT PS\\CompareLegacy\\Temp_ExcelAPK.xlsx"))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(namaMenu)
		int strGetRow = Integer.parseInt(strNo)

		sheet.getRow(strGetRow).createCell(kolomAwal+1).setCellValue(GlobalVariable.strGlbStatus)
		sheet.getRow(strGetRow).createCell(20).setCellValue(GlobalVariable.strGlbKeterangan)


		String ExpectedResult	= sheet.getRow(strGetRow).getCell(kolomAwal).getStringCellValue();
		String ActualResult 	= sheet.getRow(strGetRow).getCell(kolomAwal+1).getStringCellValue();

		if (ExpectedResult == ActualResult) {
			sheet.getRow(strGetRow).createCell(kolomAwal+2).setCellValue('PASSED')
		} else {
			sheet.getRow(strGetRow).createCell(kolomAwal+2).setCellValue('FAILED')
		}

		file.close()

		FileOutputStream outFile =new FileOutputStream(new File("C:\\ANDIKA\\PROJECT\\PS\\DT PS\\CompareLegacy\\Temp_ExcelAPK.xlsx"))
		workbook.write(outFile)
		outFile.close()
	}
}
