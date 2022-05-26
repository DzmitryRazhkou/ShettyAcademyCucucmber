package parallel;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        properties = configReader.initProp();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario sc) {
        if (sc.isFailed()) {

            String screenshotName = sc.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath, "image/jpg", screenshotName);
        }
    }
}
