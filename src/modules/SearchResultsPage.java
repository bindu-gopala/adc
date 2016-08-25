package modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazonTests.AutomationScripts;

public class SearchResultsPage extends AutomationScripts {

	public static String getSearchedItemResults() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		
		WebElement searchResult = driver.findElement(By.id("s-result-count"));

		return searchResult.getText();
	}
	
	public static String getSearchedUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		return driver.getTitle();
	}
	
	public static WebElement getNavLink(String navLinkName) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String locator = "//span[contains(text(), '"+navLinkName+"')]";
		System.out.println("Searching by "+ locator);
		WebElement navLink = driver.findElement(By.xpath(locator));
		System.out.println("Searching"+ navLink.getText());
		return navLink;
	}

	public static WebElement getFilter(String filterName) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String locator = "//img[@alt, '"+filterName+"')]";
		System.out.println("Searching by "+ locator);
		WebElement filterCheckBox = driver.findElement(By.xpath(locator));
		return filterCheckBox;
	}

}
