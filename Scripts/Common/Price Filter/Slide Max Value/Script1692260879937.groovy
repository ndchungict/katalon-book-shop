import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Set expected max price'
int expectedMaxPrice = expectedMaxPrice

'Convert to slide handle max element'
WebElement slideHandleMaxElement = WebUI.findWebElement(findTestObject('Object Repository/Shop/Price Filter/slideHandleMax'), 
    GlobalVariable.G_DEFAULT_TIMEOUT)

'Get current max price value'
int currentMaxPrice = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Shop/Price Filter/textMaxPrice')).replace(
        '₹', '').trim())

'Slide to expected value'
if (currentMaxPrice > expectedMaxPrice) {
	int time = currentMaxPrice - expectedMaxPrice
	
    while (time>0) {
        slideHandleMaxElement.sendKeys(Keys.ARROW_LEFT)
		time --
    }
	
}else if(currentMaxPrice < expectedMaxPrice){
	int time = expectedMaxPrice - currentMaxPrice
	while (time > 0) {
        slideHandleMaxElement.sendKeys(Keys.ARROW_RIGHT)
		time --
    }
}