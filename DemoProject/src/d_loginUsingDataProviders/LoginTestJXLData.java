package d_loginUsingDataProviders;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTestJXLData {

	/*
	 * Keeping the data in the excel sheet is one of the best ways to send data to
	 * our test cases. Reading data from excel is one of the complex operations. But
	 * with the help of libraries like Apache POI or JXL, we can do this with ease.
	 * 
	 * NOTE: 99% of the data-driven testing follows this approach and this is the
	 * best and industry level practice. So master this video.
	 * 
	 * 1. How to read test data from Excel? 
	 * 2. Sending test data to data providers from Excel 
	 * 3. JXL library 
	 * 4. Iterating rows and columns in Excel using JXL library.
	 * JXL JAR Download link: https://bit.ly/2CRaw7u
	 */	


	WebDriver driver;	
	String [][] data=null;

	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException  {

		data=getExcelData();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException  {

		FileInputStream excel = new FileInputStream(
				"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\testdata\\tdata.xls");
		Workbook workbook = Workbook.getWorkbook(excel);

		Sheet sheet = workbook.getSheet("Sheet1");
		// Or use Sheet sheet = workbook.getSheet(0);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testdata[][] = new String[rowCount-1][columnCount];

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				testdata[i-1][j]= sheet.getCell(j, i).getContents();
			}
		}

		return testdata;
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\WebDrivers\\Chrome_Driver\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(dataProvider = "loginData")
	public void loginTests(String username, String password) {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(username);

		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(password);

		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();

	}


}
