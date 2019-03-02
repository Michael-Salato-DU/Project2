package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project2Main {
	
	public static WebDriver driver;
	
	public Project2Main(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public WebElement getLoginButton()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("mainPageLogin"));	
	}

	public WebElement getRegisterButton()
	{ 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("mainPageRegister")); 
	}
	
	public WebElement getStartDate() 
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("arrivalDate"));
	}
	
	public WebElement getEndDate()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("departureDate"));
	}
	
	public WebElement getUsernameField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getPasswordField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getConfirmLogin()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("modalLogin"));
	}
	
	public WebElement getConfirmRegister()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("modalRegister"));
	}
	
	public WebElement getFirstNameField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("first_name"));
	}
	
	public WebElement getLastNameField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("last_name"));
	}
	
	public WebElement getEmailField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPhoneField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("phone"));
	}
	
	public WebElement getAddressField()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("address"));
	}
	
	public WebElement getResponse()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("response"));
	}
	
	public WebElement getRegisterUsername()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("rusername"));
	}
	
	public WebElement getRegisterPassword()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("rpassword"));
	}
	
	public WebElement getSeeAvailableRooms()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.id("seeAvailableRoomsBtn"));
	}
}
