package week4.day1.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Progress_LeafTapPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		
		WebElement table = driver.findElement(By.xpath("//table"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		List<WebElement> cols = rows.get(2).findElements(By.tagName("td"));
		
		System.out.println("Rows count:"+rows.size());
		
		System.out.println("Columns count in second row:"+cols.size());
		
		// getting the progress value of 'Learn to interact with Elements'

				//Assigning string to variable to check
				String rowvalue = "Learn to interact ";
			
				//Finding column values and assigning to webelement 
				List<WebElement> progressValues = driver.findElements(By.xpath("//font[contains(text(),'" + rowvalue + "')]/following::font[1]"));
				
				System.out.println("The Progress value of Learn to interact with Elements are : ");
				
				//iterating to each column value
				for (WebElement each : progressValues) {
					
					//getting text of each value
					System.out.println(each.getText());
					
				}
				// checking VitalTask checkbox for the least completed progress

				// Declaring Integer List to store Int values
				List<Integer> list = new ArrayList<Integer>();

				// getting all Progress column values and storing in list
				List<WebElement> progress = driver.findElements(By.xpath("//td[2]"));

				// Iterating through each column value
				for (WebElement eachCol : progress) {

					// getting each column value and storing as String
					String ColValue = eachCol.getText();

					// replacing all % symbol
					String colReplace = ColValue.replaceAll("%", "");

					// Converting String to Integer
					int IntCol = Integer.parseInt(colReplace);

					// adding integer values to Integer List
					list.add(IntCol);
				}

				// Printing Integer values for reference
				System.out.println("The List : " + list);

				// finding minimum values from the list
				Integer minValue = Collections.min(list);

				// Printing minimum value for reference
				System.out.println("The Minimum Value is  : " + minValue);

				// Converting Integer to String to use in findElement method
				String strValue = Integer.toString(minValue);

				System.out.println("String value:"+strValue);
				// finding element and clicking
				driver.findElement(By.xpath("//font[contains(text(),'" + strValue + "')]/following::input")).click();

			}
	}


