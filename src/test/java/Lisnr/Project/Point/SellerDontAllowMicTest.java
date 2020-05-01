package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class SellerDontAllowMicTest extends BaseTest {
  @Test
  public void sellerDontAllowMicTest() {
    pointStartPage.clickSellerButton();
    pointSellerPage.clickStartBeacon();
    pointSellerPage.clickDontAllowButton();
    pointSellerPage.checkBeaconsNotPlaying();
  }
}
