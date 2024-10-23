package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UsedCarsPage;

public class UsedCars {
	WebDriver driver;
	UsedCarsPage up=new UsedCarsPage(BaseClass.getDriver());

	@Given("the user has the car sales website open in their browser")
	public void the_user_has_the_car_sales_website_open_in_their_browser() {
		BaseClass.getDriver();
	}


	@When("the user hovers over the Used Cars link")
	public void the_user_hovers_over_the_used_cars_link() {
		up.navigateToUsedCars();
	} 

	@When("the user selects Chennai from the dropdown")
	public void the_user_selects_chennai_from_the_dropdown() {
		up.navigateToChennai();
	}

	@When("the user scrolls down to the list of popular models")
	public void the_user_scrolls_down_to_the_list_of_popular_models() {
		up.scrollToPopularModels();
	}

	@Then("the user should extract all the popular models in a List")
	public void the_user_should_extract_all_the_popular_models_in_a_list(){
		up.popularModelsList();
	}

	@Then("the user displays the same in the console")
	public void the_user_displays_the_same_in_the_console() {
		up.displaypopularModelsList();
	}
	

}
