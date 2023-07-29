package amazonProject;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		//driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys("9566905970");
		//driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		//driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Kelston@007");
		//driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@class='a-button a-button-span12 a-button-primary cvf-widget-btn cvf-widget-btn-verify']")).click();
		driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[1]")).sendKeys("Mobiles");
		driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).click();
		Set<String> s  =driver.getWindowHandles();
		ArrayList ar = new ArrayList(s);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		driver.switchTo().window((String)ar.get(1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		//span[@class='a-button a-button-span12 a-button-primary cvf-widget-btn cvf-widget-btn-verify']
		//driver.quit();
		
	}

}

//input[@id='twotabsearchtextbox']
//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']
//input[@class='a-button-input']
//input[@id='ap_password']
//(//input[@class='a-button-input'])[1]