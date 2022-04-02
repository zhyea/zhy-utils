package org.chobit.common.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author robin
 */
public class IpKitTest {


    @Test
    public void getIp() {
        String ip = IpKit.getIp();
        System.out.println(ip);
        Assert.assertNotNull(ip);
    }


}
