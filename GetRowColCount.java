package week4.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRowColCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		
		WebElement table = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		List<WebElement> cols = rows.get(2).findElements(By.tagName("td"));
		
		System.out.println("Rows count:"+rows.size());
		
		System.out.println("Columns count in second row:"+cols.size());
	}

}
