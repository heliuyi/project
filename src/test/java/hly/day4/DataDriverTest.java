package hly.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/24.
 */
public class DataDriverTest {
    @DataProvider(name = "loginUser")
    public Object[][] data1() {
        return new Object[][]{{"user1", "pwd"},
                {"user2", "pwd2"},
                {"user3","pwd3"}
    };

    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user, String pwd) {
        System.out.print("user" + user);
        System.out.print("pwd" + pwd);
    }
}

