package org.chobit.common.utils;

import org.junit.Test;

import java.util.Properties;

/**
 * @author robin
 */
public class PropKitTest {

    @Test
    public void load() {
        Properties props = PropKit.load("/config.properties");
        System.out.println(props);
    }

}
