package com.kg.utils;

import java.util.Random;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName ProducelatAndLong$
 * @description TODO
 * @date 2024/7/17 10:53
 **/
public class ProducelatAndLong {
    // 生成随机经度（-180 到 180 之间）
    public static double getRandomLongitude() {
        Random random = new Random();
        return -180.0 + random.nextDouble() * 360.0;
    }

    // 生成随机纬度（-90 到 90 之间）
    public static double getRandomLatitude() {
        Random random = new Random();
        return -90.0 + random.nextDouble() * 180.0;
    }


//        double longitude = getRandomLongitude();
//        double latitude = getRandomLatitude();

}
