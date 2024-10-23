package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import utilities.DataWriter;

public class LoginPage extends BasePage{
	public String error;
	public List<String> emailList;
	public List<String> errorList=new ArrayList<String>();

	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	
	
	//Locators
		@FindBy(xpath = "//*[@id='des_lIcon']")
		WebElement LogIn;
		
		@FindBy(xpath = "//span[@class='lgn-sp s ggle']")
		WebElement GoogleBtn;
		
		@FindBy(xpath = "//input[@type='email']")
		WebElement Email;
		
		@FindBy(xpath = "//*[@id='identifierNext']/div/button/span")
		WebElement NextBtn;
		
		@FindBy(xpath = "//div[@class='Ekjuhf Jj6Lae']")
		WebElement errorMsg;
		
		
		//Action Methods
		//To click on Login button
		public void clickLogInButton() {
			LogIn.click();
			BaseClass.waitMethod(GoogleBtn);
			
		}
		//To click on Google Button
		public void clickGoogleBtn() {
			GoogleBtn.click();
		}
		//Switch to child Window
		public void switchTowindow() {
		Set<String> windowids=driver.getWindowHandles();
		List<String> windowid=new ArrayList<String>(windowids);
		String childid=windowid.get(1);
		driver.switchTo().window(childid);
		}
		//To enter invalid login details
		public void setEmail() throws InterruptedException {
			emailList = new ArrayList<>();
			emailList.add(BaseClass.randomeString() + "@gmail.com");
			emailList.add(BaseClass.randomeString()+"@xyz");
			emailList.add("");
			for(String email:emailList) {
				System.out.println(email);
				Email.sendKeys(email);
				BaseClass.waitMethod(NextBtn);
				NextBtn.click();
				BaseClass.waitMethod(errorMsg);
				error=errorMsg.getText();
				errorList.add(error);
				System.out.println(error);
				Email.clear();
			}
			
		}
		
		//To store all the data into excel data
		public void errorMessage() {
			List<String> headers = Arrays.asList("EmailIds", "Error Message");
		    try {
		        DataWriter.putData(emailList, 0, "Account Details", headers);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    try {
		        DataWriter.putData(errorList, 1, "Account Details", headers);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    
			System.out.println(errorList);
		}
}
