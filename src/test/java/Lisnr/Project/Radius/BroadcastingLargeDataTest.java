package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingLargeDataTest extends BaseTest {

    @Test()
    public void startBroadcastLargeDataTest() {
        radiusStartPage.clickStartTestingButton();
        broadcastSDKPage.selectToneTypeData();
        broadcastSDKPage.selectToneProfile();
        broadcastSDKPage.enterLargePayload();
        broadcastSDKPage.startBroadcasting();
        broadcastSDKPage.assertSDKState();
    }
}
