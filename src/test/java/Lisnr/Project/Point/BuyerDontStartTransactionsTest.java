package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BuyerDontStartTransactionsTest extends BaseTest {

  @Test()
  public void userDontStartTransactionsTest() {
    pointStartPage.clickBuyerButton();
    pointBuyerTransferPage.clickNotNow();
    pointBuyerTransferPage.clickNotNow();
    pointBuyerTransferPage.checkTransactionCanceledIcon();
    pointBuyerTransferPage.clickOKButton();
  }
}
