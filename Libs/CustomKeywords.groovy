
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.applitools.eyes.selenium.Eyes

import org.openqa.selenium.WebElement

import com.applitools.eyes.RectangleSize


 /**
	 * Create passcode for the device. This keyword should be called if the device doesn't have any lock settings
	 */ 
def static "ChangeAndroidPasscode.createPasscode"(
    	String passcode	
     , 	String appId	) {
    (new ChangeAndroidPasscode()).createPasscode(
        	passcode
         , 	appId)
}

 /**
	 * Create passcode for the device. This keyword should be called if the device doesn't have any lock settings
	 */ 
def static "ChangeAndroidPasscode.cleanPasscode"(
    	String passcode	
     , 	String appId	) {
    (new ChangeAndroidPasscode()).cleanPasscode(
        	passcode
         , 	appId)
}

 /**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "ChangeAndroidPasscode.getCurrentSessionMobileDriver"() {
    (new ChangeAndroidPasscode()).getCurrentSessionMobileDriver()
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}


def static "com.testwithhari.katalon.plugins.Browserstack.updateTestStatusAndReason"(
    	String sessionID	
     , 	String testStatus	
     , 	String reasonForFailure	) {
    (new com.testwithhari.katalon.plugins.Browserstack()).updateTestStatusAndReason(
        	sessionID
         , 	testStatus
         , 	reasonForFailure)
}


def static "com.testwithhari.katalon.plugins.Browserstack.getCurrentTestRunSessionID"() {
    (new com.testwithhari.katalon.plugins.Browserstack()).getCurrentTestRunSessionID()
}


def static "com.testwithhari.katalon.plugins.Browserstack.updateTestName"(
    	String sessionID	
     , 	String TestName	) {
    (new com.testwithhari.katalon.plugins.Browserstack()).updateTestName(
        	sessionID
         , 	TestName)
}
