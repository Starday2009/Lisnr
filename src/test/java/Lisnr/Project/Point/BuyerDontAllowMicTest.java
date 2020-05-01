package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BuyerDontAllowMicTest extends BaseTest {
    @Test
    public void buyerDontAllowMic() {
        pointStartPage.clickBuyerButton();
        pointBuyerTransferPage.clickNotNow();
        pointBuyerTransferPage.clickOKButton();
        pointBuyerTransferPage.clickDnotAllowMicNativePopup();
        pointBuyerTransferPage.checkTransactionCanceledIcon();
        pointBuyerTransferPage.checkTransactionCanceledIcon();
    }
}
