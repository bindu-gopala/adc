package modules;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import amazonTests.AutomationScripts;

public class Homepage extends AutomationScripts{


	public static  String goToHomepage(String url) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		driver.get(url);
		return driver.getTitle();

	}

	public static String searchForItemSearchSuggestion(String item) throws IOException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		enterText( searchBox, item, "Search Box");

		new Actions(driver).moveToElement(searchBox).click().perform(); 
		searchBox.sendKeys(Keys.DOWN);
		WebElement suggestion = driver.findElement(By.id("suggestions")).findElement(By.id("issDiv0"));
		String option = suggestion.getAttribute("data-store");
		return option;
	}

	public static void searchForItem(String item) throws IOException, InterruptedException {
		// TODO Auto-generated method stub 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		enterText( searchBox, item, "Search Box");
		WebElement search = driver.findElement(By.xpath("//input[@value='Go']"));
		clickElement( search,  "Search Button");



	}
	
	public static List<WebElement> getDepartmentDropDown(){
		
		WebElement departmentsLink = driver.findElement(By.id("nav-link-shopall"));
		Actions action = new Actions(driver);
		action.moveToElement(departmentsLink).perform();

		List<WebElement> departmentDropDownList = driver.findElements(By.xpath("//span[@role='navigation']"));
		return departmentDropDownList;
		
	}

public static List<WebElement> getTryPrimeDropDown(){
		
		WebElement tryPrimeLink = driver.findElement(By.id("nav-link-prime"));
		Actions action = new Actions(driver);
		action.moveToElement(tryPrimeLink).perform();

		List<WebElement> tryPrimetDropDownList = driver.findElements(By.xpath("//span[@role='navigation']"));
		return tryPrimetDropDownList;
		
	}

public static List<WebElement> getYourAccountDropDown(){
	
	WebElement yourAccountLink = driver.findElement(By.linkText("Your Account"));
	Actions action = new Actions(driver);
	action.moveToElement(yourAccountLink).perform();

	List<WebElement> yourAccountDropdownList = driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']")).findElements(By.tagName("a"));
	return yourAccountDropdownList;
	
}
}