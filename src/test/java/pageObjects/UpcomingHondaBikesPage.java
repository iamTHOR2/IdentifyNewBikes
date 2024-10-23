package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import factory.BaseClass;
import utilities.DataWriter;

public class UpcomingHondaBikesPage extends BasePage{
	public Actions action;
	public Select select;
	public String bikesDetails;
	public String priceString;
	public double price;
	public String bikes;
	public List<String> nameList = new ArrayList<String>();
	public List<String> dateList = new ArrayList<String>();
	public List<String> priceList = new ArrayList<String>();
	public Properties p;
	
	//Constructor
	public UpcomingHondaBikesPage(WebDriver driver){
		super(driver);
		action=new Actions(driver);
	}
	
	//Locators
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	WebElement newBikes;
	
	@FindBy(xpath = "//span[contains(text(),'Upcoming Bikes')]")
	WebElement upcomingBikes;
	
	@FindBy(id = "makeId")
	WebElement selectHonda;
	
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement viewMore;
	
	@FindBy(xpath = "//*[@id='modelList']/li")
	List<WebElement> BikesList;
	
	
	
	//Action Methods
	//To Click on NewBikes in menu
	public void navigateToNewBikes() {
		action.moveToElement(newBikes).build().perform();
	}
	
	//To select upcoming bikes 
	public void navigateToUpcomingBikes() {
		upcomingBikes.click();
	}
	
	//To select honda in Manufacturers
	
	public void selectHonda(String text) {
		select=new Select(selectHonda);
		BaseClass.clickElement(selectHonda);
		select.selectByVisibleText(text);
	}
	
	
	public void viewMore() {
		BaseClass.scrollToElement(viewMore);
		BaseClass.clickElement(viewMore);
	}
	
	//To Print all the bikes below 4lakhs with name and expected launch date
	
	public void bikesListUnder4Lac() {
		try {
			p=BaseClass.getProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(WebElement element:BikesList) {
			bikesDetails=element.getText();
			List<String> bikeModels = new ArrayList<String>();
			for(String model : bikesDetails.split("\n")) {
				if(!model.isEmpty()) {
			        bikeModels.add(model);
			    }
		    }
			if(!bikeModels.isEmpty()) {
		        bikeModels.remove(bikeModels.size() - 1);
		    }
			if(!bikeModels.isEmpty()) {
				// Extract the price from the second element of the list
				    for (String model : bikeModels) {
				        if (model.contains("Rs. ")) {
				        	priceString = model.replace("Rs. ", "").replace(",", "");
				        	if(priceString.contains("Lakh")) {
				        		price = Double.parseDouble(priceString.replace(" Lakh", "")) * 100000;
				        	} else {
				        		price = Double.parseDouble(priceString);
				        	}
				        	// Check if the price is less than 4 lakhs
				        	if(price < Double.parseDouble(p.getProperty("price"))) {
				        		System.out.println(bikeModels.toString());
				        		for (int i = 0; i < bikeModels.size(); i++) {
				        			bikes = bikeModels.get(i);
				        			if (bikes.contains(p.getProperty("bikeName"))) {
				        				nameList.add(bikes);
				        			}
				        			if (bikes.contains("Rs. ")) {
				        				priceList.add(bikes.substring(bikes.indexOf("Rs. ")));
				        			}
				        			if (bikes.contains("Launch")) {
				        				dateList.add(bikes.replaceAll("Expected Launch : |Expected Launch Date : ", ""));
				        			}
				        		}
				        	}
				        }
				    }
				 }
			}
	}
	
	//To store all the data in excel report 
	
	public void printBikeDetails() {
	    List<String> headers = Arrays.asList("Bike Name", "Price", "Expected Launch Date");

	    System.out.println("Bike Name List: " + nameList);
	    try {
	        DataWriter.putData(nameList, 0, "UpcomingBikes", headers);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Price List: " + priceList);
	    try {
	        DataWriter.putData(priceList, 1, "UpcomingBikes", headers);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Expected Launch Date List: " + dateList);
	    try {
	        DataWriter.putData(dateList, 2, "UpcomingBikes", headers);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
