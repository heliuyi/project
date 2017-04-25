package hly.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HLY on 2017/4/18.
 */
public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.11.110:7776//wd/hub"), dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();

    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"firefox","http://192.168.11:4447"},
                {"chrome","http://192.168.11:8887"}
        };

    }

    @Test(dataProvider = "adb")
    public void testGrid2(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();

        }else if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.print("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.11.110:4447"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
}

