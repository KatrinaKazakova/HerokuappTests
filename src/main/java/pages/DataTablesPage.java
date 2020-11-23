package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataTablesPage extends BasePage {

    public DataTablesPage(WebDriver driver) {
        super(driver);
    }
    // Table 1
    @FindBy(xpath = "//*[@id='table1']/thead/tr/th[1]/span")
    WebElement lastNameTab1;
    @FindBy(xpath = "//table[@id='table1']/tbody/tr/td[1]")
    List<WebElement> lastNamesListTab1;

    // Table 2
    @FindBy(xpath = "//span[@class='first-name']")
    WebElement firstNameTab2;
    @FindBy(xpath = "//table[@id='table2']/tbody/tr/td[2]")
    List<WebElement> firstNamesListTab2;

    public void lastNamesSortTable1(String sortChoice)  {
        WebElement sortfield = lastNameTab1;
        List<WebElement> val = lastNamesListTab1;
        if ( sortChoice.equalsIgnoreCase("asc")) {
            sortAsc(sortfield,val);
        } else {
            sortDesc(sortfield, val);
        }
    }
    public void firstNamesSortTable2(String sortChoice) {
        WebElement sortfield = firstNameTab2;
        List<WebElement> val = firstNamesListTab2;
        if ( sortChoice.equalsIgnoreCase("asc")) {
            sortAsc(sortfield,val);
        } else {
            sortDesc(sortfield, val);
        }
    }

    public void sortAsc(WebElement sortField, List values) {
        sortField.click();     // click on Last Name column to be sorted in asc

        // capture all webelements into list
        List<WebElement> elementsList = values;

        // capture text of all webelements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // sort on the original list of previous step -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
    }

    public void sortDesc(WebElement sortField, List values) {
        refreshPage();
        // click on Last Name column to be sorted in asc
        sortField.click(); // asc
        sortField.click(); // desc

        // capture all webelements into list
        List<WebElement> elementsList = values;

        // capture text of all webelements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // sort on the original list of previous step -> sorted in Desc list
        List<String> sortedList = originalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        if (originalList.equals(sortedList)) {
            // descending order
        } else {
            sortField.click();
        }
        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
    }
}