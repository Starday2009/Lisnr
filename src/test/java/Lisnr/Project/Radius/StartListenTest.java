package Lisnr.Project.Radius;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;


public class StartListenTest extends BaseTest {

  @Test
  public void startListen() {
    long id = Thread.currentThread().getId();
    System.out.println("Simple test-method One. Thread id is: " + id);
    radiusStartPage.clickStartTestingButton();
    listenSDKPage.startListening();
    listenSDKPage.allowMicAccess();
    listenSDKPage.assertFirstItemInList();
  }
  @Test
  public void startBroadcast() {
    long id = Thread.currentThread().getId();
    System.out.println("Simple test-method Two. Thread id is: " + id);
    radiusStartPage.clickStartTestingButton();
    broadcastSDKPage.selectToneTypeText();
    broadcastSDKPage.selectToneProfile();
    broadcastSDKPage.enterSmallPayload();
    broadcastSDKPage.startBroadcasting();
    broadcastSDKPage.assertSDKState();
  }

}
