package tests;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.ScreenCapture;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import core.utils.GetProperty;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import core.utils.TakeScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public WebDriver driver = null;
    GetProperty property = new GetProperty();

    @BeforeClass
    public void setUp() throws Exception {
          try {

          String type = property.getConfProperties("BROWSER");
          ChromeOptions options = new ChromeOptions();

            if (type.equals("CHROME")) {
                //inicializamos chrome
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
                driver = new ChromeDriver(options);
                driver.get(property.getConfProperties("URL"));
                driver.manage().window().maximize();

            }else if(type.equals("ANDROID")){
                //Inicializamos android
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
                capabilities.setCapability(MobileCapabilityType.UDID, "123456789ABCDEF");
                capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "gmail-2023-10.apk");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.gm");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.gm.ConversationListActivityGmail");

                URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
                AndroidDriver<MobileElement> driver = new AndroidDriver<>(appiumServerURL, capabilities);
            }
        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }

    @AfterClass
    public void after() {
        try{
           driver.quit();

        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }
}