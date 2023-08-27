package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.config.WebDriverInit;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.ofSeconds;
import static selenium.config.WebDriverInit.getDriver;

public class BaseMethod {

    protected WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), ofSeconds(10));
    }

    protected Actions getAction() {
        return new Actions(getDriver());
    }

    protected void findElementAndSetText(By locator, String search) {
        getWait().until(e -> e.findElement(locator)).sendKeys(search);
    }

    protected void click(By locator) {
        getWait().until(e -> e.findElement(locator)).click();
    }

    protected void doubleClick(By locator) {
        WebElement doubleElement = getWait().until(e -> e.findElement(locator));
        getAction().doubleClick(doubleElement).build().perform();
    }

    protected void contextClick(By locator) {
        WebElement contextElement = getWait().until(e -> e.findElement(locator));
        getAction().contextClick(contextElement).build().perform();
    }

    protected String getTextFromElement(By locator) {
        return getWait().until(d -> d.findElement(locator)).getText();
    }

    protected void clickEnter(By locator) {
        getWait().until(e -> e.findElement(locator)).sendKeys(Keys.ENTER);
    }

    protected List<String> getTextFromElements(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        return getWait().until(d -> d.findElements(locator))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}