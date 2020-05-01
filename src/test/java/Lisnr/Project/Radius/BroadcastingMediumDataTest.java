package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingMediumDataTest extends BaseTest {

    @Test()
    public void startBroadcast() {
        radiusStartPage.clickStartTestingButton();
        broadcastSDKPage.selectToneTypeData();
        broadcastSDKPage.selectToneProfile();
        broadcastSDKPage.enterMediumlPayload();
        broadcastSDKPage.startBroadcasting();
        broadcastSDKPage.assertSDKState();
    }
}
