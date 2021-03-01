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


public class ProposalASL1 {

	def ComparePS(String strNo, int excelRow){

		TestData dataCompareAPK 				= findTestData('dt-1/dt_APK') //NARIK DATA DARI EXCEL APK
		TestData dataCompareGen 				= findTestData('dt-1/dt_Generator') // NARIK DATA DARI EXCEL HASIL GENERATOR
		String AkhirTahunKeAPK 					= dataCompareAPK.getValue('AKHIR TAHUN KE', excelRow)
		String AkhirTahunkeGen 					= dataCompareGen.getValue('AKHIR TAHUN KE', excelRow)
		String UsiaAPK 							= dataCompareAPK.getValue('USIA', excelRow)
		String UsiaGen 							= dataCompareGen.getValue('USIA', excelRow)
		String TotalPremiThnanAPK				= dataCompareAPK.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String TotalPremiThnanGen				= dataCompareGen.getValue('TOTAL PREMI TAHUNAN', excelRow)
		String PremiTopUpTunggalAPK				= dataCompareAPK.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String PremiTopUpTunggalGen				= dataCompareGen.getValue('PREMI TOP UP TUNGGAL', excelRow)
		String BonusAlokasiInvesAPK				= dataCompareAPK.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String BonusAlokasiInvesGen				= dataCompareGen.getValue('BONUS ALOKASI INVESTASI', excelRow)
		String LoyaltyBonusAPK					= dataCompareAPK.getValue('LOYALTY BONUS', excelRow)
		String LoyaltyBonusGen					= dataCompareGen.getValue('LOYALTY BONUS', excelRow)
		String PenarikanSebagianAPK				= dataCompareAPK.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PenarikanSebagianGen				= dataCompareGen.getValue('PENARIKAN SEBAGIAN UNIT', excelRow)
		String PDrendahAPK						= dataCompareAPK.getValue('PD RENDAH', excelRow)
		String PDrendahGen						= dataCompareGen.getValue('PD RENDAH', excelRow)
		String PDsedangAPK						= dataCompareAPK.getValue('PD SEDANG', excelRow)
		String PDsedangGen						= dataCompareGen.getValue('PD SEDANG', excelRow)
		String PDtinggiAPK						= dataCompareAPK.getValue('PD TINGGI', excelRow)
		String PDtinggiGen						= dataCompareGen.getValue('PD TINGGI', excelRow)
		String PTUrendahAPK						= dataCompareAPK.getValue('PTU RENDAH', excelRow)
		String PTUrendahGen						= dataCompareGen.getValue('PTU RENDAH', excelRow)
		String PTUsedangAPK						= dataCompareAPK.getValue('PTU SEDANG', excelRow)
		String PTUsedangGen						= dataCompareGen.getValue('PTU SEDANG', excelRow)
		String PTUtinggiAPK						= dataCompareAPK.getValue('PTU TINGGI', excelRow)
		String PTUtinggiGen						= dataCompareGen.getValue('PTU TINGGI', excelRow)
		String PATrendahAPK						= dataCompareAPK.getValue('PAT RENDAH', excelRow)
		String PATrendahGen						= dataCompareGen.getValue('PAT RENDAH', excelRow)
		String PATsedangAPK						= dataCompareAPK.getValue('PAT SEDANG', excelRow)
		String PATsedangGen						= dataCompareGen.getValue('PAT SEDANG', excelRow)
		String PATtinggiAPK						= dataCompareAPK.getValue('PAT TINGGI', excelRow)
		String PATtinggiGen						= dataCompareGen.getValue('PAT TINGGI', excelRow)

		//AkhirTahunKe
		println(AkhirTahunKeAPK + ' | ' + AkhirTahunkeGen)
		if (AkhirTahunKeAPK == AkhirTahunkeGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		} else {
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Akhir Tahun Berbeda,   '
		}
		//Usia
		println(UsiaAPK + ' | ' + UsiaGen)
		if (UsiaAPK == UsiaGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Usia Berbeda,  '
		}
		//Total Premi Tahunan
		println(TotalPremiThnanAPK + ' | ' + TotalPremiThnanGen)
		if (TotalPremiThnanAPK == TotalPremiThnanGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Total Premi Tahunan Berbeda,  '
		}
		//Total Top Up Tunggal
		println(PremiTopUpTunggalAPK + ' | ' + PremiTopUpTunggalGen)
		if (PremiTopUpTunggalAPK == PremiTopUpTunggalGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Berbeda,  '
		}
		//Bonus Alokasi Investasi
		println(BonusAlokasiInvesAPK + ' | ' + BonusAlokasiInvesGen)
		if (BonusAlokasiInvesAPK == BonusAlokasiInvesGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Premi Topup Berbeda,  '
		}
		//Loyalty Bonus
		println(LoyaltyBonusAPK + ' | ' + LoyaltyBonusGen)
		if (LoyaltyBonusAPK == LoyaltyBonusGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Loyalty Berbeda Berbeda,  '
		}
		//Penarikan Sebagian Unit
		println(PenarikanSebagianAPK + ' | ' + PenarikanSebagianGen)
		if (PenarikanSebagianAPK == PenarikanSebagianGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Penarikan Sebagian Berbeda,  '
		}
		//PD Rendah, Sedang, Tinggi
		println(PDrendahAPK + ' | ' + PDrendahGen)
		if (PDrendahAPK == PDrendahGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Rendah Berbeda,  '
		}
		println(PDsedangAPK + ' | ' + PDsedangGen)
		if (PDsedangAPK == PDsedangGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Sedang Berbeda,  '
		}
		println(PDtinggiAPK + ' | ' + PDtinggiGen)
		if (PDtinggiAPK == PDtinggiGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Dasar Tinggi Berbeda,  '
		}
		//PTU Rendah, Sedang, Tinggi
		println(PTUrendahAPK + ' | ' + PTUrendahGen)
		if (PTUrendahAPK == PTUrendahGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Rendah Berbeda,  '
		}
		println(PTUsedangAPK + ' | ' + PTUsedangGen)
		if (PTUsedangAPK == PTUsedangGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Sedang Berbeda,  '
		}
		println(PTUtinggiAPK + ' | ' + PTUtinggiGen)
		if (PTUtinggiAPK == PTUtinggiGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Premi Top Up Tinggi Berbeda,  '
		}
		//PAT Polis Rendah, Sedang, Tinggi
		println(PATrendahAPK + ' | ' + PATrendahGen)
		if (PATrendahAPK == PATrendahGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Rendah Berbeda,  '
		}
		println(PATsedangAPK + ' | ' + PATsedangGen)
		if (PATsedangAPK == PATsedangGen){
			//GlobalVariable.strGlbStatus = 'PASSED'
		}else{
			GlobalVariable.strGlbStatus = 'FAILED'
			GlobalVariable.strGlbKeterangan = 'Nilai Pada Akhir Tahun Polis Sedang Berbeda,  '
		}
		println(PATtinggiAPK + ' | ' + PATtinggiGen)
		if (PATtinggiAPK == PATtinggiGen){
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