import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import chungnd.utilites.DateTimeGenerator
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Get local time'
DateTimeGenerator dateTimeGenerator = new DateTimeGenerator()
String time = dateTimeGenerator.timeInSecond

'Generate new valid email'
String email = ('Chungnd' + time) + '@auto.com'

String pass = GlobalVariable.G_VALID_PASSWORD

WebUI.callTestCase(findTestCase('Common/Register Common'), [('reg_email') : email, ('reg_password') : pass], FailureHandling.STOP_ON_FAILURE)

'User must registered and successfully login to the web page'
WebUI.verifyElementPresent(findTestObject('Object Repository/My Account Page/My Account Navigation/menuDashBoard'), GlobalVariable.G_DEFAULT_TIMEOUT)

WebUI.takeFullPageScreenshot()