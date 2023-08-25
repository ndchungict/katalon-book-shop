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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String email = reg_email

String pass = reg_password

String expectedMessage = message

String note = note

WebUI.comment(note)

WebUI.callTestCase(findTestCase('Common/Register Common'), [('reg_email') : email, ('reg_password') : pass], FailureHandling.STOP_ON_FAILURE)

'Registration must fail with a warning message'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/My Account Page/textErrorMessage'), 5, FailureHandling.OPTIONAL) == true) {
    WebUI.verifyElementText(findTestObject('Object Repository/My Account Page/textErrorMessage'), expectedMessage, FailureHandling.STOP_ON_FAILURE)
//	KeywordUtil.markPassed("Warning message displayed!")
} else {
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/My Account Page/Register Form/textboxEmail'), 'validationMessage', 
        expectedMessage, 0)
}