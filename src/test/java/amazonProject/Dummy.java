package amazonProject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dummy {
	
	

		public static void main(String[] args) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\Paranthaman\\eclipse-workspace\\amazon\\exe\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().window().maximize();
			//WebDriverWait wait = new WebDriverWait(driver, 30);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");

			WebElement bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));

			WebElement drop1 = driver.findElement(By.xpath("//li[@class='placeholder']"));
			
			WebElement sales = driver.findElement(By.xpath("//a[text()=' SALES ']"));

			WebElement drop2 = driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[2]"));
			
			WebElement amnt = driver.findElement(By.xpath("//a[text()=' 5000']"));

			WebElement drop3 = driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[1]"));
			
			WebElement drop4 = driver.findElement(By.xpath("//li[@class='placeholder']"));

			Actions act = new Actions(driver);

			act.dragAndDrop(bank, drop1).build().perform();

			act.dragAndDrop(sales, drop2).build().perform();

			act.dragAndDrop(amnt, drop3).build().perform();

			act.dragAndDrop(amnt, drop4).build().perform();
			
			WebElement text;

			
			

		}

	}

