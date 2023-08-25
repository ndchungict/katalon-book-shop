import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String user = username

String pass = password

WebUI.callTestCase(findTestCase('Common/Login Common'), [('username') : user, ('password') : pass], FailureHandling.STOP_ON_FAILURE)

'User must successfully login to the web page'
WebUI.verifyElementPresent(findTestObject('Object Repository/My Account Page/My Account Navigation/menuDashBoard'), GlobalVariable.G_DEFAULT_TIMEOUT)

'Take full page screenshot'
WebUI.takeFullPageScreenshot()

'Sign out the sign'
WebUI.click(findTestObject('Object Repository/My Account Page/My Account Navigation/menuLogout'))

'Take full page screenshot'
WebUI.takeFullPageScreenshot()

'Press back button'
WebUI.back()

'User shouldn’t be signed in to his account rather a general webpage must be visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/My Account Page/Login Form/buttonLogin'), GlobalVariable.G_DEFAULT_TIMEOUT,FailureHandling.CONTINUE_ON_FAILURE)

'Take full page screenshot'
WebUI.takeFullPageScreenshot()