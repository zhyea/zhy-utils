package org.chobit.common.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 线程工具类
 *
 * @author robin
 */
public final class Threads {

    private static final Logger logger = LoggerFactory.getLogger(Threads.class);


    /**
     * 睡眠一段时间
     *
     * @param unit     时间单位
     * @param interval 睡眠时长
     */
    public static void sleep(TimeUnit unit, long interval) {
        try {
            unit.sleep(interval);
        } catch (InterruptedException e) {
            logger.error("sleep for waiting", e);
            Thread.currentThread().interrupt();
        }
    }


    /**
     * 创建新线程
     *
     * @param runnable   Runnable实例
     * @param threadName 线程名
     * @param isDaemon   是否后台线程
     * @return 新建的线程实例
     */
    public static Thread newThread(Runnable runnable, String threadName, boolean isDaemon) {
        Thread t = new Thread(runnable, threadName);
        t.setDaemon(isDaemon);
        return t;
    }


    private Threads() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
