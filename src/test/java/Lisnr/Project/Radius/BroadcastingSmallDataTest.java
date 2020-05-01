package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingSmallDataTest extends BaseTest {

  @Test()
  public void startBroadcastSmallData() {
    radiusStartPage.clickStartTestingButton();
    broadcastSDKPage.selectToneTypeData();
    broadcastSDKPage.selectToneProfile();
    broadcastSDKPage.enterSmallPayload();
    broadcastSDKPage.startBroadcasting();
    broadcastSDKPage.assertSDKState();
  }
}
