package com.weborders.tests.smoke_tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.pages.ViewAllProductsPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PageHeadersTests extends TestBase {

    @Test
    public void pageHeadersTest(){
      /*  LoginPage loginPage = new LoginPage();
        ViewAllProductsPage viewAllProductsPage = new ViewAllProductsPage();
        ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
        OrderPage orderPage = new OrderPage();
*/

      // create a new test case in the report
      extentLogger=report.createTest("Page Headers test");
      //use logger to log the steps
        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        extentLogger.info("Verifying header for all orders page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_ORDERS);

        extentLogger.info("Click on view all prodcut link");
        pages.viewAllOrders().viewAllProductsLink.click();

        extentLogger.info("Verifying header for all product page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_PRODUCTS);

        extentLogger.info("clicking onm order link");
        pages.viewAllProducts().orderLink.click();

        extentLogger.info("Verifying header for order page");
        assertEquals(pages.order().header.getText(), ApplicationConstants.ORDER);

        extentLogger.pass("Page header test is passed");
    }

}
