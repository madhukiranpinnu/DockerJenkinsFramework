package Tests.VendorPortalTests;

import Tests.BaseTest;
import Tests.VendorPortalTests.model.VendorTestData;
import Util.Config;
import Util.Constants;
import com.docker.pages.VendorPortal.DashBoardPage;
import com.docker.pages.VendorPortal.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Util.JsonUtil;

public class VendorPortalTest extends BaseTest {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    VendorTestData vendorTestData;
    @BeforeTest
    @Parameters("vendorTestData")
    public void BeforeData(String vendorTestData){
        loginPage=new LoginPage(driver);
        dashBoardPage=new DashBoardPage(driver);
        this.vendorTestData= JsonUtil.getData(vendorTestData, VendorTestData.class);
    }
    @Test
    public void Login(){
        loginPage.goTo(Config.getProperty(Constants.VENDOR_URL));
        Assert.assertTrue(loginPage.onPage());
        loginPage.Credentials(vendorTestData.username(), vendorTestData.password());
    }
    @Test(dependsOnMethods = "Login")
    public void Dashboard(){
        dashBoardPage.onPage();
        Assert.assertEquals(dashBoardPage.monthlyEarning(),vendorTestData.monthlyEarning());
        Assert.assertEquals(dashBoardPage.annualEarning(),vendorTestData.annualEarning());
        Assert.assertEquals(dashBoardPage.profitMargin(),vendorTestData.profitMargin());
        Assert.assertEquals(dashBoardPage.avaialableInventory(),vendorTestData.availableInventory());
        dashBoardPage.search(vendorTestData.searchKeyword());
        Assert.assertTrue(dashBoardPage.entries().contains(vendorTestData.searchResultsCount()));
        dashBoardPage.logout();
    }
    @Test(dependsOnMethods = "Dashboard")
    public void logout(){
     Assert.assertTrue(loginPage.onPage());
    }
}
