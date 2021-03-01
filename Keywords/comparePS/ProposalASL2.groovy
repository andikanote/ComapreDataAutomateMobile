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


public class ProposalASL2 {

	def ComparePS(String strNo, int excelRow){
		TestData dataCompareAPK2				= findTestData('dt-2/dt_APK') //NARIK DATA DARI EXCEL APK
		TestData dataCompareGen2				= findTestData('dt-2/dt_Generator') // NARIK DATA DARI EXCEL HASIL GENERATOR
		String AkhirTahunKeAPK2					= dataCompareAPK2.getValue('AKHIR TAHUN KE', excelRow)
		String AkhirTahunkeGen2 				= dataCompareGen2.getValue('AKHIR TAHUN KE', excelRow)
		String UsiaAPK2 						= dataCompareAPK2.getValue('USIA', excelRow)
		String UsiaGen2 						= dataCompareGen2.getValue('USIA', excelRow)
		String TotalPremiThnanAPK2				= dataCompareAPK2.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String TotalPremiThnanGen2	     		= dataCompareGen2.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String PremiTopUpTunggalAPK2			= dataCompareAPK2.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String PremiTopUpTunggalGen2			= dataCompareGen2.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String BonusAlokasiInvesAPK2			= dataCompareAPK2.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String BonusAlokasiInvesGen2			= dataCompareGen2.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String LoyaltyBonusAPK2					= dataCompareAPK2.getValue('LOYALTY BONUS', excelRow)
		String LoyaltyBonusGen2					= dataCompareGen2.getValue('LOYALTY BONUS', excelRow)
		String PenarikanSebagianAPK2			= dataCompareAPK2.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PenarikanSebagianGen2			= dataCompareGen2.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PDrendahAPK2			     		= dataCompareAPK2.getValue('PD RENDAH', excelRow)
		String PDrendahGen2						= dataCompareGen2.getValue('PD RENDAH', excelRow)
		String PDsedangAPK2						= dataCompareAPK2.getValue('PD SEDANG', excelRow)
		String PDsedangGen2						= dataCompareGen2.getValue('PD SEDANG', excelRow)
		String PDtinggiAPK2						= dataCompareAPK2.getValue('PD TINGGI', excelRow)
		String PDtinggiGen2						= dataCompareGen2.getValue('PD TINGGI', excelRow)
		String PTUrendahAPK2						= dataCompareAPK2.getValue('PTU RENDAH', excelRow)
		String PTUrendahGen2						= dataCompareGen2.getValue('PTU RENDAH', excelRow)
		String PTUsedangAPK2						= dataCompareAPK2.getValue('PTU SEDANG', excelRow)
		String PTUsedangGen2						= dataCompareGen2.getValue('PTU SEDANG', excelRow)
		String PTUtinggiAPK2						= dataCompareAPK2.getValue('PTU TINGGI', excelRow)
		String PTUtinggiGen2						= dataCompareGen2.getValue('PTU TINGGI', excelRow)
		String PATrendahAPK2					= dataCompareAPK2.getValue('PAT RENDAH', excelRow)
		String PATrendahGen2					= dataCompareGen2.getValue('PAT RENDAH', excelRow)
		String PATsedangAPK2					= dataCompareAPK2.getValue('PAT SEDANG', excelRow)
		String PATsedangGen2					= dataCompareGen2.getValue('PAT SEDANG', excelRow)
		String PATtinggiAPK2					= dataCompareAPK2.getValue('PAT TINGGI', excelRow)
		String PATtinggiGen2					= dataCompareGen2.getValue('PAT TINGGI', excelRow)

		//AkhirTahunKe
		println(AkhirTahunKeAPK2 + ' | ' + AkhirTahunkeGen2)
		if (AkhirTahunKeAPK2 == AkhirTahunkeGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		} else {
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Akhir Tahun Berbeda,   '
		}
		//Usia
		println(UsiaAPK2 + ' | ' + UsiaGen2)
		if (UsiaAPK2 == UsiaGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Usia Berbeda,  '
		}
		//Total Premi Tahunan
		println(TotalPremiThnanAPK2 + ' | ' + TotalPremiThnanGen2)
		if (TotalPremiThnanAPK2 == TotalPremiThnanGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Total Premi Tahunan Berbeda,  '
		}
		//Total Top Up Tunggal
		println(PremiTopUpTunggalAPK2 + ' | ' + PremiTopUpTunggalGen2)
		if (PremiTopUpTunggalAPK2 == PremiTopUpTunggalGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Berbeda,  '
		}
		//Bonus Alokasi Investasi
		println(BonusAlokasiInvesAPK2 + ' | ' + BonusAlokasiInvesGen2)
		if (BonusAlokasiInvesAPK2 == BonusAlokasiInvesGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Premi Topup Berbeda,  '
		}
		//Loyalty Bonus
		println(LoyaltyBonusAPK2 + ' | ' + LoyaltyBonusGen2)
		if (LoyaltyBonusAPK2 == LoyaltyBonusGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Loyalty Berbeda Berbeda,  '
		}
		//Penarikan Sebagian Unit
		println(PenarikanSebagianAPK2 + ' | ' + PenarikanSebagianGen2)
		if (PenarikanSebagianAPK2 == PenarikanSebagianGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Penarikan Sebagian Berbeda,  '
		}
		//PD Rendah, Sedang, Tinggi
		println(PDrendahAPK2 + ' | ' + PDrendahGen2)
		if (PDrendahAPK2 == PDrendahGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Rendah Berbeda,  '
		}
		println(PDsedangAPK2 + ' | ' + PDsedangGen2)
		if (PDsedangAPK2 == PDsedangGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Sedang Berbeda,  '
		}
		println(PDtinggiAPK2 + ' | ' + PDtinggiGen2)
		if (PDtinggiAPK2 == PDtinggiGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Tinggi Berbeda,  '
		}
		//PTU Rendah, Sedang, Tinggi
		println(PTUrendahAPK2 + ' | ' + PTUrendahGen2)
		if (PTUrendahAPK2 == PTUrendahGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Rendah Berbeda,  '
		}
		println(PTUsedangAPK2 + ' | ' + PTUsedangGen2)
		if (PTUsedangAPK2 == PTUsedangGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Sedang Berbeda,  '
		}
		println(PTUtinggiAPK2 + ' | ' + PTUtinggiGen2)
		if (PTUtinggiAPK2 == PTUtinggiGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Tinggi Berbeda,  '
		}
		//PAT Polis Rendah, Sedang, Tinggi
		println(PATrendahAPK2 + ' | ' + PATrendahGen2)
		if (PATrendahAPK2 == PATrendahGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Rendah Berbeda,  '
		}
		println(PATsedangAPK2 + ' | ' + PATsedangGen2)
		if (PATsedangAPK2 == PATsedangGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Sedang Berbeda,  '
		}
		println(PATtinggiAPK2 + ' | ' + PATtinggiGen2)
		if (PATtinggiAPK2 == PATtinggiGen2){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Tinggi Berbeda,  '
		}
		// VALIDASI UNTUK PASSED DAN FAILED
		if(GlobalVariable.strGlbStatus != 'FAILED') {
			GlobalVariable.strGlbStatus = 'PASSED'
		}


	}
}
