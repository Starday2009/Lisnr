package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PointSellerPage extends CommonAppium {
  private By stopBeacon = By.id("STOP BEACON");
  private By startBeacon = By.id("START BEACON");
  private By emptyList = By.id("Empty list");
  private By clearLog = By.id("CLEAR LOG");
  private By noMic = By.id("no-mic");
  private By speaker_no_lines = By.id("speaker_no_lines");
  private By cardNum = By.id("Card number - ");
  private By OKButton = By.id("OK");
  private By dontAllowButton = By.id("Don’t Allow");

  public void checkSpeaker() {
    loggerPrint("Check mic transfer icon");
    find(speaker_no_lines).isVisible();
  }
  public void clickStartBeacon() {
    loggerPrint("Start beacon");
    find(startBeacon).click();
  }
  public void clickOKButton() {
    loggerPrint("Click OK button");
    find(OKButton).click();
  }
  public void clickDontAllowButton() {
    loggerPrint("Click dont Allow Button");
    find(dontAllowButton).click();
  }
  public void checkBeaconsNotPlaying() {
    loggerPrint("Check beacons are not playing via a spectrogram");
    find(noMic).isVisible();
  }
}


