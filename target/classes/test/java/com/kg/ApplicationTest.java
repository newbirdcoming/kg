package com.kg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kg.utils.ProducelatAndLong.getRandomLatitude;
import static com.kg.utils.ProducelatAndLong.getRandomLongitude;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName ApplicationTest$
 * @description TODO
 * @date 2024/7/17 10:55
 **/
@SpringBootTest
public class ApplicationTest {
    @Test
    void testLongAndLat(){
        double randomLongitude = getRandomLongitude();
        double randomLatitude = getRandomLatitude();
        System.out.println("randomLongitude:"+randomLongitude);
        System.out.println("randomLatitude:"+randomLatitude);
    }

}
