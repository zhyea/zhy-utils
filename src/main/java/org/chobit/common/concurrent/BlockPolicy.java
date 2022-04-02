package org.chobit.common.concurrent;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池队列已满的情况下的处理策略：阻塞当前线程一段时间后再重复提交
 *
 * @author robin
 */
public class BlockPolicy implements RejectedExecutionHandler {

    private final long period;

    /**
     * 构造器
     *
     * @param period 阻塞等待时长，单位毫秒
     */
    public BlockPolicy(long period) {
        this.period = period;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Threads.sleep(TimeUnit.MILLISECONDS, period);
        executor.submit(r);
    }
}
