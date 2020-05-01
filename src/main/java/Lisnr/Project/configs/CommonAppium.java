package Lisnr.Project.configs;

import Lisnr.Project.BaseTest;
import Lisnr.Project.utility.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonAppium extends BaseTest {

  private static final int PAGE_LOAD_MAXIMUM_SECONDS = 50;
  private static final int MAXIMUM_SECONDS = 60;

  protected void getScr(IOSDriver driver) {
    loggerPrint("getScr");
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      String reportDirectory =
          new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/screenshotsFolder";
      File destFile =
          new File((String) reportDirectory + "/failure_screenshots/" + "failScr" + ".png");
      FileUtils.copyFile(scrFile, destFile);
      Reporter.log(
          "<a href='"
              + destFile.getAbsolutePath()
              + "'> <img src='"
              + destFile.getAbsolutePath()
              + "' height='100' width='100'/> </a>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected boolean containsSecondValue(String full, String part) {
    full = (full != null && !full.isEmpty()) ? full : "";
    part = (part != null && !part.isEmpty()) ? part : "";
    if (!full.toLowerCase().contains(part.toLowerCase())) {
      loggerPrint(full + "\" not contains \"" + part);
      if (full.isEmpty()) {
        return false;
      } else {
        failTest("");
      }
    }
    return true;
  }

  public void loggerPrint(String message) {
    LisLogger.getInstance().loggerPrint(message);
  }

  protected void loggerPrintError(String message) {
    LisLogger.getInstance().loggerPrintError(message);
  }

  protected void loggerPrintWarn(String message) {
    LisLogger.getInstance().loggerPrintWarn(message);
  }

  public void failTest(String message) {
    loggerPrintError(message);
    Assert.fail(message);
  }

  protected Element find(By by) {
    String elementStr = String.valueOf(by);
    Element element = new Element(null);
    System.out.println("Driver find is " + driver);
//    WebDriverWait wait = new WebDriverWait(this.driver, PAGE_LOAD_MAXIMUM_SECONDS);
    try {
      loggerPrint("Try to find element- \"" + elementStr + "\" ");
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      element = new Element(driver.findElement(by));
    } catch (WebDriverException | NullPointerException e) {
      loggerPrint("Element did not appear");
      failTest("Element \"" + elementStr + "\" did not appear, see screen");
    }
    return element;
  }

  protected Element findWithLongWait(By by) {
    Element element = new Element(null);
    WebDriverWait wait = new WebDriverWait(driver, MAXIMUM_SECONDS);
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      element = new Element(driver.findElement(by));
    } catch (WebDriverException | NullPointerException e) {
    }
    return element;
  }

  protected static void sleep(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void selectFromInput(By selector, String selectorFromList, String name) {
    find(selector).click();
    sleep(1000);
    find(By.xpath("//" + selectorFromList + "[text() = '" + name + "']")).click();
  }

  protected void selectFromInput(Element element, String selectorFromList, String name) {
    element.click();
    find(By.xpath("//" + selectorFromList + "[text() = '" + name + "']")).click();
  }

  protected Element findElementByText(String text) {
    return find(By.xpath("//*[text()='" + text + "']"));
  }

  protected By findSelectorByText(String text) {
    return By.xpath("//*[text()='" + text + "']");
  }
}
