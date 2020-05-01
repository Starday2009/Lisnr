package Lisnr.Project.utility;

import Lisnr.Project.configs.CommonAppium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Element extends CommonAppium implements WebElement {
  private WebElement element;

  public Element(WebElement element) {
    this.element = element;
  }

  @Override
  public void click() {
    try {
      element.click();
    } catch (StaleElementReferenceException e) {
      sleep(3000);
      element.click();
    }
  }

  public void clickWithoutWait() {
    try {
      element.click();
    } catch (StaleElementReferenceException e) {
      element.click();
    }
  }

  public WebElement getWebElement() {
    return element;
  }

  public void rightClick() {
    new Actions(driver).contextClick(element).build().perform();
  }

  public void doubleClick() {
    new Actions(driver).doubleClick(getWebElement()).build().perform();
  }

  public void mouseHover() {
    new Actions(driver).moveToElement(element).build().perform();
  }

  public boolean isEmpty() {
    try {
      return element.getText().trim().length() == 0;
    } catch (NullPointerException | TimeoutException | NoSuchElementException e) {
      return false;
    }
  }

  @Override
  public void submit() {
    element.submit();
  }

  public void switchToIframe() {
    driver.switchTo().frame(element);
  }

  @Override
  public void sendKeys(CharSequence... keysToSend) {
    loggerPrint(String.format("Enter value: %s", keysToSend));
    element.sendKeys(keysToSend);
  }

  public void sendKeysAfterClear(CharSequence... keysToSend) {
    clear();
    sendKeys(keysToSend);
  }

  @Override
  public void clear() {
    try {
      element.clear();
    } catch (ElementNotInteractableException e) {
      sleep(1000);
      element.clear();
    }
  }

  @Override
  public String getTagName() {
    return element.getTagName();
  }

  @Override
  public String getAttribute(String name) {
    return element.getAttribute(name);
  }

  @Override
  public boolean isSelected() {
    return element.isSelected();
  }

  @Override
  public boolean isEnabled() {
    return element.isEnabled();
  }

  @Override
  public String getText() {
    return element.getText();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return element.findElements(by);
  }

  @Override
  public Element findElement(By by) {
    return new Element(element.findElement(by));
  }

  @Override
  public boolean isDisplayed() {
    try {
      return element.isDisplayed();
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isVisible() {
    try {
      return element.isDisplayed();
    } catch (NullPointerException e) {
      return false;
    } catch (StaleElementReferenceException i) {
      return true;
    }
  }

  @Override
  public Point getLocation() {
    return element.getLocation();
  }

  @Override
  public Dimension getSize() {
    return element.getSize();
  }

  @Override
  public Rectangle getRect() {
    return element.getRect();
  }

  @Override
  public String getCssValue(String propertyName) {
    return element.getCssValue(propertyName);
  }

  @Override
  public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
    return element.getScreenshotAs(target);
  }

  public void selectByVisibleText(String value) {
    new Select(element).selectByVisibleText(value);
  }

  public void clickWithJS() {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
  }

  public Element waitUntilVisible() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(element));
    return this;
  }

  public void actionClick() {
    new Actions(driver).click(element).build().perform();
  }

  public void sendEnterClick() {
    new Actions(driver).sendKeys(element, Keys.ENTER).build().perform();
  }
}
