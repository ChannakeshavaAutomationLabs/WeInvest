/* 
 * @Aauthor: Channakeshava Puttaswamy
 */
package com.qa.testLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Base_Lib {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;

	public Base_Lib(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/testLibraries"
					+ "/config.properties");			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");	
			driver = new ChromeDriver(options);
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		pageWaitSync();
	}
	
	//Method for page load sync
	public static void pageWaitSync() {
		driver.manage().timeouts().pageLoadTimeout(Utils_Lib.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils_Lib.IMPLICIT_WAIT, TimeUnit.SECONDS);		
	}

	//Method for Slider settings
    public static void dragSlider(WebElement slider, int xOffset, int yOffset) throws Exception {
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.clickAndHold(slider)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build();
        action.perform();
        pageWaitSync();
    }	
}
