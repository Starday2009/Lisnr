package Lisnr.Project;

import Lisnr.Project.Pages.*;
import Lisnr.Project.configs.CommonAppium;
import Lisnr.Project.configs.TestListener;
import Lisnr.Project.utility.ApplicationManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class BaseTest {
  public AppiumDriver driver;
  public WebDriverWait wait;
  private String deviceName;
  private String app_path = "/appPoint/Build/Products/Debug-iphonesimulator/";
  private String port;
  private String platformName;
  private String automationName;
  private String platformVersion;

  public CommonAppium commonAppium;
  public RadiusStartPage radiusStartPage;
  public RadiusBroadcastPage broadcastSDKPage;
  public RadiusListenPage listenSDKPage;
  public PointBuyerTransferPage pointBuyerTransferPage;
  public PointSellerPage pointSellerPage;
  public PointStartPage pointStartPage;

//  @BeforeClass(alwaysRun = true)
//  public void setup() throws Exception {

//    commonAppium = new CommonAppium();
//    radiusStartPage = new RadiusStartPage();
//    broadcastSDKPage = new RadiusBroadcastPage();
//    listenSDKPage = new RadiusListenPage();
//    pointBuyerTransferPage = new PointBuyerTransferPage();
//    pointSellerPage = new PointSellerPage();
//    pointStartPage = new PointStartPage();
//    setupRemoteDriver();
//  }

//  public static IOSDriver getDriver() {
//    IOSDriver driver = null;
//    return driver;
//  }

//  private void setupRemoteDriver() throws MalformedURLException {
//    loadProperties();
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    File appDir = new File(System.getProperty("user.dir") + app_path);
//    //    File app_path = new File(appDir, "/iOS-Sample-App.app");
//    File app_path = new File(appDir, "/Point-Sample.app");
//
//    capabilities.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());
//    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
//    capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
//    capabilities.setCapability("automationName", "XCUITest");
//
//    driver = (new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities));
//    wait = (WebDriverWait) new WebDriverWait(driver, 30)
//            .withMessage("Element was not found");
//  }


//  private void loadProperties() {
//    FileInputStream propertiesFIS;
//    Properties properties = new Properties();
//    //    String propertiesFilePath =
//    //        String.format("src/test/resources/properties/%s.properties");
//    try {
//      propertiesFIS = new FileInputStream("src/test/resources/properties/iPhone 7.properties");
//      properties.load(propertiesFIS);
//      platformVersion = properties.getProperty("platformVersion");
//      app_path = properties.getProperty("apk_path");
//      platformName = properties.getProperty("platform_name");
//      deviceName = properties.getProperty("device_name");
//      if (properties.getProperty("automation_name") != null)
//        automationName = properties.getProperty("automation_name");
//    } catch (IOException e) {
//      System.out.println(
//          "Properties file is missing or invalid! Check path to file: "
//              + "src/test/resources/properties/iPhone 7.properties");
//      System.exit(0);
//    }
//  }

  @Test
  public void buyerStartBeacon() throws InterruptedException, MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    File appDir = new File(System.getProperty("user.dir") + app_path);
    File app_path = new File(appDir, "/Point-Sample.app");
    capabilities.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
    capabilities.setCapability("automationName", "XCUITest");
    capabilities.setCapability("useFirstMatch", true);
    capabilities.setCapability("shouldUseCompactResponses", false);
    capabilities.setCapability("waitForQuiescence", false);
    capabilities.setCapability("useJSONSource", true);
    capabilities.setCapability(MobileCapabilityType.UDID, "BFDDD996-B455-4399-A577-A932A4F4A026");

    driver = (new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.findElement(By.id("BUYER")).click();
//    Thread.sleep(50);
    driver.findElement(By.id("OK")).isDisplayed();
    driver.findElement(By.id("OK")).click();
    driver.findElement(By.id("OK")).click();

  }

  @Test
  public void sellerStartBeacon() throws InterruptedException, MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    File appDir = new File(System.getProperty("user.dir") + app_path);
    File app_path = new File(appDir, "/Point-Sample.app");
    capabilities.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
    capabilities.setCapability(MobileCapabilityType.UDID, "19E3E919-E74A-45FB-AF0B-9F576F3F0FD3");
    capabilities.setCapability("wdaLocalPort", "8101");
    capabilities.setCapability("automationName", "XCUITest");
    capabilities.setCapability("useFirstMatch", true);
    capabilities.setCapability("shouldUseCompactResponses", false);
    capabilities.setCapability("waitForQuiescence", false);
    capabilities.setCapability("useJSONSource", true);
    driver = (new AppiumDriver(new URL("http://localhost:4724/wd/hub"), capabilities));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.findElement(By.id("SELLER")).click();
//    Thread.sleep(50);
    driver.findElement(By.id("START BEACON")).isDisplayed();
    driver.findElement(By.id("START BEACON")).click();
//    Thread.sleep(50);
    System .out.println(driver.getPageSource());
    driver.findElement(By.id("OK")).click();
//    Thread.sleep(50);
    driver.findElement(By.id("speaker_no_lines")).click();
  }

  @AfterClass
  public void shutDown() {
    driver.quit();
  }
}
