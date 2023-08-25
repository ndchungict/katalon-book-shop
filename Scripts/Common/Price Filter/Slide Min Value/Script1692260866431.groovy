import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Set expected min price'
int expectedMinPrice = expectedMinPrice

'Convert to slide handle min element'
WebElement slideHandleMinElement = WebUI.findWebElement(findTestObject('Object Repository/Shop/Price Filter/slideHandleMin'), 
    GlobalVariable.G_DEFAULT_TIMEOUT)

'Get current min price value'
int currentMinPrice = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Shop/Price Filter/textMinPrice')).replace(
        '₹', '').trim())

'Slide to expected value'
if (currentMinPrice > expectedMinPrice) {
    int time = currentMinPrice - expectedMinPrice

    while (time > 0) {
        slideHandleMinElement.sendKeys(Keys.ARROW_LEFT)

        time--
    }
} else if (currentMinPrice < expectedMinPrice) {
    int time = expectedMinPrice - currentMinPrice

    while (time > 0) {
        slideHandleMinElement.sendKeys(Keys.ARROW_RIGHT)

        time--
    }
}