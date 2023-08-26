package selenium.po;

import selenium.base.BaseMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.base.Table;


public class ActionsPage extends BaseMethod {

    private final By doubleClick = By.xpath("//button[@id='doubleClickBtn']");
    private final By contextClick = By.xpath("//button[@id='rightClickBtn']");
    private final By getDoubleClickText = By.xpath("//p[@id='doubleClickMessage']");
    private final By getContextClickText = By.xpath("//p[@id='rightClickMessage']");
    private final By table = By.xpath("//div[@class='rt-tbody']");
    private final By textFromFrame = By.xpath("//body");
    private final By framesHeader = By.xpath("//div[@class='main-header']");

    private final By upload = By.xpath("//*[@id='uploadFile']");


    public ActionsPage uploadFile(String path) {
        findElementAndSetText(upload, path);
        return this;
    }

    public String getFramesHeader() {
        return getTextFromElement(framesHeader);
    }

    public String getTextFromFrame() {
        return getTextFromElement(textFromFrame);
    }

    public String getTextFromTable(int row, int column) {
        WebElement tableTmp = getWait().until(d -> d.findElement(table));
        Table table1 = new Table(tableTmp);
        return table1.getValue(row - 1, column - 1);
    }

    public String getTextFromTable(int row, String column) {
        WebElement tableTmp = getWait().until(d -> d.findElement(table));
        Table table1 = new Table(tableTmp);
        return table1.getValue(row - 1, column);
    }

    public ActionsPage clickDoubleClick() {
        doubleClick(doubleClick);
        return this;
    }

    public ActionsPage clickRightClick() {
        contextClick(contextClick);
        return this;
    }

    public String getDoubleText() {
        return getTextFromElement(getDoubleClickText);
    }

    public String getRightText() {
        return getTextFromElement(getContextClickText);
    }
}