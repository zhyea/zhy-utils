package org.chobit.common.tools;

import java.util.concurrent.TimeUnit;

/**
 * 沙漏计时器
 *
 * @author robin
 */
public class HourGlass {

    private final TimeUnit unit;

    private final long interval;

    private long start;

    public HourGlass(TimeUnit unit, long interval) {
        this.unit = unit;
        this.interval = interval;
        this.start = System.currentTimeMillis();
    }

    /**
     * 反转沙漏，开始计时
     *
     * @return 重新计时的时点
     */
    public long reverse() {
        start = System.currentTimeMillis();
        return start;
    }

    /**
     * 查看剩余时间。时间单位同构造器时间单位一致
     *
     * @return 剩余时间
     */
    public long left() {
        long passed = System.currentTimeMillis() - start;
        long total = unit.toMillis(this.interval);
        long left = total - passed;
        return left > 0 ? unit.convert(left, TimeUnit.MILLISECONDS) : 0;
    }

    /**
     * 判断是否需要翻转沙漏，即判断计时是否结束
     *
     * @return 计时是否结束
     */
    public boolean needReverse() {
        long left = left();
        return left <= 0;
    }


    /**
     * 检查沙漏是否需要翻转，如需要则将之翻转
     *
     * @return 沙漏是否需要翻转
     */
    public boolean checkAndReverse() {
        boolean needReverse = needReverse();
        if (needReverse) {
            reverse();
        }
        return needReverse;
    }

}
