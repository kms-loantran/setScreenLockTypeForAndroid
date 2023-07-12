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
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.AndroidDriver


class ChangeAndroidPasscode {
	/**
	 * Create passcode for the device. This keyword should be called if the device doesn't have any lock settings
	 */
	@Keyword
	def createPasscode(String passcode, String appId) {
		try {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()

			driver.activateApp('com.android.settings')

			Mobile.scrollToText('Security')

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - Security'), 0)
			
			Mobile.scrollToText('Screen lock')

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - Screen lock'), 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - PIN'), 0)

			Mobile.setText(findTestObject('Object Repository/Application/android.widget.EditText'), passcode, 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - NEXT'), 5)

			Mobile.setText(findTestObject('Object Repository/Application/android.widget.EditText'), passcode, 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - CONFIRM'), 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - DONE'), 0)

			driver.activateApp(appId)

			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to create Android device passcode")
		}
		return false;
	}

	/**
	 * Create passcode for the device. This keyword should be called if the device doesn't have any lock settings
	 */
	@Keyword
	def cleanPasscode(String passcode, String appId) {
		try {
			AndroidDriver<?> driver = MobileDriverFactory.getDriver()

			driver.activateApp('com.android.settings')

			Mobile.scrollToText('Security')

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - Security (1)'), 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - PIN (2)'), 0)

			def codes = passcode.toList()
			codes.each { code ->
				switch (code) {
					case "1":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
						break
					case "2":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
						break
					case "3":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))
						break
					case "4":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))
						break
					case "5":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))
						break
					case "6":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6))
						break
					case "7":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7))
						break
					case "8":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8))
						break
					case "9":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9))
						break
					case "0":
						driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
						break
				}
			}
			driver.pressKey(new KeyEvent(AndroidKey.ENTER))

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.TextView - None'), 0)

			Mobile.tap(findTestObject('Object Repository/Application/android.widget.Button - Yes, remove'), 0)

			driver.activateApp(appId)

			return true
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.markFailed("Failed to  Android device passcode")
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