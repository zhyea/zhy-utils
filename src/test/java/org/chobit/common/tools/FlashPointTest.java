package org.chobit.common.tools;

import org.chobit.common.concurrent.Threads;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author robin
 */
public class FlashPointTest {


    @Test
    public void test() {
        FlashPoint point = new FlashPoint(1, TimeUnit.SECONDS, 2);
        Threads.sleep(TimeUnit.SECONDS, 10);
    }


}
