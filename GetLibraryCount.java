package week4.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLibraryCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		
		WebElement table = driver.findElement(By.xpath("//table"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++)
		{
		List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		for(int j=0;j<cols.size();j++)
		{
			System.out.println("Column:"+cols.get(j).getText());
		}
		
		}
		
		
		
	
	}

}
