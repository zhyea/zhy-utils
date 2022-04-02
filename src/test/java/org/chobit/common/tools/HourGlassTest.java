package org.chobit.common.tools;

import org.chobit.common.concurrent.Threads;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author robin
 */
public class HourGlassTest {

    @Test
    public void checkAndReverse(){
        HourGlass hourGlass = new HourGlass(TimeUnit.SECONDS, 30);
        Threads.sleep(TimeUnit.SECONDS, 3);
        if(!hourGlass.checkAndReverse()){
            System.out.println(hourGlass.left());
        }
        Assert.assertFalse(hourGlass.needReverse());
    }

}
