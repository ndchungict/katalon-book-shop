package com.chungnd.common

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
/**
 * @author chungnd
 *
 */
public class WebElementUI {
	@Keyword
	public List<WebElement> findListWebElements(TestObject testObj){
		return WebUI.findWebElements(testObj,10)
	}

	@Keyword
	def verifyNumberOfElements(TestObject testObj,int number) {
		WebUI.verifyEqual(findListWebElements(testObj).size(), number)
	}
}
