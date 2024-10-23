package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{
	WebDriver driver;
	Properties p;
    

	@Before
   public void setup() throws IOException
   {
   	driver=BaseClass.initilizeBrowser();
   	    	
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().window().maximize();
   
   			
	}
		
   
   @After
   public void tearDown(Scenario scenario) {
      driver.quit();
      
   }

   @AfterStep
   public void addScreenshot(Scenario scenario) {
       TakesScreenshot ts = (TakesScreenshot) driver;
       byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

       // Get the step name
       String stepName = scenario.getName();
       stepName = stepName.replaceAll("[^a-zA-Z0-9]", "");

       // Save the screenshot with the step name
       if (scenario.isFailed()) {
           scenario.attach(screenshot, "image/png", stepName + "_Failure");
           ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Test Fail");
       }else {
           scenario.attach(screenshot,"image/png", stepName + "_Success");
           ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "Test PASS");
       }
   }

}
