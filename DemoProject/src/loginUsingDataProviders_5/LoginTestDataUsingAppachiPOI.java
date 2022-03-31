package loginUsingDataProviders_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTestDataUsingAppachiPOI {
	
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passwordList = new ArrayList<String>();
	
	public void readExcel() throws IOException   {
		FileInputStream excel = new FileInputStream("C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\testdata\\tdata1.xls");

		Workbook workbook1 = new HSSFWorkbook(excel);

		Sheet sheet= workbook1.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while(rowIterator.hasNext()) {
			Row rowvalue = rowIterator.next();

			Iterator<Cell> columnIterator = rowvalue.iterator();
			int i=2;
			while(columnIterator.hasNext()) {
				if(i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());
				}else {
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
		}
		workbook1.close();
	}

	
	public void login(String uname, String pword) {
		System.setProperty("webdriver.chrome.driver", 				
				"C:\\Users\\sathy\\OneDrive\\Desktop\\Kavitha\\Selenium\\WebDrivers\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(uname);

		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(pword);

		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		
		driver.quit();

	}
	
	public void executeTest() {
		for(int i=0; i< userNameList.size(); i++) {
			login(userNameList.get(i), passwordList.get(i));
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		LoginTestDataUsingAppachiPOI usingPoi = new LoginTestDataUsingAppachiPOI();
		usingPoi.readExcel();
		System.out.println("UserName List "+ userNameList);
		System.out.println("Password List "+ passwordList);
		usingPoi.executeTest();
	}

}
