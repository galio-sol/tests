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

def reports = ['Activitate clienti', 'Calcul transport instructori', 'Clienti activi pe locatie', 'Clienti fara reinnoire', 'Clienti neprogramati la demo', 'Clienti noi platitori', 'Frecventa abonament', 
	'Grad de conversie pe instructor', 'Grad de ocupare pe locatie', 'Grafic programari dupa status', 'Grafic programari evolutie dupa locatie', 'Parametri de configurare', 'Pontaj', 'Programari', 
	'Programari demo', 'Promotii', 'Suspendari', 'Total conturi create BTP', 'Total demo cumparate',
	'Vanzari', 'Vanzari pe locatie']
//def testObjectPath = 'Object Repository/BT page/button_ReportViewerControlctl04ctl00'
//def testSuccessObjectRoot =  'Object Repository/BT page/Success/'
//reports = ['Report template']
//reports = ['Vanzari pe locatie']

for (def reportName : reports) {
//	testSuccessObjectPath = testSuccessObjectRoot + reportName
	
    WebUI.callTestCase(findTestCase('BT'), [('reportName') : reportName], FailureHandling.CONTINUE_ON_FAILURE)
}

