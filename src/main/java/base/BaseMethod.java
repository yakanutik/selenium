package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverInit.getDriver;

public class BaseMethod {

    protected WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 5);
    }

    protected void findElementAndSetText(By locator, String search) {
        getWait().until(e -> e.findElement(locator)).sendKeys(search);
    }

    protected void click(By locator) {
        getWait().until(e -> e.findElement(locator)).click();
    }

    protected String getTextFromElement(By locator) {
        return getWait().until(d -> d.findElement(locator)).getText();
    }
}
