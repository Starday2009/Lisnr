package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import org.openqa.selenium.By;

public class RadiusListenPage extends CommonAppium {
  private By allowButton = By.id("OK");
  private By emptyList = By.id("Empty list");
  private By listenTab = By.id("Listen");
  private By notAllowButton = By.id("Don’t Allow");
  private By clearButton = By.id("Clear");
  private By stateBroadcasting = By.id("SDK State: Broadcasting");
  private By stateIdle = By.id("SDK State: Idle");
  private By startListeningButton = By.id("Start Listening");
  private By stopListeningButton = By.id("Stop Listening");
  private By firstItemInList =
      By.xpath(
          "//XCUIElementTypeApplication[@name=\"iOS-Sample-App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
  private By micAccess =
      By.id("Microphone access is needed to listen for ultrasonic data transmissions");


  public void assertStateIdle() {
    loggerPrint("Assert State Idle");
    find(stateIdle).isVisible();
  }

  public void assertFirstItemInList() {
    loggerPrint("Assert first Item In List is appeared");
    findWithLongWait(firstItemInList).isVisible();
  }

  public void startListening() {
    loggerPrint("Start Listening");
    find(listenTab).click();
    find(startListeningButton).click();
  }
  public void allowMicAccess() {
    loggerPrint("Allow mic access");
    find(micAccess).isVisible();
    find(allowButton).click();
  }
  public void notAllowMicAccess() {
    loggerPrint("Allow mic access");
    find(micAccess).isVisible();
    find(notAllowButton).click();
  }

  public void accertState(){
    find(stateBroadcasting).isVisible();
  }}

