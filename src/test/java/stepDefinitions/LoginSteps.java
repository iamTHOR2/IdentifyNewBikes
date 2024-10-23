package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	WebDriver driver;
	LoginPage lg=new LoginPage(BaseClass.getDriver());
	
	@When("the user clicks on the login icon")
	public void the_user_clicks_on_the_login_icon() {
		lg.clickLogInButton();
	}

	@When("the user clicks on the Google button")
	public void the_user_clicks_on_the_google_button() {
		lg.clickGoogleBtn();
	}

	@When("the user switches to the new window")
	public void the_user_switches_to_the_new_window() {
		lg.switchTowindow();
	}

	@When("the user enters the emailId and clicks on the Next button")
	public void the_user_enters_the_email_id_and_clicks_on_the_next_button() {
		try {
			lg.setEmail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("the system should display an error message and print it in the console")
	public void the_system_should_display_an_error_message_and_print_it_in_the_console() {
		lg.errorMessage();
	}

}
