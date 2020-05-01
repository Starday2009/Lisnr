package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingMediumTextTest extends BaseTest {

  @Test()
  public void startBroadcast() {
    radiusStartPage.clickStartTestingButton();
    broadcastSDKPage.selectToneTypeText();
    broadcastSDKPage.selectToneProfile();
    broadcastSDKPage.enterMediumlPayload();
    broadcastSDKPage.startBroadcasting();
    broadcastSDKPage.assertSDKState();
  }
}
