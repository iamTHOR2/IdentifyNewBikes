package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import utilities.DataWriter;

public class UsedCarsPage extends BasePage{
	
	public Actions action;
	public String name;
	public List<String> texts = new ArrayList<String>();
	
	//Constructor
	public UsedCarsPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}
	
	//Locators
		@FindBy(xpath = "//a[normalize-space()='Used Cars']")
		WebElement usedCar;
		
		@FindBy(xpath = "//span[contains(text(),'Chennai')]")
		WebElement clickChennai;
		
		@FindBy(xpath = "//*[text()='Popular Models']")
		WebElement popularModels;
	
		
		@FindBy(xpath = "//*[starts-with(@id,'mmvLi')]/label")
		List<WebElement> popularModelList;
		
		@FindBy(xpath = "//input[@name='bycarid']")
		List<WebElement> popularModelListCheckBox;
		
		@FindBy(xpath = "//div[contains(@class,'pl-30')]//a")
		List<WebElement> popularModelName;
		
		@FindBy(xpath = "//*[@id=\"thatsAllFolks\"]")
		WebElement scrollToEnd;
	
		
		
	//Action Methods
	
	//To do actionhover towards the usedcars
		
	public void navigateToUsedCars() {
		action.moveToElement(usedCar).build().perform();
		BaseClass.waitMethod(clickChennai);
	}
	
	//To click on the chennai location
	
	public void navigateToChennai() {
		BaseClass.clickElement(clickChennai);
	}
	
	//to scroll to the popularmodels
	
	public void scrollToPopularModels() {
		BaseClass.scrollToElement(popularModels);
		BaseClass.waitMethod(popularModels);
	}
	
	//Printing all the popularmodels
	public void popularModelsList(){
		
		for(WebElement element:popularModelList) {
			name=element.getText();
			System.out.println(name);
			texts.add(name);
		}
	}
	
	//To store all the data in the excelsheet
	public void displaypopularModelsList()
	{
		 List<String> headers = Arrays.asList("Name of the used cars");
		System.out.println(texts);
		try {
			DataWriter.putData(texts, 0, "UsedCars",headers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
