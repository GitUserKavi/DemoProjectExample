package a_loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BothCorrect {

	@Test
	public void loginwithCorrectUserNameANDPasword() {

		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\WebDrivers\\Chrome_Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// correct username = Admin  
		// correct password = admin123
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		
		// correct password = admin123
		
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("admin123");
		
		//btnLogin
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		driver.quit();
	}


}
