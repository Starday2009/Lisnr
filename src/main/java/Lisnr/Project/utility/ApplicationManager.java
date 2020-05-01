package Lisnr.Project.utility;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ApplicationManager {
  protected IOSDriver driver;
  ReadProperties capProperties = new ReadProperties();
  public Properties properties = new Properties();
  DesiredCapabilities capabilities = new DesiredCapabilities();
  DesiredCapabilities caps_second_device = new DesiredCapabilities();

  public ApplicationManager(ITestContext context) throws Exception {
//    String testType = context.getCurrentXmlTest().getParameter("testType");
//    testType = testType != null ? testType : "main";
//
//    String deviceName = context.getCurrentXmlTest().getParameter("deviceName");
//    deviceName = deviceName != null ? deviceName : "iPhone X";
//
//    String wdaLocalPort = context.getCurrentXmlTest().getParameter("wdaLocalPort");
//    wdaLocalPort = wdaLocalPort != null ? wdaLocalPort : "8100";
//
//    String platformVersion = context.getCurrentXmlTest().getParameter("platformVersion");
//    platformVersion = platformVersion != null ? platformVersion : "12.2";
//
//    String buildNumber = context.getCurrentXmlTest().getParameter("buildNumber");
//
//    String jobName = context.getCurrentXmlTest().getParameter("jobName");
//
//    jobName = jobName != null ? jobName : "Auto Test";
//
//    Boolean isHeadless = Boolean.valueOf(context.getCurrentXmlTest().getParameter("isHeadless"));
//    isHeadless = isHeadless != null ? isHeadless : false;

    String nameTestL = "test-info";
    String absolutePath = System.getProperty("user.dir");
    String lastXML = "/lastLog.xml";
    String suit = "target/suitReport";
    String scrinFold = "target/screenshotsFolder";
    String imp = suit + "/import";

    String absoluteScreenshotsFolder = String.format("%s/%s", absolutePath, scrinFold);

    properties.setProperty("absolutePath", absolutePath);
    properties.setProperty("nameTestL", nameTestL);
    properties.setProperty("absoluteScreenshotsFolder", absoluteScreenshotsFolder);
    properties.setProperty("lastLog", lastXML);
    properties.setProperty("suit", suit);

    createFolder(suit);
    createFolder(imp);
    createFolder(scrinFold);
    capProperties.initProperty("emulatorCapability.properties");
//    if (testType.equals("main")) {
//
//      File appDir =
//          new File(System.getProperty("user.dir") + capProperties.getPropValue("apk_path"));
//      File APP = new File(appDir, "/iOS-Sample-App.app");
      //      File APP = new File(appDir, "/Point-Sample.app");
//
//      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
//      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//      capabilities.setCapability(MobileCapabilityType.APP, APP.getAbsolutePath());
//      capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
//      capabilities.setCapability("wdaLocalPort", "8100");
//      capabilities.setCapability("udid", "BFDDD996-B455-4399-A577-A932A4F4A026");
//      capabilities.setCapability("useFirstMatch", true);
//      capabilities.setCapability("shouldUseCompactResponses", false);
//      capabilities.setCapability("waitForQuiescence", false);
//      capabilities.setCapability("useJSONSource", true);
//      capabilities.setCapability("isHeadless", isHeadless);
//
//      caps_second_device.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//      caps_second_device.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
//      caps_second_device.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
//      caps_second_device.setCapability(MobileCapabilityType.APP, APP.getAbsolutePath());
//      caps_second_device.setCapability(MobileCapabilityType.FULL_RESET, true);
//      caps_second_device.setCapability("wdaLocalPort", "8101");
//      caps_second_device.setCapability("udid", "C831BAF7-3F1C-417F-B3A9-3E46FBD9FE63");
//      caps_second_device.setCapability("useFirstMatch", true);
//      caps_second_device.setCapability("shouldUseCompactResponses", false);
//      caps_second_device.setCapability("waitForQuiescence", false);
//      caps_second_device.setCapability("useJSONSource", true);
//    }
//    if (testType.equals("saucelabs")) {
//      capabilities.setCapability("app", "sauce-storage:iOS-Sample-App.zip");
//      capabilities.setCapability("build", buildNumber);
//      capabilities.setCapability("deviceName", deviceName);
//      capabilities.setCapability("platformVersion", platformVersion);
//      capabilities.setCapability("platformName", "iOS");
//      capabilities.setCapability("browserName", "");
//      capabilities.setCapability("name", jobName);
//    }
  }
//
//  public IOSDriver startDriver(ITestContext context, String port) throws MalformedURLException {
//    String URL = context.getCurrentXmlTest().getParameter("URL");
//    URL = URL != null ? URL : "http://localhost:" + port + "/wd/hub";
//    driver = new IOSDriver(new URL(URL), capabilities);
//    return driver;
//  }

  private String createFile(String fileName) throws IOException {
    File f = new File(fileName);
    if (!f.exists()) f.createNewFile();
    return fileName;
  }

  public String createFolder(String folderName) throws IOException {
    File f = new File(folderName);
    if (!f.exists()) {
      f.mkdir();
      System.out.println("folder created: " + folderName);
    }
    return folderName;
  }

  public void stop() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
