import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Open the browser'
WebUI.openBrowser('')

'Enter the URL “http://practice.automationtesting.in/”'
WebUI.navigateToUrl(GlobalVariable.G_WEB_BASE_URL)

'Click on Shop Menu'
WebUI.click(findTestObject('Top Menu/menuShop'))

'Adjust the filter by price between 150 to 450 rps'
int expectedMinPrice = 250

int expectedMaxPrice = 450

WebUI.callTestCase(findTestCase('Common/Price Filter/Slide Max Value'), [('expectedMaxPrice') : expectedMaxPrice], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Price Filter/Slide Min Value'), [('expectedMinPrice') : expectedMinPrice], FailureHandling.STOP_ON_FAILURE)

'Now click on Filter button'
WebUI.click(findTestObject('Object Repository/Shop/Price Filter/buttonFilter'))

'Take Screenshot'
WebUI.takeFullPageScreenshot()

'User can view books only between 150 to 450 rps price'

