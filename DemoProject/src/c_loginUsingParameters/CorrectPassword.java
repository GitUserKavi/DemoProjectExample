package c_loginUsingParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectPassword {

	@Test
	@Parameters({"username", "password"})
	public void loginwithCorrectPassword(String username, String password) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\WebDrivers\\Chrome_Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(username);

		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(password);

		//btnLogin
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		driver.quit();
	}


}
