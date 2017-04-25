package hly.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/5.
 */
public class OpenBrowserTest {
    //火狐默认安装时使用下面
    @Test
    public void openf1(){

        WebDriver webDriver = new FirefoxDriver();
    }
    //自定义安装时使用下面
    @Test
    public void openf2() {
        System.setProperty("webdriver.firefox.bin","E:\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChrom(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }
    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
    }
    @Test
    public void openChrome1(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }




}
