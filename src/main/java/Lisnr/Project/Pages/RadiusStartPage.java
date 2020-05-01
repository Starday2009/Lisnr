package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import org.openqa.selenium.By;

public class RadiusStartPage extends CommonAppium {
    private By startTestingButton = By.id("Start Testing");

    public void clickStartTestingButton() {
        loggerPrint("Click start testing button");
        find(startTestingButton).isVisible();
        find(startTestingButton).click();

    }

}
