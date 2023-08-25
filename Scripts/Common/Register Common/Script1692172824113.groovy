import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Open the browser'
WebUI.openBrowser('')

'Enter the URL “http://practice.automationtesting.in/”'
WebUI.navigateToUrl(GlobalVariable.G_WEB_BASE_URL)

'Click on Shop Menu'
WebUI.click(findTestObject('Object Repository/Top Menu/menuMyAccount'))

WebUI.comment("Register new account with email: ${reg_email} and password: ${reg_password}")

'Enter email in email textbox'
WebUI.sendKeys(findTestObject('Object Repository/My Account Page/Register Form/textboxEmail'), reg_email)

'Enter password in password textbox'
WebUI.sendKeys(findTestObject('Object Repository/My Account Page/Register Form/textboxPassword'), reg_password)

'Click on register button'
WebUI.click(findTestObject('Object Repository/My Account Page/Register Form/buttonRegister'))

'Take Screenshot'
WebUI.takeFullPageScreenshot()

