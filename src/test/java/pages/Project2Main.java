package pages;

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
		return driver.findElement(By.id("mainPageLogin"));	
	}

	public WebElement getRegisterButton()
	{ 
		return driver.findElement(By.id("mainPageRegister")); 
	}
	
	public WebElement getStartDate() 
	{
		return driver.findElement(By.id("arrivaleDate"));
	}
	
	public WebElement getEndDate()
	{
		return driver.findElement(By.id("departureDate"));
	}
	
	public WebElement getUsernameField()
	{
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getPasswordField()
	{
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getConfirmLogin()
	{
		return driver.findElement(By.id("modalLogin"));
	}
	
	public WebElement getConfirmRegister()
	{
		return driver.findElement(By.id(""));
	}
	
	public WebElement getFirstNameField()
	{
		return driver.findElement(By.id("first_name"));
	}
	
	public WebElement getLastNameField()
	{
		return driver.findElement(By.id("last_name"));
	}
	
	public WebElement getEmailField()
	{
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPhoneField()
	{
		return driver.findElement(By.id("phone"));
	}
	
	public WebElement getAddressField()
	{
		return driver.findElement(By.id("address"));
	}
}
