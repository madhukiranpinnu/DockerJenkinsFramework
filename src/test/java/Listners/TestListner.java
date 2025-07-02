package Listners;

import Util.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListner implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot screenshot=(TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
        String image=screenshot.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat, image);
        Reporter.log(htmlImage);
    }
}
