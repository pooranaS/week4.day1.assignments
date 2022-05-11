package week4.day1.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		WebElement table=driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Set<String> colSet = new HashSet<String>();
		List<String> colList = new ArrayList<String>();
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			//print security name column alone
			
			System.out.println("Security name:"+cols.get(2).getText());
			colSet.add(cols.get(2).getText());
			colList.add(cols.get(2).getText());
			
		}
			// To check whether duplicate value is present in securityNames column
			// if both size are same then print below statement
			if(colSet.size()==colList.size())
			{
				System.out.println("Duplicate values not available in SecurityNames column");
			}
			else
			{
				System.out.println("Duplicate values are available in SecurityNames column");
			}
		
	}

}
