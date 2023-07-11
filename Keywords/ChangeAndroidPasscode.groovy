import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement


class ChangeAndroidPasscode {
	/**
	 * Create passcode for the device. This keyword should be called if the device doesn't have any lock settings
	 */
	@Keyword
	def createPasscode(String appId) {
		try {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()

			driver.activateApp('com.android.settings')

			Mobile.scrollToText('Security')

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - Security'), 0)

			//check weather Screen Lock = None or not. If yes, set screen lock = PIN
			
			try {
				Mobile.verifyElementExist(findTestObject("Object Repository/Application/android.widget.TextView - None"), 3)
				
				Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - Screen lock'), 0)
				
				Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - PIN'), 0)
				
				Mobile.setText(findTestObject('Object Repository/Application/android.widget.EditText'), '1234', 0)
				
				Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - NEXT'), 0)
				
				Mobile.setText(findTestObject('Object Repository/Application/android.widget.EditText'), '1234', 0)
				
				Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - CONFIRM'), 0)
				
				Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - DONE'), 0)
				
			} catch (Exception e) {
				println e
			}
			driver.activateApp(appId)
			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to create Android device passcode")
		}
		return false;
	}

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}
}