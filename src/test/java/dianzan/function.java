package dianzan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/19.
 */
public class function {
    WebDriver driver;

    @BeforeMethod
    public void openDZ() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.11.110:8080/login.act");
        driver.findElement(By.id("mobile")).sendKeys("15666666666");
        driver.findElement(By.id("password")).sendKeys("258963");
        driver.findElement(By.id("vcode")).sendKeys("1111");
        driver.findElement(By.id("button")).click();
        //        显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"header_tagging\"]/a[1]")));
//        获取文本
        String yanzheng = driver.findElement(By.xpath("//*[@class=\"header_tagging\"]/a[1]")).getText();
        Assert.assertEquals(yanzheng, "返回网站首页");
    }

    @Test
    public void draft() {
        driver.findElement(By.id("creatActivity")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "发起项目");

    }

    @Test
    public void waiting() {
        driver.findElement(By.id("settlement")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "待结算");

    }

    @Test
    public void follow() {
        driver.findElement(By.id("followActivity")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "我的支持");

    }

    @Test
    public void support() {
        driver.findElement(By.id("supportActivity")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "我的支持");

    }

    @Test
    public void news() {
        driver.findElement(By.id("receivedMsg")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "消息");

    }
    @Test
    public void setUp() {
        driver.findElement(By.id("settingInformation")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "资料设置");

    }
    @Test
    public void Authentication() {
        driver.findElement(By.id("userAuth")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("faqi_title")));
        String yanzheng = driver.findElement(By.className("faqi_title")).getText();
        Assert.assertEquals(yanzheng, "认证");

    }
    @Test
    public void help() {
        driver.findElement(By.id("dianzanHelp")).click();
//        获取当前页面的handle值
        String handle1 = driver.getWindowHandle();
//         driger 切换到新的widow页面
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"header_main\"]/a[1]/img")));
        String yanzheng = driver.findElement(By.xpath("//*[@class=\"header_main\"]/a[1]/img")).getText();
        Assert.assertEquals(yanzheng, "");

    }



    @AfterMethod

    public void close2() throws InterruptedException {
        driver.quit();

    }

}
