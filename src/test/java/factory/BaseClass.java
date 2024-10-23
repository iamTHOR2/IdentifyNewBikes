package factory;
import java.net.URL;
import java.time.Duration;
import java.io.FileReader;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	static WebDriver driver;
    static Properties p;
    static Logger logger;
    public static WebDriver initilizeBrowser() throws IOException
	{
		
    	if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{ 
		DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
    	 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 
		 return driver;
		 
	}
    
    public static WebDriver getDriver() {
			return driver;
		}
    
    
    public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        p=new Properties();
		p.load(file);
		return p;
	}
  
    //To scroll to a particular element by using the javascript
    public static void scrollToElement(WebElement element) {
   	 JavascriptExecutor j = (JavascriptExecutor) getDriver();
   	 j.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    //To click the element by using the javascript
    public static void clickElement(WebElement element) {
   	 JavascriptExecutor j = (JavascriptExecutor) getDriver();
   	 j.executeScript("arguments[0].click();", element);
    }
    
    //To generate the random string 
    public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
    //Explicitly Wait method
    public static void waitMethod(WebElement element) {
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(70));
		mywait.until(ExpectedConditions.visibilityOf(element));
	}
  
	}


