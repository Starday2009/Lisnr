package Lisnr.Project.Point;

import Lisnr.Project.BaseTest;
import org.testng.annotations.Test;

public class SellerStartBeaconTest extends BaseTest {
    @Test
    public void sellerStartBeacon() {
        pointStartPage.clickSellerButton();
        pointSellerPage.clickStartBeacon();
        pointSellerPage.clickOKButton();
        pointSellerPage.checkSpeaker();

        //stop beacon
        //Verify the speaker animation stops and that the beacon stops playing (use a spectrogram)
        //Click “Clear Log” and verify the on-screen log clears
        //Close and re-open the application?

    }
}
