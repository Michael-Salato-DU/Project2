package behaviortests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Project2Main;

public class Project2StepImplementation {

	static {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	static ChromeDriver driver = new ChromeDriver();
	static Project2Main project2Main = new Project2Main(driver);
	
	
	@Given("^: I am on the Home Page$")
	public void i_am_on_the_Home_Page() throws Throwable {
	    driver.get("http://ec2-18-220-128-186.us-east-2.compute.amazonaws.com:4200");
	}
	
	@Given("^: I have selected the Login button$")
	public void i_have_selected_the_Login_button() throws Throwable {
		project2Main.getLoginButton().click();
	}

	@When("^: I enter my \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_my_and(String arg1, String arg2) throws Throwable {
	    project2Main.getUsernameField().sendKeys(arg1);
	    project2Main.getPasswordField().sendKeys(arg2);
	    project2Main.getConfirmLogin().click();
	}

	@Then("^: I am logged on$")
	public void i_am_logged_on() throws Throwable {
	    assertEquals(project2Main.getResponse(), "You have logged on");
	    throw new PendingException();
	}

	@Then("^: I am not logged on$")
	public void i_am_not_logged_on() throws Throwable {
		assertEquals(project2Main.getResponse(), "Unsuccessful Logon Attempt");
	    throw new PendingException();
	}

	@When("^: I click on Reserve a Room$")
	public void i_click_on_Reserve_a_Room() throws Throwable {
	    throw new PendingException();
	}

	@Then("^: I see a list of rooms available$")
	public void i_see_a_list_of_rooms_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^: I have selected Register$")
	public void i_have_selected_Register() throws Throwable {
	    project2Main.getRegisterButton();
	    throw new PendingException();
	}

	@When("^: I enter a duplicate <\"([^\"]*)\">$")
	public void i_enter_a_duplicate(String arg1) throws Throwable {
	    project2Main.getUsernameField().sendKeys(arg1);
	    throw new PendingException();
	}

	@Then("^: I receive a duplicate usernme error$")
	public void i_receive_a_duplicate_usernme_error() throws Throwable {
		assertEquals(project2Main.getResponse(), "Failed to Register");
	    throw new PendingException();
	}

	@Given("^: I have searched for a room\\.$")
	public void i_have_searched_for_a_room() throws Throwable {
	    
	    throw new PendingException();
	}

	@Given("^: A room is available$")
	public void a_room_is_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^: I select a room to reserve$")
	public void i_select_a_room_to_reserve() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^: It is reserved$")
	public void it_is_reserved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^: I enter \"([^\"]*)\", <\"([^\"]*)\">, <\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\">, <\"([^\"]*)\">, \"([^\"]*)\"$")
	public void i_enter(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
	    project2Main.getFirstNameField().sendKeys(arg1);
	    project2Main.getLastNameField().sendKeys(arg2);
	    project2Main.getEmailField().sendKeys(arg3);
	    project2Main.getUsernameField().sendKeys(arg4);
	    project2Main.getPasswordField().sendKeys(arg5);
	    project2Main.getAddressField().sendKeys(arg6);
	    project2Main.getPhoneField().sendKeys(arg7);
	    project2Main.getConfirmRegister().click();
	}

	@Then("^: I successfully register$")
	public void i_successfully_register() throws Throwable {
	    assertEquals(project2Main.getResponse(), "You have registered");
	    throw new PendingException();
	}

	@Given("^: I am on the Reservation Confirmation Page$")
	public void i_am_on_the_Reservation_Confirmation_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^: I enter my <\"([^\"]*)\">, <\"([^\"]*)\">, <\"([^\"]*)\">$")
	public void i_enter_my(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^: I reserve a room$")
	public void i_reserve_a_room() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
	//code from www.techbeamers.com/handle-date-time-picker-control-using-webdriver
	public void SelectDayFromMultiDateCalendar(String day)
			throws InterruptedException {

		// We are using a special XPath style to select the day of current
		// month.
		// It will ignore the previous or next month day and pick the correct
		// one.
		By calendarXpath = By
				.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
						+ day + "']");
		driver.findElement(calendarXpath).click();
	}


}
