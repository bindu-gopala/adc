package amazonTests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import modules.Homepage;
import modules.SearchResultsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AutomationScripts extends UtilityClass {
	protected static  WebDriver driver= new FirefoxDriver();


	public static String launchApp() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "https://www.amazon.com/";
		try{

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			String pageTitle = Homepage.goToHomepage(url);
			if(pageTitle.equals(pageTitle)){
				Update_Report( "Pass", "Launched App",  url +" is launched");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Could not Launch App",  url +" is not launched");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();

		}



	}

	public static String searchForItem() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String item = "iphone 6";
		String url = "https://www.amazon.com/";
		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			String pageTitle = Homepage.goToHomepage(url);
			timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
			Homepage.searchForItem(item);
			String searchedItem = SearchResultsPage.getSearchedItemResults();
			if(searchedItem.contains(item)){
				Update_Report( "Pass", "Search For Item",  item +" is successfull");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Search For item ",  item +" is not successfull");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail", "Search For item ",  item +" is not completed successfull");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}

	public static String searchForItemSuggestion() throws IOException {
		// TODO Auto-generated method stub
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String item = "iphone 6";
		String url = "https://www.amazon.com/";
		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			String pageTitle = Homepage.goToHomepage(url);
			String option=Homepage.searchForItemSearchSuggestion(item);

			if(option.contains("All Departments")){
				Update_Report( "Pass", "Search for Item Suggestion",  item +" is suggested");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Search for Item Suggestion",  item +" is not suggested");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail", "Search for Item Suggestion",  item +" is not completed successfully");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}

	public static String validateDepartmentDropDown() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "https://www.amazon.com/";
		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\Desktop\\Amazon.com\\departmentsList.xlsx", "Sheet1");
			String pageTitle = Homepage.goToHomepage(url);
			List<WebElement> departmentsDropdown = Homepage.getDepartmentDropDown();


			if(departmentsDropdown.get(0).getText().equals(recData[1][1])){
				Update_Report( "Pass", "Validate Department DropDown", " Department Drop down is dispalyed");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Validate Department DropDown", " Department Drop down is not dispalyed");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail", "Validate Department DropDown", " Department Drop down could not be verified ");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}

	public static String validateTryPrimeDropDown() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "https://www.amazon.com/";
		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\Desktop\\Amazon.com\\tryPrimeList.xlsx", "Sheet1");
			String pageTitle = Homepage.goToHomepage(url);
			List<WebElement> tryPrimetDropDownList = Homepage.getTryPrimeDropDown();


			if(tryPrimetDropDownList.get(0).getText().equals(recData[1][1])){
				Update_Report( "Pass", "Validate Try Prime DropDown", " Department Drop down is dispalyed");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Validate Try Prime DropDown", " Department Drop down is not dispalyed");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail", "Validate Try Prime DropDown", " Department Drop down could not be verified ");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}

	public static String validateYourAccountDropDown() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "https://www.amazon.com/";
		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\Desktop\\Amazon.com\\yourAccountList.xlsx", "Sheet1");
			String pageTitle = Homepage.goToHomepage(url);
			List<WebElement> getYourAccountDropDown = Homepage.getYourAccountDropDown();


			if(getYourAccountDropDown.get(0).getText().equals(recData[1][1])){
				Update_Report( "Pass", "Validate Try Prime DropDown", " Department Drop down is dispalyed");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail", "Validate Try Prime DropDown", " Department Drop down is not dispalyed");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail", "Validate Try Prime DropDown", " Department Drop down could not be verified ");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}

	public static String validateHover() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone";
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");

		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\Desktop\\Amazon.com\\leftNavLinks.xlsx", "Sheet1");
			String pageTitle = SearchResultsPage.getSearchedUrl(url);
			System.out.println(recData[1][1]);
			verifyHover(driver, SearchResultsPage.getNavLink(recData[1][1]), recData[1][1]);

			return "Pass"+ " "+timestamp;


		}catch(Exception e){
			Update_Report( "Fail", "Validate Hover", " Hover element could not be verified ");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}

	}
	public static String validateRefineSearch() throws IOException{
		String timestamp;
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");
		String url = "http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone";
		timestamp = startReport("Amazon Search Test Cases","C:\\Users\\vj\\Desktop\\Report\\");

		try{
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\Desktop\\Amazon.com\\filtersList.xlsx", "Sheet1");
			String pageTitle = SearchResultsPage.getSearchedUrl(url);
			System.out.println(recData[1][1]);
			WebElement filterCheckBox=SearchResultsPage.getFilter(recData[1][1]);

			if(filterCheckBox.getAttribute("src").contains("checkbox_unselected_enabled")){
				Update_Report( "Pass", "Validate refine search", recData[1][1]+" Checkbox is unselected");
				return "Pass"+ " "+timestamp;

			}else{
				Update_Report( "Fail",  "Validate refine search", recData[1][1]+" Checkbox is selected");
				return "Fail"+ " "+timestamp;
			}
		}catch(Exception e){
			Update_Report( "Fail",  "Validate refine search", " Checkbox could not be verified");
			return "Fail"+ " "+timestamp;

		}
		finally{
			bw.close();
		}
	}
}
