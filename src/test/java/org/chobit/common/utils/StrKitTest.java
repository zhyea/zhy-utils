package org.chobit.common.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author robin
 */
public class StrKitTest {


    @Test
    public void isInteger() {
        Assert.assertTrue(StrKit.isInteger("001"));
        Assert.assertTrue(StrKit.isInteger("-001"));
        Assert.assertTrue(StrKit.isInteger("+001"));
    }


    @Test
    public void isDouble() {
        Assert.assertTrue(StrKit.isDouble("1.001"));
        Assert.assertTrue(StrKit.isDouble("-1.001"));
        Assert.assertTrue(StrKit.isDouble("+1.001"));
    }


    @Test
    public void format() {
        String pattern = "#000";
        String v = StrKit.format(pattern, 1);
        System.out.println(v);
        Assert.assertEquals("001", v);
    }


    @Test
    public void isBool() {
        Assert.assertTrue(StrKit.isBool("TRUE"));
        Assert.assertTrue(StrKit.isBool("true"));
        Assert.assertTrue(StrKit.isBool("FALSE"));
        Assert.assertTrue(StrKit.isBool("false"));
        Assert.assertFalse(StrKit.isBool("false0"));
    }


    @Test
    public void join() {
        String separator = ":";
        String s = StrKit.join(separator, "a", "b", "c", "d", "e");
        System.out.println(s);
    }

}
