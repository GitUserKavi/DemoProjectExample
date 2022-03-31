package d_loginUsingDataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
	
	
String [][] data =	{
		{"Admin", "admin123"},
		{"Admin", "dummy"},
		{"dummy", "admin123"},
		{"dummy", "abctests"}
	};
	
	
	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() {
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void AuthendicationCheck(String username, String password) {

		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\WebDrivers\\Chrome_Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(username);
		
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		driver.quit();
	}


}
