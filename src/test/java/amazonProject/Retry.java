package amazonProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Retry {
@Test
public void amazonCartTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// login
				driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[1]")).sendKeys("Mobiles");

				// search
				driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[2]")).click();
				// First product text
				String text = driver.findElement(By.xpath("(//span[@class='a-price'])[1]"))
						.getText();
				System.out.println(text);
				// first product select & add to cart
				driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

				// nest window command
				Set<String> s = driver.getWindowHandles();
				ArrayList ar = new ArrayList(s);
				System.out.println(ar.get(0));
				System.out.println(ar.get(1));
				driver.switchTo().window((String) ar.get(1));
				driver.findElement(By.xpath("//input[@class='a-button-input attach-dss-atc']")).click();
				// cart click
				// Thread.sleep(5000);
				
				driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

				// Product checking for same
				String text1 = driver.findElement(By.className("sc-badge-price-to-pay")).getText();
				System.out.println(text1);

				if (text.equals(text1)) {

					System.out.println("Both are same product");
				} else {
					System.out.println("Both are not same product");
				}

			}
	}


