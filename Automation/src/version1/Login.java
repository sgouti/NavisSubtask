package version1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import jxl.write.DateFormat;

public class Login {
	 WebDriver driver;
	 Properties prop=new Properties();
	public void OpenBrwsr(WebDriver driver) throws InterruptedException
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	public void Login(String User,String pass) throws InterruptedException, IOException
	{
		 
		 FileInputStream ip= new FileInputStream("C:\\Users\\siddharth\\eclipse-workspace\\Automation\\src\\version1\\config.properties");
		 prop.load(ip);
		 
		driver.get("https://www15.v1host.com/Greenway/Account.mvc/LogIn");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("xpthusrnme"))).sendKeys(User);
		driver.findElement(By.xpath(prop.getProperty("xpthpssw"))).sendKeys(pass);
		driver.findElement(By.xpath(prop.getProperty("xpthlgnbtn"))).click();
		Thread.sleep(5000);
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//WebElement Teamtab=driver.findElement(By.xpath(prop.getProperty("XpthfrTeamTab")));
		//wait.until(ExpectedConditions.visibilityOf(Teamtab));
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty("XpthfrTeamTab"))));
		WebElement Teamtab=driver.findElement(By.xpath("//span[@class='caption'][contains(text(),'Team')]"));
	    Actions action=new Actions(driver);
	    action.moveToElement(Teamtab).perform();
	    driver.findElement(By.xpath("//div[@class='meganav ProcessMenu_Planning_Team']//span[@class='title'][contains(text(),'SEHS- PDT')]")).click();
	    Thread.sleep(3000);
	}

	public void SearchfrDfct(String DfctId) throws InterruptedException, IOException
	{
		driver.findElement(By.xpath(prop.getProperty("xpthDfctSrchfld"))).sendKeys(DfctId);
		driver.findElement(By.xpath(prop.getProperty("xpthSrchsggesn"))).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
	//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty("xpthFrPrjcttitle"))));
		Thread.sleep(3000);
		
	}
	public void scrolinnrPge() throws InterruptedException
	{
		EventFiringWebDriver scrlPge=new EventFiringWebDriver(driver);
		WebElement s=driver.findElement(By.xpath("//label[contains(text(),'Resolution Details')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",s);
		Thread.sleep(5000);
		WebElement s1=driver.findElement(By.xpath("//h1[contains(text(),'Attachments')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",s1);
	}
	public void scrnsht() throws IOException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy-hh_mm a");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 String path="D:\\sid"+ date1 + ".png";
		 System.out.println(path);
		EventFiringWebDriver scrnsht=new EventFiringWebDriver(driver);
		File srcfle=scrnsht.getScreenshotAs(OutputType.FILE);
		Files.copy(srcfle, new File(path));
	}

	public void filtrBord(String EmplNme) throws InterruptedException
	{	//WebDriverWait wait=new WebDriverWait(driver,15);
		Thread.sleep(5000);
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='selected-filter-item type-AssetLookup']")));
		List<WebElement> Fltr = driver.findElements(By.xpath("//div[@class='selected-filter-item type-AssetLookup']"));
		if(Fltr.size()!=0)
		{
			String name=driver.findElement(By.xpath("//span[@class='pill']")).getAttribute("title");
			if(name.equalsIgnoreCase(EmplNme))
			{
				return ;
			}
			else
			{
				driver.findElement(By.xpath("//a[@class='clear-item']")).click();
			//	WebDriverWait wait=new WebDriverWait(driver,10);
				//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Click or start typing']")));
				Thread.sleep(3000);
					if(!driver.findElement(By.xpath("//input[@placeholder='Click or start typing']")).isEnabled())
						{
							Thread.sleep(3000);
						}
				driver.findElement(By.xpath("//input[@placeholder='Click or start typing']")).click();
				Thread.sleep(2000);
				WebElement drpdown= driver.findElement(By.xpath("//div[contains(@data-component,'ScrollableContainer')]"));
				//Select sl=new Select(drpdown);
				//sl.selectByVisibleText("Owner");
				driver.findElement(By.xpath("//span[contains(text(),'Owner')]")).click();
				driver.findElement(By.xpath("//input[@placeholder='Click or start typing']")).sendKeys(EmplNme);
				driver.findElement(By.xpath("//dd[@class='search-result-item suggested Member compact highlight']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='button'][text()='Apply']")).click();
				Thread.sleep(3000);
			}
			
		}

		else
		{
			driver.findElement(By.xpath("//input[@placeholder='Click or start typing']")).click();
			Thread.sleep(3000);
			WebElement drpdown= driver.findElement(By.xpath("//div[contains(@data-component,'ScrollableContainer')]"));
			//Select sl=new Select(drpdown);
			//sl.selectByVisibleText("Owner");
			driver.findElement(By.xpath("//span[contains(text(),'Owner')]")).click();
			//input[@placeholder='Click or start typing']
			driver.findElement(By.xpath("//input[@placeholder='Click or start typing']")).sendKeys(EmplNme);
			//dd[@class='search-result-item suggested Member compact highlight']
			Thread.sleep(3000);
			driver.findElement(By.xpath("//dd[@class='search-result-item suggested Member compact highlight']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='button'][text()='Apply']")).click();
			Thread.sleep(3000);
		}
		
	}
	
	
	public void sclrInnrPge()
	{
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		for(String s:handles)
		{
			System.out.println(s);
		}
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

		// Now you are in the popup window, perform necessary actions here

		driver.switchTo().window(parentWindowHandler);
	}
	
}