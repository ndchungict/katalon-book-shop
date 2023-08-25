import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

data = WebUI.callTestCase(findTestCase('Home Page/2. Home Page with three Arrivals only'), [:], FailureHandling.STOP_ON_FAILURE)

'Now click the image in the Arrivals'
WebUI.scrollToElement(findTestObject('Object Repository/Home Page/Arrivals'), GlobalVariable.G_DEFAULT_TIMEOUT)

List<WebElement> listElementArrivals = data.listArrivals

WebUI.comment(listElementArrivals.size())

//Webdriver driver = DriverFactory.getWebDriver()


//WebUI.click(findTestObject('Object Repository/Home Page/Arrivals'))