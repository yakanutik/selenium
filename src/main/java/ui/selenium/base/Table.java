package ui.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table extends BaseMethod {
    WebElement elementTable;

    public Table(WebElement elementTable) {
        this.elementTable = elementTable;
    }

    public List<WebElement> getRows() {
        List<WebElement> rows = elementTable.findElements(By.xpath(".//div[@role='row']"));
        rows.remove(0);
        return rows;
    }

    public List<List<WebElement>> getRowsAndColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowAndColumns = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(".//div[@role='gridcell']"));
            rowAndColumns.add(columns);
        }
        return rowAndColumns;
    }

    public String getValue(int row, int column) {
        List<List<WebElement>> rowsAndColumn = getRowsAndColumns();
        WebElement cell = rowsAndColumn.get(row - 1).get(column);
        return cell.getText();
    }

    public String getValue(int row, String column) {
        List<Map<String, WebElement>> rowsAndColumn = getRowsAndColumnsByHeading();
        WebElement cell = rowsAndColumn.get(row - 1).get(column);
        return cell.getText();
    }

    public List<WebElement> getHeading() {
        return getWait().until(d -> d.findElements(By.xpath("//div[@role='columnheader']")));

    }

    public List<Map<String, WebElement>> getRowsAndColumnsByHeading() {
        List<List<WebElement>> rowsWithColumns = getRowsAndColumns();
        List<Map<String, WebElement>> rowsAndColumnsByHeading = new ArrayList<>();
        Map<String, WebElement> rowByHeading;
        List<WebElement> headColumns = getHeading();

        for (List<WebElement> row : rowsWithColumns) {
            rowByHeading = new HashMap<>();
            for (int i = 0; i < headColumns.size() - 1; i++) {
                String heading = headColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeading.put(heading, cell);
            }
            rowsAndColumnsByHeading.add(rowByHeading);
        }
        return rowsAndColumnsByHeading;
    }
}