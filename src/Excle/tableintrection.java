package Excle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tableintrection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PratiksMishra\\Desktop\\Eclips\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		int No_of_rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
		for(int i=2 ; i<=No_of_rows;i++)
		{
			for(int j=1 ; j<=3 ;j++) {
			System.out.print(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[" + i + "]/td["+j +"]")).getText() + "\t");
			//*[@id='customers']/tbody/tr[i]/td[1]
			}
			System.out.println();
		}
	}

}
