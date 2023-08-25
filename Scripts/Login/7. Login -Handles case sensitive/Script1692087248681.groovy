import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.Assert

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String user = username

String pass = password

WebUI.callTestCase(findTestCase('Common/Login Common'), [('username') : user.toUpperCase(), ('password') : pass.toUpperCase()], FailureHandling.STOP_ON_FAILURE)

'Expected Message'
String expectedMessage = "Error: The password you entered for the username ${user.toUpperCase()} is incorrect. Lost your password?"

'Login must fail saying incorrect username/password.'
WebUI.verifyElementText(findTestObject('Object Repository/My Account Page/textErrorMessage'), expectedMessage, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.takeFullPageScreenshot()

