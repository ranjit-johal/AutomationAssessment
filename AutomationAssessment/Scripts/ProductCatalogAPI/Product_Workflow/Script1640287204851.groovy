import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager


//#################Post a Product

//Set the data to be posted
GlobalVariable.productId = CustomKeywords.'data.Helper.getRandomString'(10)
GlobalVariable.productName = CustomKeywords.'data.Helper.getRandomString'(15)
GlobalVariable.productDescription = CustomKeywords.'data.Helper.getRandomString'(25)
GlobalVariable.productPrice = CustomKeywords.'data.Helper.getRandomDecimal'(50)
GlobalVariable.productQuantity = CustomKeywords.'data.Helper.getRandomInteger'(0, 20)
GlobalVariable.isProductActive = true
GlobalVariable.productCreateDateTime = new Date().format("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toString()
GlobalVariable.productModifiedDateTime = new Date().format("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toString()

//Send request
RequestObject postRequest = findTestObject('Object Repository/ProductCatalogAPI/PostProduct')
ResponseObject postResponse = WS.sendRequest(postRequest)

//Verify response code
WS.verifyResponseStatusCode(postResponse, 200)

//Verify response body agrees with posted data
def postResponseBodyString = postResponse.getProperties().get("responseText")
def postResponseBodyMap = CustomKeywords.'data.Helper.convertToJsonSlurper'(postResponseBodyString)
KeywordUtil.logInfo(" POST Response Body: "+ postResponseBodyString)

WS.verifyEqual(GlobalVariable.productName, postResponseBodyMap.name)
WS.verifyEqual(GlobalVariable.productDescription, responseBodyMap.description)
WS.verifyEqual(GlobalVariable.productPrice, postResponseBodyMap.price)
WS.verifyEqual(GlobalVariable.productQuantity, postResponseBodyMap.itemCount)
WS.verifyEqual(GlobalVariable.isProductActive, postResponseBodyMap.isActive)
WS.verifyEqual(GlobalVariable.productCreateDateTime, responseBodyMap.createdDateTime)


//################# Update this Product's name, description, price and quantity

GlobalVariable.productId = postResponseBodyMap.id

//The updated data
GlobalVariable.productName = CustomKeywords.'data.Helper.getRandomString'(15)
GlobalVariable.productDescription = CustomKeywords.'data.Helper.getRandomString'(25)
GlobalVariable.productPrice = CustomKeywords.'data.Helper.getRandomDecimal'(50)
GlobalVariable.productQuantity = CustomKeywords.'data.Helper.getRandomInteger'(0, 20)

//Send request
RequestObject putRequest = findTestObject('Object Repository/ProductCatalogAPI/UpdateProduct')
ResponseObject putResponse = WS.sendRequest(putRequest)

//Verify response code
WS.verifyResponseStatusCode(putResponse, 200)

//Verify response body agrees with the updated data
def putResponseBodyString = putResponse.getProperties().get("responseText")
def putResponseBodyMap = CustomKeywords.'data.Helper.convertToJsonSlurper'(putResponseBodyString)
KeywordUtil.logInfo("PUT Response Body: "+ putResponseBodyString)

WS.verifyEqual(GlobalVariable.productId, putResponseBodyMap.id)
WS.verifyEqual(GlobalVariable.productName, putResponseBodyMap.name)
WS.verifyEqual(GlobalVariable.productDescription, putResponseBodyMap.description)
WS.verifyEqual(GlobalVariable.productPrice, putResponseBodyMap.price)
WS.verifyEqual(GlobalVariable.productQuantity, putResponseBodyMap.itemCount)
WS.verifyEqual(GlobalVariable.isProductActive, putResponseBodyMap.isActive)


//################# Get this Product

//Send request
RequestObject getRequest = findTestObject('Object Repository/ProductCatalogAPI/GetProduct')
ResponseObject getResponse = WS.sendRequest(getRequest)

//Verify response code
WS.verifyResponseStatusCode(getResponse, 200)

//Verify response body
def getResponseBodyString = getResponse.getProperties().get("responseText")
def getResponseBodyMap = CustomKeywords.'data.Helper.convertToJsonSlurper'(getResponseBodyString)
KeywordUtil.logInfo("GET Response Body: "+ getResponseBodyString)

WS.verifyEqual(GlobalVariable.productId, getResponseBodyMap.id)
WS.verifyEqual(GlobalVariable.productName, getResponseBodyMap.name)
WS.verifyEqual(GlobalVariable.productDescription, getResponseBodyMap.description)
WS.verifyEqual(GlobalVariable.productPrice, getResponseBodyMap.price)
WS.verifyEqual(GlobalVariable.productQuantity, getResponseBodyMap.itemCount)
WS.verifyEqual(GlobalVariable.isProductActive, getResponseBodyMap.isActive)


//################# Delete this Product

//Send request
RequestObject deleteRequest = findTestObject('Object Repository/ProductCatalogAPI/DeleteProduct')
ResponseObject deleteResponse = WS.sendRequest(deleteRequest)

//Verify response code
WS.verifyResponseStatusCode(deleteResponse, 200)

//Verify response body
def deleteResponseBodyString = deleteResponse.getProperties().get("responseText")
def deleteResponseBodyMap = CustomKeywords.'data.Helper.convertToJsonSlurper'(deleteResponseBodyString)
KeywordUtil.logInfo("DELETE Response Body: "+ deleteResponseBodyString)

WS.verifyEqual(GlobalVariable.productId, deleteResponseBodyMap.id)
WS.verifyEqual(GlobalVariable.productName, deleteResponseBodyMap.name)
WS.verifyEqual(GlobalVariable.productDescription, deleteResponseBodyMap.description)
WS.verifyEqual(GlobalVariable.productPrice, deleteResponseBodyMap.price)
WS.verifyEqual(GlobalVariable.productQuantity, deleteResponseBodyMap.itemCount)
WS.verifyEqual(false, deleteResponseBodyMap.isActive)
