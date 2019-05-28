package unit.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 李辉辉
 * @date 2019-05-21 15:19
 * @description
 */
public class TestNGSimpleTest {


    @Test
    public void testAdd(){
        String str = "TestNG is working fine";
        Assert.assertEquals("TestNG is working fine", str);
    }
}
