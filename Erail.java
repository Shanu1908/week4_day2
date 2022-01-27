package week4day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

		
	public static void main(String[] args) throws InterruptedException {
					
						WebDriverManager.chromedriver().setup();
						ChromeDriver driver = new ChromeDriver();
						driver.get("https://erail.in/");
						driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	
		WebElement from = driver.findElement(By.id("txtStationFrom"));
	from.clear();
	from.sendKeys("MS");
	Thread.sleep(500);
	from.sendKeys(Keys.TAB);
	
//	clear and type in the destination station
	
	WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
	to.clear();
	to.sendKeys("DLI");
	to.sendKeys(Keys.TAB);
	

	
//	Find all the train names using xpath and store it in a list
	int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
	List<String> listN= new ArrayList<String>();
	
	for(int i=1;i<=rowCount;i++) {
		String trainN=driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i +"]/td[2]/a")).getText();
		listN.add(trainN);
	}
	System.out.println(listN);
	
	//Use Java Collections sort to sort it and then print it
	Collections.sort(listN);
	System.out.println(listN);
}

}
