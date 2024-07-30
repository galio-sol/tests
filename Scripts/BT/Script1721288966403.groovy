import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testobject.SelectorMethod.BASIC

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.entity.global.GlobalVariableEntity

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webservice.support.UrlEncoder
import java.nio.charset.StandardCharsets
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement

def Boolean isButtonPressed = true
def Integer timeout = 20
def Integer steps = 0 
def Map bt = GlobalVariable.BT
def String reportPath = UrlEncoder.encode(reportName).replace("+", "%20")
def String testButtonPressed = 'Object Repository/Page_Report template - SQL Server 2017 Reporting Services/button_ReportViewerControl'
def String testExecutionSuccess = 'Object Repository/Page_Report template - SQL Server 2017 Reporting Services/iframe_Report template_viewer'
testExecutionSuccess = 'Object Repository/BT page/iframe_Report template_viewer'

WebUI.openBrowser('')

WebUI.delay(1)

WebUI.authenticate('https://advanced-reports.idei.io/reports/report/BodyTailors/Reports/' + reportPath, bt.USER, bt.PASSWORD, 1, FailureHandling.STOP_ON_FAILURE)


def TestObject buton = findTestObject(testButtonPressed)

WebUI.waitForElementClickable(buton, timeout, FailureHandling.STOP_ON_FAILURE)

//while (isButtonPressed) {
//	isButtonPressed =  !WebUI.waitForElementClickable(buton, timeout, FailureHandling.OPTIONAL)
//}

def TestObject frame = findTestObject(testExecutionSuccess)
def TestObject to = new TestObject()
to.addProperty("tag", ConditionType.EQUALS, "div")
to.addProperty("text", ConditionType.EQUALS, "Report executed successfully")

WebUI.switchToFrame(frame, 1)
WebUI.findWebElement(to, 1)

WebUI.closeBrowser()

