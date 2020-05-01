package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BuyerDeniesMicPermissionTest extends BaseTest {

    @Test()
    public void userDeniesMicPermissionTest() {
        pointStartPage.clickBuyerButton();
        pointBuyerTransferPage.clickOKButton();
        pointBuyerTransferPage.clickDnotAllowMicNativePopup();
        pointBuyerTransferPage.checkTransactionCanceledIcon();
        pointBuyerTransferPage.clickOKButton();

}
}
