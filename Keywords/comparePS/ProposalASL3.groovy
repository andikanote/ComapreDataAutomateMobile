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


public class ProposalASL3 {

	def ComparePS(String strNo, int excelRow){
		TestData dataCompareAPK3				= findTestData('dt-3/dt_APK') //NARIK DATA DARI EXCEL APK
		TestData dataCompareGen3				= findTestData('dt-3/dt_Generator') // NARIK DATA DARI EXCEL HASIL GENERATOR
		String AkhirTahunKeAPK3					= dataCompareAPK3.getValue('AKHIR TAHUN KE', excelRow)
		String AkhirTahunkeGen3 				= dataCompareGen3.getValue('AKHIR TAHUN KE', excelRow)
		String UsiaAPK3 						= dataCompareAPK3.getValue('USIA', excelRow)
		String UsiaGen3 						= dataCompareGen3.getValue('USIA', excelRow)
		String TotalPremiThnanAPK3				= dataCompareAPK3.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String TotalPremiThnanGen3	     		= dataCompareGen3.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String PremiTopUpTunggalAPK3			= dataCompareAPK3.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String PremiTopUpTunggalGen3			= dataCompareGen3.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String BonusAlokasiInvesAPK3			= dataCompareAPK3.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String BonusAlokasiInvesGen3			= dataCompareGen3.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String LoyaltyBonusAPK3					= dataCompareAPK3.getValue('LOYALTY BONUS', excelRow)
		String LoyaltyBonusGen3					= dataCompareGen3.getValue('LOYALTY BONUS', excelRow)
		String PenarikanSebagianAPK3			= dataCompareAPK3.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PenarikanSebagianGen3			= dataCompareGen3.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PDrendahAPK3			     		= dataCompareAPK3.getValue('PD RENDAH', excelRow)
		String PDrendahGen3						= dataCompareGen3.getValue('PD RENDAH', excelRow)
		String PDsedangAPK3						= dataCompareAPK3.getValue('PD SEDANG', excelRow)
		String PDsedangGen3						= dataCompareGen3.getValue('PD SEDANG', excelRow)
		String PDtinggiAPK3						= dataCompareAPK3.getValue('PD TINGGI', excelRow)
		String PDtinggiGen3						= dataCompareGen3.getValue('PD TINGGI', excelRow)
		String PTUrendahAPK3						= dataCompareAPK3.getValue('PTU RENDAH', excelRow)
		String PTUrendahGen3						= dataCompareGen3.getValue('PTU RENDAH', excelRow)
		String PTUsedangAPK3						= dataCompareAPK3.getValue('PTU SEDANG', excelRow)
		String PTUsedangGen3						= dataCompareGen3.getValue('PTU SEDANG', excelRow)
		String PTUtinggiAPK3						= dataCompareAPK3.getValue('PTU TINGGI', excelRow)
		String PTUtinggiGen3						= dataCompareGen3.getValue('PTU TINGGI', excelRow)
		String PATrendahAPK3					= dataCompareAPK3.getValue('PAT RENDAH', excelRow)
		String PATrendahGen3					= dataCompareGen3.getValue('PAT RENDAH', excelRow)
		String PATsedangAPK3					= dataCompareAPK3.getValue('PAT SEDANG', excelRow)
		String PATsedangGen3					= dataCompareGen3.getValue('PAT SEDANG', excelRow)
		String PATtinggiAPK3					= dataCompareAPK3.getValue('PAT TINGGI', excelRow)
		String PATtinggiGen3					= dataCompareGen3.getValue('PAT TINGGI', excelRow)

		//AkhirTahunKe
		println(AkhirTahunKeAPK3 + ' | ' + AkhirTahunkeGen3)
		if (AkhirTahunKeAPK3 == AkhirTahunkeGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		} else {
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Akhir Tahun Berbeda,   '
		}
		//Usia
		println(UsiaAPK3 + ' | ' + UsiaGen3)
		if (UsiaAPK3 == UsiaGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Usia Berbeda,  '
		}
		//Total Premi Tahunan
		println(TotalPremiThnanAPK3 + ' | ' + TotalPremiThnanGen3)
		if (TotalPremiThnanAPK3 == TotalPremiThnanGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Total Premi Tahunan Berbeda,  '
		}
		//Total Top Up Tunggal
		println(PremiTopUpTunggalAPK3 + ' | ' + PremiTopUpTunggalGen3)
		if (PremiTopUpTunggalAPK3 == PremiTopUpTunggalGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Berbeda,  '
		}
		//Bonus Alokasi Investasi
		println(BonusAlokasiInvesAPK3 + ' | ' + BonusAlokasiInvesGen3)
		if (BonusAlokasiInvesAPK3 == BonusAlokasiInvesGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Premi Topup Berbeda,  '
		}
		//Loyalty Bonus
		println(LoyaltyBonusAPK3 + ' | ' + LoyaltyBonusGen3)
		if (LoyaltyBonusAPK3 == LoyaltyBonusGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Loyalty Berbeda Berbeda,  '
		}
		//Penarikan Sebagian Unit
		println(PenarikanSebagianAPK3 + ' | ' + PenarikanSebagianGen3)
		if (PenarikanSebagianAPK3 == PenarikanSebagianGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Penarikan Sebagian Berbeda,  '
		}
		//PD Rendah, Sedang, Tinggi
		println(PDrendahAPK3 + ' | ' + PDrendahGen3)
		if (PDrendahAPK3 == PDrendahGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Rendah Berbeda,  '
		}
		println(PDsedangAPK3 + ' | ' + PDsedangGen3)
		if (PDsedangAPK3 == PDsedangGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Sedang Berbeda,  '
		}
		println(PDtinggiAPK3 + ' | ' + PDtinggiGen3)
		if (PDtinggiAPK3 == PDtinggiGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Tinggi Berbeda,  '
		}
		//PTU Rendah, Sedang, Tinggi
		println(PTUrendahAPK3 + ' | ' + PTUrendahGen3)
		if (PTUrendahAPK3 == PTUrendahGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Rendah Berbeda,  '
		}
		println(PTUsedangAPK3 + ' | ' + PTUsedangGen3)
		if (PTUsedangAPK3 == PTUsedangGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Sedang Berbeda,  '
		}
		println(PTUtinggiAPK3 + ' | ' + PTUtinggiGen3)
		if (PTUtinggiAPK3 == PTUtinggiGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Tinggi Berbeda,  '
		}
		//PAT Polis Rendah, Sedang, Tinggi
		println(PATrendahAPK3 + ' | ' + PATrendahGen3)
		if (PATrendahAPK3 == PATrendahGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Rendah Berbeda,  '
		}
		println(PATsedangAPK3 + ' | ' + PATsedangGen3)
		if (PATsedangAPK3 == PATsedangGen3){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Sedang Berbeda,  '
		}
		println(PATtinggiAPK3 + ' | ' + PATtinggiGen3)
		if (PATtinggiAPK3 == PATtinggiGen3){
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
