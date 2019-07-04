package Navvis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {
	WebDriver driver;
	int Storypoint = 0;

	// Login
	By Username = By.id("username");

	By Usernamesubmit = By.id("login-submit");

	By password = By.id("password");

	By submit = By.id("login-submit");

	// Search for Story

	By search = By.xpath(
			"//*[@id=\"navigation-app\"]/div/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/button");

	By searchstory = By.xpath(
			"//*[@id=\"navigation-app\"]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/input");

	// Logout

	By clickOnProfile = By.xpath("//*[@id=\"menu-profile\"]");

	By ClickonLogout = By.xpath("//span[contains(text(),'Log out')]");

	// Subtasklink

	By Moreoption = By.id("opsbar-operations_more");
	By Subtasklink = By.id("create-subtask");
	By SubtaskdrpDwn = By.id("issuetype-field");

	// Subtask popup
	By SummaryTextBox = By.xpath("//*[@id=\"summary\"]");
	By DescriptionTextBox = By.id("description");
	By severity = By.id("customfield_10048");
	By Mediumseverity = By.xpath("//*[@id=\"customfield_10048\"]/option[text()='Medium']");
	By ClickonSubmitbutton = By.id("create-issue-submit");
	By Clickonupdatebutton = By.id("edit-issue-submit");
	// Edit subtask
	By EditSubtasklink = By.id("edit-issue");
	By OriginalEstimate = By.id("timetracking_originalestimate");

	// Navigating Main story
	By ParentStory = By.id("parent_issue_summary");
	By Stroypoint = By.xpath("//*[@id=\"customfield_10026-val\"]");

	public Pages(WebDriver driver)

	{

		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public void LoginJira(String email, String passwrd) throws InterruptedException

	{

		driver.findElement(Username).sendKeys(email);

		// Thread.sleep(2000);

		driver.findElement(Usernamesubmit).click();

		// Thread.sleep(2000);

		driver.findElement(password).sendKeys(passwrd);

		// Thread.sleep(2000);

		driver.findElement(submit).click();

	}

	public void NavigateToStory(String Story) throws InterruptedException

	{

		try {

			driver.findElement(search).click();

			driver.findElement(searchstory).sendKeys(Story);

			// driver.findElement(VerifyStoryID).isDisplayed();

			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).build().perform();
			WebElement Element = driver.findElement(Stroypoint);
			// This will scroll the page till the element is found and get storypoint
			Thread.sleep(3000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			String Storypoints = driver.findElement(Stroypoint).getText();
			// System.out.println(Storypoint);
			Storypoint = Integer.parseInt(Storypoints);
			System.out.println(Storypoint);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in" + Story + "  = " + e);
		}
	}

	public void CreateDevSubtask(String Subtaskname, String SubtaskDiscr, String storypnt) throws InterruptedException

	{

		WebDriverWait wait = new WebDriverWait(driver, 10000);

		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Moreoption));
		element1.click();
		Thread.sleep(1000);
		driver.findElement(Subtasklink).click();
		driver.findElement(SubtaskdrpDwn).clear();

		Actions a = new Actions(driver);
		a.sendKeys("Dev").build().perform();
		a.sendKeys(Keys.TAB).build().perform();

		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SummaryTextBox));
		element3 = wait.until(ExpectedConditions.elementToBeClickable(SummaryTextBox));
		element3.click();
		// Thread.sleep(2000);
		driver.findElement(SummaryTextBox).sendKeys(Subtaskname);
		driver.findElement(DescriptionTextBox).sendKeys(SubtaskDiscr);
		// Thread.sleep(2000);
		driver.findElement(severity).click();
		driver.findElement(Mediumseverity).click();
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(OriginalEstimate));
		element2.clear();
		element2.sendKeys(storypnt);
		driver.findElement(ClickonSubmitbutton).click();
		Thread.sleep(2000);

	}

	public void CreateQaSubtask(String Subtaskname, String Subtaskdsc, String storypnt) throws InterruptedException

	{

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Moreoption));
			element1.click();
			Thread.sleep(1000);
			driver.findElement(Subtasklink).click();
			driver.findElement(SubtaskdrpDwn).clear();

			Actions a = new Actions(driver);
			a.sendKeys("QA").build().perform();
			a.sendKeys(Keys.TAB).build().perform();

			WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SummaryTextBox));
			element3 = wait.until(ExpectedConditions.elementToBeClickable(SummaryTextBox));
			element3.click();
			// Thread.sleep(2000);
			driver.findElement(SummaryTextBox).sendKeys(Subtaskname);
			driver.findElement(DescriptionTextBox).sendKeys(Subtaskdsc);
			// Thread.sleep(2000);
			driver.findElement(severity).click();
			driver.findElement(Mediumseverity).click();
			WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(OriginalEstimate));
			element2.clear();
			element2.sendKeys(storypnt);
			driver.findElement(ClickonSubmitbutton).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in" + Subtaskname + "  = " + e);
		}

	}

	public void SubtaskEstimationHour(String Subtaskname, String Hour) throws InterruptedException {
		// navigate to subtask
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		String subtaskxpath = "(//a[@class='issue-link' and  contains(text()," + "'" + Subtaskname + "') ])[1]";
		By Substacknamelink = By.xpath(subtaskxpath);
		Thread.sleep(2000);
		driver.findElement(Substacknamelink).click();
		Thread.sleep(3000);
		// Edit subtask
		driver.findElement(EditSubtasklink).click();
		Thread.sleep(2000);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(OriginalEstimate));
		element2.click();
		element2.clear();
		element2.sendKeys(Hour);
		// Thread.sleep(1000);
		driver.findElement(Clickonupdatebutton).click();
		Thread.sleep(3000);
		// Navigate to Main story
		// Thread.sleep(2000);
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(ParentStory));
		element3.click();
		Thread.sleep(2000);

	}
	
	public void Logout() throws InterruptedException

	{

		driver.findElement(clickOnProfile).click();

		Thread.sleep(2000);

		driver.findElement(ClickonLogout).click();

	}

}
