package automation.testng.testcases;

import org.testng.annotations.Test;
import automation.contexts.CheckoutYourInfoData;
import automation.pages.LoginPage;
import automation.pages.ProductsPage;

public class TC001_Selectarea_Limbii_Interfetei extends BaseTest {
    String dtUsername = "standard_user";
    String dtPassword = "secret_sauce";

    String prod1 = "Sauce Labs Onesie";
    String prod2 = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void TC001_AddToCart_Checkout() {
        CheckoutYourInfoData dtYourInfo = new CheckoutYourInfoData();
        dtYourInfo.setFirstName("John");
        dtYourInfo.setLastName("Doe");
        dtYourInfo.setZip("3000");

        new LoginPage(driver).login(dtUsername, dtPassword);
        new ProductsPage(driver)
                .add(prod1)
                .add(prod2);

//        Assert.assertTrue(pgCheckout.isCheckoutComplete());
    }
}
