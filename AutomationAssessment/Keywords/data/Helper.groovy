package data

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

import internal.GlobalVariable

public class Helper {

	@Keyword
	def getRandomString(int count) {
		try{

			final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
			StringBuilder builder = new StringBuilder();

			while (count-- != 0) {
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}

			return builder.toString();
		}

		catch (Exception e) {
			KeywordUtil.markFailed("Random String cannot be formed")
		}
	}

	@Keyword
	def getRandomInteger(int lowerBound, int upperBound) {
		try{

			int randomInt = new Random().nextInt(upperBound - lowerBound + 1) + lowerBound
			return randomInt
		}

		catch (Exception e) {
			KeywordUtil.markFailed("Random Integer could not be formed")
		}
	}

	@Keyword
	def getRandomDecimal(int scaleFactor) {
		try{

			def randomDecimal = Math.random()*scaleFactor
			return randomDecimal.round(2)
		}

		catch (Exception e) {
			KeywordUtil.markFailed("Random Decimal could not be formed")
		}
	}

	@Keyword
	def convertToJsonSlurper(String jsonString){
		def slurper = new JsonSlurper()
		def result = slurper.parseText(jsonString)
		return result;
	}
}
