package week4day2;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Selectable {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();

			ChromeDriver driver = new ChromeDriver();

			driver.get("https://jqueryui.com/selectable/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			Actions builder =new Actions(driver);
			driver.switchTo().frame(0);
			
			WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
			WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
			WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
			WebElement item8 = driver.findElement(By.xpath("//li[text()='Item 8']"));
			
			builder.keyDown(Keys.CONTROL).click(item2)
				.click(item4)
				.click(item6)
				.click(item8)
				.keyUp(Keys.CONTROL)
				.perform();

		}

}
