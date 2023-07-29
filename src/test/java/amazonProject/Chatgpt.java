package amazonProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Chatgpt {
    @Test
    public void amazonCartTest() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[1]"))
              .sendKeys("Mobiles");

        // Search
        driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[2]")).click();
        // First product text
        String text = driver.findElement(By.xpath("(//span[@class='a-price'])[1]")).getText();
        System.out.println(text);

        // First product select & add to cart
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // Switch to the new window
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> windowHandlesList = new ArrayList<>(windowHandles);
        System.out.println(windowHandlesList.get(0));
        System.out.println(windowHandlesList.get(1));
        driver.switchTo().window(windowHandlesList.get(1));

        // Add to cart
        driver.findElement(By.xpath("//input[@class='a-button-input attach-dss-atc']")).click();

        // Go to the cart
        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

        // Product checking for same
        String text1 = driver.findElement(By.className("sc-badge-price-to-pay")).getText();
        System.out.println(text1);

        if (text.equals(text1)) {
            System.out.println("Both are the same product");
        } else {
            System.out.println("Both are not the same product");
        }

        // Quit the driver after the test is finished
        driver.quit();
    }
}
