package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BuyerNotReadyToPayAndAllowMicTest extends BaseTest {
  @Test
  public void buyerNotReadyToPayAndAllowMicTest() {
    pointStartPage.clickBuyerButton();
    pointBuyerTransferPage.clickNotNow();
    pointBuyerTransferPage.clickNotNow();
    pointBuyerTransferPage.checkTransactionCanceledIcon();
    pointBuyerTransferPage.clickOKButton();
  }
}
