package com.orangehrm.tests;

import java.io.File;
import java.io.IOException;
 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.Base.BaseTest;
import com.orangehrm.pages.loginPage;
import com.orangehrm.utilities.ExcelUtilities;
 
@Listeners(com.orangehrm.listeners.TestListener.class)
public class loginListener extends BaseTest {
 
    static String projectpath = System.getProperty("user.dir");
 
    ExtentTest test;
    @Test(dataProvider = "logindata")
    public void verifyLogin(String username, String password) throws IOException {
 
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
        loginPage obj = new loginPage(driver);
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonbutton();
 
        // Validation: Dashboard 
        if (obj.dashisdisplayed()) {
            test.pass("Login successful for user: " + username);
        } else {
            test.fail("Login unsuccessful for user: " + username);
            // Screenshot is handled automatically by Listener on failure
        }
 
        // Validation: Title
        if (driver.getTitle().equals("OrangeHRM")) {
            test.pass("Title matched successfully.");
        } else {
            test.fail("Title mismatch.");
        }
    }
 
    @DataProvider
    public Object[][] logindata() throws IOException {
        return ExcelUtilities.getdata(
            projectpath + File.separator + "src" + File.separator + "test" + File.separator + "resources"
            + File.separator + "Orangehrm_Testdata" + File.separator + "data.xlsx",
            "Sheet1"
        );
    }
}