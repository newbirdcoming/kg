package com.kg.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName RandomTimeGeneratorUtils$
 * @description TODO
 * @date 2024/7/8 19:03
 **/
public class RandomTimeGeneratorUtils {

    /**
     * 生成一个在当前时间前后 k 个月范围内的随机时间
     *
     * @param k 随机时间范围，以月为单位，k > 0 表示当前时间后 k 个月内，k < 0 表示当前时间前 k 个月内
     * @return 随机生成的 ZonedDateTime 对象
     */
    public static ZonedDateTime generateRandomDateTimeAndArea(int k) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault(); // 获取系统默认时区

        // 计算起始和结束时间
        LocalDateTime startInclusive = now.plusMonths(k > 0 ? 0 : k);
        LocalDateTime endExclusive = now.plusMonths(k > 0 ? k : 0).plusDays(1); // 加一天，不包含结束时间的当天

        // 生成随机时间
        long startEpochDay = startInclusive.toLocalDate().toEpochDay();
        long endEpochDay = endExclusive.toLocalDate().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomDay * 24 * 3600, 0, zoneId.getRules().getOffset(now));


        return randomDateTime.atZone(zoneId);
    }

    public static LocalDateTime generateRandomDateTime(int k) {
        LocalDateTime now = LocalDateTime.now();

        // 计算起始和结束时间
        LocalDateTime startInclusive = now.plusMonths(k > 0 ? 0 : k);
        LocalDateTime endExclusive = now.plusMonths(k > 0 ? k : 0).plusDays(1); // 加一天，不包含结束时间的当天

        // 生成随机时间
        long startEpochSecond = startInclusive.atZone(ZoneId.systemDefault()).toEpochSecond();
        long endEpochSecond = endExclusive.atZone(ZoneId.systemDefault()).toEpochSecond();
        long randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(randomEpochSecond), ZoneId.systemDefault());

        // 将 ZonedDateTime 转换为 LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        return  localDateTime;
    }

}
