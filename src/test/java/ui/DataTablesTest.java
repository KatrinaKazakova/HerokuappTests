package ui;

import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DataTablesPage;

public class DataTablesTest extends Setup {
	public WebDriver driver;
	String url= "https://the-internet.herokuapp.com/tables";
	DataTablesPage dataTablePage;

	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		hitUrl(url);
	}

	@Test
	public void table1LastNamesAsc() {
		dataTablePage = new DataTablesPage(driver);
		dataTablePage.lastNamesSortTable1("asc");
	}

	@Test
	public void table1LastNamesDesc() {
		dataTablePage = new DataTablesPage(driver);
		dataTablePage.lastNamesSortTable1("desc");
	}
	@Test
	public void table2FirstNamesAsc() {
		dataTablePage = new DataTablesPage(driver);
		dataTablePage.firstNamesSortTable2("asc");
	}

	@Test
	public void table2FirstNamesDesc(){
		dataTablePage = new DataTablesPage(driver);
		dataTablePage.firstNamesSortTable2("desc");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}

