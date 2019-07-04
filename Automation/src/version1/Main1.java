package version1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Main1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		 Properties prop=new Properties();
		 FileInputStream ip= new FileInputStream("C:\\Users\\siddh\\git\\NavisSubtask\\Automation\\src\\version1\\config.properties");
		prop.load(ip);
		
		Login L=new Login();
		L.OpenBrwsr(driver);
		L.Login(prop.getProperty("username"), prop.getProperty("Password"));
	//	L.filtrBord("Siddharth");
		L.SearchfrDfct(prop.getProperty("DefectId"));
		L.scrolinnrPge1();
	//	L.scrnsht();
		L.sclrInnrPge();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
