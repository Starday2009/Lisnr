package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingSmallTextTest extends BaseTest {

  @Test()
  public void startBroadcast() {
    radiusStartPage.clickStartTestingButton();
    broadcastSDKPage.selectToneTypeText();
    broadcastSDKPage.selectToneProfile();
    broadcastSDKPage.enterSmallPayload();
    broadcastSDKPage.startBroadcasting();
    broadcastSDKPage.assertSDKState();
  }

}
