package hly.day1;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/5.
 */
public class TestNGDemo02 {
    //校验a == a
    //验证相等
    @Test
    public void assertEqualTest(){
        String a = "nihaoa";//实际值
        String b = "wobuhao";//预期值
        Assert.assertEquals(a,b );
        //Assert校验之后不要接其他操作。

    }
    //验证不相等
    @Test
    public void assertNotEqualTest() {
        int a = 1;//实际值
        int b = 2;//预期值
        Assert.assertNotEquals(a, b);
    }
    //验证等于空
    @Test
    public void assertNullEqualTest() {
        String a = "null";//实际值
        Assert.assertNull(a);
    }
    //验证不为空
    @Test
    public void assertNotNullEqualTest() {
        String a = "null";//实际值
        Assert.assertNotNull(a);
    }
}
