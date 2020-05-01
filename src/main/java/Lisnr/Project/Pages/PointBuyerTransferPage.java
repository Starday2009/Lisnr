package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import org.openqa.selenium.By;

public class PointBuyerTransferPage extends CommonAppium {
  private By micIcon = By.id("mic");
  private By OKButton = By.id("OK");
  private By dontAllowButton = By.id("Don’t Allow");
  private By notNowButton = By.id("NOT NOW");
  private By micAccess = By.id("Microphone access is required for listening for LISNR tones");
  private By micRound = By.id("mic_round");
  private By noMicIcon = By.id("no-mic");
  private By transactionCanceled =
      By.xpath(
          "//XCUIElementTypeApplication[@name=\"Point-Sample\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView[1]");
  private By micWithoutEnabling =
      By.xpath(
          "//XCUIElementTypeApplication[@name=\"Point-Sample\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView[2]");

  public void checkTransferIcon() {
    loggerPrint("Check mic transfer icon");
    find(micRound).isVisible();
  }

  public void checkMicWithoutEnabling() {

    loggerPrint("Check Mic Without Enabling");
    find(micWithoutEnabling).isVisible();
  }

  public void checkTransactionCanceledIcon() {
    loggerPrint("Check Transaction Canceled");
    find(noMicIcon).isVisible();
  }


  public void clickOKButton() {
    loggerPrint("Click OK button");
    find(OKButton).click();
  }

  public void clickNotNow() {
    loggerPrint("Click not now button for not allow microphone permissions");
    find(micIcon).isVisible();
    find(notNowButton).click();
  }

  public void checkMicAccess() {
    loggerPrint("Check Mic Access");
    find(micIcon).isVisible();
  }

  public void clickDnotAllowMicNativePopup() {
    loggerPrint("Click OK button on native popup");
    find(micAccess).isVisible();
    find(dontAllowButton).click();
  }
}
