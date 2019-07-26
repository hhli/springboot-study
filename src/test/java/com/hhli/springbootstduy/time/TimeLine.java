package com.hhli.springbootstduy.time;

import java.time.Duration;
import java.time.Instant;

/**
 * @author 李辉辉
 * @date 2019/7/26 9:25
 * @description
 */
public class TimeLine {

    public static void main(String[] args) {
        Instant start = Instant.now();
        runAlgorithm();;
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
    }


    public static  void runAlgorithm(){

    }
}
