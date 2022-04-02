package org.chobit.common.tools;

import org.chobit.common.concurrent.NamedThreadFactory;
import org.chobit.common.concurrent.Threads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用于海量数据高速处理的场景，以实现定期随机处理的能力
 *
 * @author robin
 */
public class FlashPoint {


    private final AtomicBoolean flag = new AtomicBoolean(false);

    /**
     * 构造器
     *
     * @param period   定期时间间隔
     * @param timeUnit 间隔单位
     * @param interval 有效时间窗，单位毫秒
     */
    public FlashPoint(long period, TimeUnit timeUnit, long interval) {
        ScheduledExecutorService executor =
                new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("flash-point-%d"));
        executor.scheduleAtFixedRate(() -> {
            flag.set(true);
            Threads.sleep(TimeUnit.MILLISECONDS, interval);
            flag.set(false);
        }, 0, period, timeUnit);
    }

    public boolean get() {
        return flag.get();
    }

}
