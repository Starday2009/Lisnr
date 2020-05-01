package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class BroadcastingDataInQueueTest extends BaseTest {

    @Test()
    public void startBroadcastingDataInQueue() {
        radiusStartPage.clickStartTestingButton();
        broadcastSDKPage.selectToneTypeData();
        broadcastSDKPage.selectToneProfile();
        broadcastSDKPage.enterLargePayload();
        broadcastSDKPage.enterValueInQueue();
        broadcastSDKPage.startBroadcasting();
        broadcastSDKPage.startBroadcasting();
        broadcastSDKPage.assertSDKState();
    }
}
