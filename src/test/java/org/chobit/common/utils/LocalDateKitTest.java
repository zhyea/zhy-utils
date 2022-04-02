package org.chobit.common.utils;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author robin
 */
public class LocalDateKitTest {

    private static final long millis = 1590748022000L;

    @Test
    public void formatTime() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        String s = LocalDateKit.formatTime(time);
        Assert.assertEquals("2020-05-29 18:27:02", s);
    }

    @Test
    public void formatTime2() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String s = LocalDateKit.formatTime(pattern, time);
        Assert.assertEquals("2020-05-29T18:27:02Z", s);
    }

    @Test
    public void formatTime3() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        String pattern = "yyyy-MM-dd'T'HH:mm:ss'+0800'";
        String s = LocalDateKit.formatTime(pattern, time);
        Assert.assertEquals("2020-05-29T18:27:02+0800", s);
    }


    @Test
    public void parseTime() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        LocalDateTime t = LocalDateKit.parseTime("2020-05-29 18:27:02");
        Assert.assertEquals(time, t);
    }


    @Test
    public void formatDate() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        LocalDate date = time.toLocalDate();
        String s = LocalDateKit.formatDate(date);
        Assert.assertEquals("2020-05-29", s);
    }


    @Test
    public void parseDate() {
        LocalDateTime time = LocalDateKit.fromEpochMilli(millis);
        LocalDate date = time.toLocalDate();
        LocalDate d = LocalDateKit.parseDate("2020-05-29");
        Assert.assertEquals(date, d);
    }


    @Test
    public void toEpochMilli() {
        LocalDateTime t = LocalDateKit.parseTime("2020-05-29 18:27:02");
        long time = LocalDateKit.toEpochMilli(t);
        Assert.assertEquals(millis, time);
    }


    @Test
    public void fromEpochSecond() {
        LocalDateTime time = LocalDateKit.parseTime("2020-05-29 18:27:02");
        LocalDateTime t = LocalDateKit.fromEpochSecond(millis / 1000);
        Assert.assertEquals(time, t);
    }


    @Test
    public void toEpochSecond() {
        LocalDateTime time = LocalDateKit.parseTime("2020-05-29 18:27:02");
        long t = LocalDateKit.toEpochSecond(time);
        Assert.assertEquals(millis / 1000, t);
    }


    @Test
    public void remainsOfDay() {
        long millis = LocalDateKit.remainsOfDay(LocalDateTime.now());
        System.out.println(TimeUnit.MILLISECONDS.toHours(millis));
        Assert.assertTrue(millis > 0);
    }


    @Test
    public void toDate() {
        LocalDateTime now = LocalDateTime.now();
        Date date = LocalDateKit.toDate(now);
        long time = System.currentTimeMillis() / 1000 * 1000;
        Date date1 = new Date(time);
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.equals(date));
        Assert.assertEquals(date1, date);
    }


    @Test
    public void toDate1() {
        LocalDate today = LocalDate.now();
        Date date = LocalDateKit.toDate(today);
        Date date1 = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.equals(date));
    }


}
