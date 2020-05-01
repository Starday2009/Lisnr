package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadiusBroadcastPage extends CommonAppium {
  private By listenTab = By.id("Listen");
  private By stateIdle = By.id("SDK State: Idle");
  private By stateBroadcasting = By.id("SDK State: Broadcasting");
  private By noToneTypeError = By.id("Please select a tone type");
  private By clearButton = By.id("Clear");
  private By toneTypeText = By.id("Text");
  private By toneTypeData = By.id("Data");
  private By toneProfileCompression = By.id("Compression");
  private By payloadSmall = By.id("Small");
  private By payloadMedium = By.id("Medium");
  private By payloadLarge = By.id("Large");
  private By deleteButton = By.id("Delete");
  private By startBroadcasting = By.id("Start Broadcasting");
  private By stopBroadcasting = By.id("Stop Broadcasting");
    private By queueField =
      By.xpath(
          "//XCUIElementTypeApplication[@name=\"iOS-Sample-App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextField");

  public void enterValueInQueue() {
    loggerPrint("Start broadcasting");
    find(deleteButton).click();
    find(queueField).sendKeys("5");
  }

  public void assertSDKState() {
    loggerPrint("Start broadcasting");
    find(stateBroadcasting).isVisible();
    find(stateIdle).isVisible();
  }

  public void startBroadcasting() {
    loggerPrint("Start broadcasting");
    find(startBroadcasting).click();
  }
  public void selectToneTypeText() {
    loggerPrint("Select Tone Type: text");
    find(toneTypeText).click();
  }
  public void selectToneTypeData() {
    loggerPrint("Select Tone Type: data");
    find(toneTypeData).click();
  }
  public void selectToneProfile() {
    loggerPrint("Select Tone Profile: compressions");
    find(toneProfileCompression).click();
  }
  public void enterSmallPayload() {
    loggerPrint("Enter Small Payload");
    find(payloadSmall).click();
  }
  public void enterMediumlPayload() {
    loggerPrint("Enter Small Payload");
    find(payloadMedium).click();
  }
  public void enterLargePayload() {
    loggerPrint("Enter Small Payload");
    find(payloadLarge).click();
  }
}
