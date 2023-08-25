import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.Assert

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String user = username

String pass = password

WebUI.callTestCase(findTestCase('Common/Login Common'), [('username') : user, ('password') : pass], FailureHandling.STOP_ON_FAILURE)

'Expected Message'
String expectedMessage = "Error: A user could not be found with this email address."

'Proper error must be displayed(ie Invalid username) and prompt to enter login again'
WebUI.verifyElementText(findTestObject('Object Repository/My Account Page/textErrorMessage'), expectedMessage, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.takeFullPageScreenshot()