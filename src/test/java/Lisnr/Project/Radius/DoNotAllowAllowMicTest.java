package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class DoNotAllowAllowMicTest extends BaseTest {

  @Test()
  public void doNotAllowAllowMicTest() {
    radiusStartPage.clickStartTestingButton();
    listenSDKPage.startListening();
    listenSDKPage.notAllowMicAccess();
    listenSDKPage.assertStateIdle();
  }
}
