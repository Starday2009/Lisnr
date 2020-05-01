package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BuyerAllowMicButNotReadyToPay extends BaseTest {
    @Test
    public void buyerAllowMicButNotReadyToPay() {
        pointStartPage.clickBuyerButton();
        pointBuyerTransferPage.clickOKButton();
        pointBuyerTransferPage.clickOKButton();
        pointBuyerTransferPage.checkMicAccess();
        pointBuyerTransferPage.clickNotNow();
        pointBuyerTransferPage.checkTransactionCanceledIcon();
        pointBuyerTransferPage.clickOKButton();

    }
}
