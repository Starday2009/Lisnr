package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingLargeTextTest extends BaseTest {

  @Test()
  public void startBroadcastLargeTextTest() {
    radiusStartPage.clickStartTestingButton();
    broadcastSDKPage.selectToneTypeText();
    broadcastSDKPage.selectToneProfile();
    broadcastSDKPage.enterLargePayload();
    broadcastSDKPage.startBroadcasting();
    broadcastSDKPage.assertSDKState();
  }
}
