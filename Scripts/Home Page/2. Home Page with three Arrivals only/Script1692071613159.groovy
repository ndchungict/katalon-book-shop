import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.Assert
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Open the browser'
WebUI.openBrowser('')

'Enter the URL “http://practice.automationtesting.in/”'
WebUI.navigateToUrl(GlobalVariable.G_WEB_BASE_URL)

'Click on Shop Menu'
WebUI.click(findTestObject('Top Menu/menuShop'))

'Now click on Home menu button'
WebUI.click(findTestObject('Menu Button/menuHomeButton'))

'Test whether the Home page has Three Arrivals only'
TestObject testObj = findTestObject('Object Repository/Home Page/Arrivals')

List<WebElement> listArrivals = WebUI.findWebElements(testObj, GlobalVariable.G_DEFAULT_TIMEOUT)

WebUI.comment("Number of arrivals is ${listArrivals.size()}")

WebUI.takeFullPageScreenshot()

'The Home page must contains only three Arrivals'
Assert.assertEquals(3, listArrivals.size())

return [('listArrivals'): listArrivals]