package Lisnr.Project.Pages;

import Lisnr.Project.configs.CommonAppium;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PointStartPage extends CommonAppium {
        private By sellerButton = By.id("SELLER");
        private By buyerButton = By.id("BUYER");


    public void clickBuyerButton() {
            loggerPrint("Click Buyer button");
            find(buyerButton).click();
        }

        public void clickSellerButton() {
            loggerPrint("Click Seller button");
            find(sellerButton).click();
        }
    }
