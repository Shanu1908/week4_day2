package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/sorttable.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int size = driver.findElements(By.xpath("//table[@id='table_id']//tbody/tr")).size();
		
		List<String> LNS= new ArrayList<String>();
		//LNS - Listnames
		for(int i=1;i<=size;i++) {
			String name=driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+ i + "]/td[2]")).getText();
			LNS.add(name);
		}
		
		Collections.sort(LNS);
		System.out.println(LNS);
		
		//click on name header
		driver.findElement(By.xpath("//table[@id='table_id']//tr/th[2]")).click();
		List<String> LN= new ArrayList<String>();
		for(int i=1;i<=size;i++) {
			String name=driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+ i + "]/td[2]")).getText();
			LN.add(name);
		}
		System.out.println(LN);
		
		if(LNS.equals(LN)) {
			System.out.println("Sorting table is successful");
		}
		else {
			System.out.println("Sorting should be failed");
		}
				

}
}
