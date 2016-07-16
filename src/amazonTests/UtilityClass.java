package amazonTests;

import java.io.BufferedWriter;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import modules.Homepage;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;





public class UtilityClass {



	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	@Test
	public void test() throws Exception {

	}


	public static String startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");
		System.out.println("timestamp:" +strTimeStamp);
		return strTimeStamp;

	}
	protected static void enterText(WebElement textElement, String textInput, String InputName) throws IOException {
		// TODO Auto-generated method stub
		if (textElement.isDisplayed()){
			//textElement.clear();
			textElement.sendKeys(textInput);

			Update_Report( "Pass", "Enter Text",  InputName +" is entered");
		}else{
			Update_Report( "Fail", "Enter Text", InputName +" not entered");
		}


	}

	protected static void selectDropDownOption(WebElement dropDownElement, String optionName) throws IOException {
		// TODO Auto-generated method stub
		if (dropDownElement.isDisplayed()){
			Select select = new Select(dropDownElement);

			select.deselectAll();
			select.selectByVisibleText(optionName);

			select.selectByVisibleText(optionName);


			Update_Report( "Pass", "Select Dropdown Option",  optionName +" is selected");
		}else{
			Update_Report( "Fail", "Selected Dropdown Option", optionName +" not selected");
		}


	}


	/*
	 * Name of the method: Click an element
	 * Brief Description: Click on a web element if displayed
	 * Arguments: webElement---> webElement object, objName---> Object name
	 * Created By: TechPirates
	 * Creation Date:June 29 2016
	 * Last Modified: June 29 2016
	 * 
	 * 
	 */





	public static void clickElement(WebElement webElement, String objName) throws IOException {
		// TODO Auto-generated method stub
		if (webElement.isDisplayed()){
			webElement.click();

			Update_Report( "Pass", "Click Element",  objName +" is clicked");
		}else{
			Update_Report( "Fail", "Click Element", objName +" not displayed , please check your application");
		}

	}


	/*
	 * Name of the method: validateTextMessage
	 * Brief Description: Validate Text Message
	 * Arguments: webObj---> webElement object, expectedTextMsg---> Expected Text message
	 * Created By: TechPirates
	 * Creation Date:June 29 2016
	 * Last Modified: June 29 2016
	 * 
	 * 
	 */
	public static void validateTextMessage(WebElement obj, String expectedTextMsg) throws IOException {
		// TODO Auto-generated method stub
		if(obj.isDisplayed()){
			String actualTextMsg = obj.getText();
			if( actualTextMsg.equals(expectedTextMsg )){
				Update_Report( "Pass", "Validate Text Me",  "Expected message matched with '"+ actualTextMsg+"'");
			}else{
				Update_Report( "Fail", "Text message Validation",  "Expected message matched with'"+ expectedTextMsg+"'");
			}

		}
	}

	/*
	 * Name of the method: deselectCheckbox
	 * Brief Description: deselect checkbox
	 * Arguments: webObj---> webElement object, checkBoxName---> Name of the check Box
	 * Created By: TechPirates
	 * Creation Date:June 29 2016
	 * Last Modified: June 29 2016
	 * 
	 * 
	 */
	public static void deselectCheckbox(WebElement webObj, String checkBoxName) throws IOException {
		// TODO Auto-generated method stub
		if(webObj.isDisplayed()){
			if( webObj.isSelected()){
				webObj.click();
				Update_Report( "Pass", "Deselect checkbox",  checkBoxName+" is  deselected");
			}else{
				Update_Report( "Fail", "Deselect checkbox",  checkBoxName+" is already deselected");
			}
		}else{
			Update_Report( "Fail", "Deselect checkbox",  checkBoxName+" is no displayed");
		}
	}



	/*
	 * Name of the method: selectCheckbox
	 * Brief Description: select checkbox
	 * Arguments: webObj---> webElement object, checkBoxName---> Name of the check Box
	 * Created By: TechPirates
	 * Creation Date:June 29 2016
	 * Last Modified: June 29 2016
	 */



	public static void selectCheckbox(WebElement webObj,	String checkBoxName) throws IOException {
		// TODO Auto-generated method stub
		if(webObj.isDisplayed()){
			if( webObj.isSelected()){
				Update_Report( "Fail", "select checkbox",  checkBoxName+" is already selected");
			}else{
				webObj.click();
				Update_Report( "Pass", "select checkbox",  checkBoxName+" is  selected");
			}
		}else{
			Update_Report( "Fail", "select checkbox",  checkBoxName+" is not displayed please check your application");
		}


	}

	public static void verifyHover(WebDriver driver,WebElement webObj, String hoverLinkName) throws IOException {
		// TODO Auto-generated method stub
		if( webObj.isDisplayed()){
			Actions action = new Actions(driver);
			action.moveToElement(webObj).perform();
			System.out.println(webObj.getAttribute("style").toString());
			if(webObj.getAttribute("style").contains("background-color: #e47911;")){
				Update_Report( "Pass", "Verify Hover", "Hover on "+ hoverLinkName+" is succesfull");
			}else{
				Update_Report( "Fail", "Verify Hover",  "Hover on "+ hoverLinkName+" is succesfull");
			}
		}else{

			Update_Report( "Fail", "Verify Hover Link",  hoverLinkName+" is not  displayed");
		}



	}

	static String[][] readExcel(String dtTablePath, String sheetname) throws IOException{
		File xlfile = new File (dtTablePath);
		FileInputStream xldoc = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(xldoc);
		XSSFSheet sheet = wb.getSheet(sheetname);
		int iRowCount = sheet.getLastRowNum()+1;
		int iColumnCount =  sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[iRowCount][iColumnCount];

		for( int i = 0; i < iRowCount; i++){
			for(int j = 0;j< iColumnCount; j++){
				XSSFCell cell = sheet.getRow(i).getCell(j);
				if (cell.getCellType() == 1){
					xlData[i][j] = String.valueOf(cell);

				}else if ((cell.getCellType() == 0)){
					xlData[i][j] = String.valueOf(Double.valueOf(cell.getNumericCellValue()).intValue());
				}
			}
		}
		// sheet.getPhysicalNumberOfRows();
		//int iColCount = sheet.getRow(0).getLastCellNum()
		return xlData;
	}


	public static void writeExecutionResults(String testMethodName, String result, String testScriptsTablePath, String sheetName, String timestamp  ) throws IOException {
		// TODO Auto-generated method stub


		File xlfile = new File (testScriptsTablePath);
		FileInputStream xldoc = new FileInputStream(xlfile);



		XSSFWorkbook wb = new XSSFWorkbook(xldoc);

		XSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;

		for( int i = 0; i < iRowCount; i++){
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(1);
			if (cell.getStringCellValue().equals(testMethodName)) {

				XSSFCell cell1 = row.createCell(2, XSSFCell.CELL_TYPE_STRING) ;
				cell1.setCellValue(result);
				XSSFCreationHelper helper= wb.getCreationHelper();
				XSSFHyperlink hyperlink=helper.createHyperlink(Hyperlink.LINK_URL);
				String path = "file:///C:/Users/vj/Desktop/Report/Log/Amazon%20Search%20Test%20Cases/Amazon%20Search%20Test%20Cases" +  "_"+timestamp+".html";
				hyperlink.setAddress(path);

				cell1.setHyperlink(hyperlink);

				System.out.println("Updating test  "+cell.getStringCellValue()+ " with result: "+result);
				XSSFCellStyle titleStyle = wb.createCellStyle();
				if(cell1.getStringCellValue().equals("Pass")){
					titleStyle.setFillForegroundColor(
							HSSFColor.LIGHT_GREEN.index );


					titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cell1.setCellStyle(titleStyle);
					break;

				}
				else if(cell1.getStringCellValue().equals("Fail")){
					titleStyle.setFillForegroundColor(
							HSSFColor.RED.index );
					titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cell1.setCellStyle(titleStyle);
					break;
				}

			}


		}
		FileOutputStream fout = new FileOutputStream(testScriptsTablePath);
		wb.write(fout);
		fout.flush();
		fout.close();


	}


	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ result + "</FONT></TD></TR>");

		} 

	}








}


