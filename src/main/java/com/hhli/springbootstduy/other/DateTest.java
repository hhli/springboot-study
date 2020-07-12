package com.hhli.springbootstduy.other;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 李辉辉
 * @date 2020-06-16 21:09
 * @description 日期测试
 */
public class DateTest {
    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException, InterruptedException {
        testRateLimit();
    }

    public static void testRateLimit() {
        final String[] temp = {"http://test-gateway-hdic.ke.com/test", "http://test3-gateway-hdic.ke.com/test", "http://test4-gateway-hdic.ke.com/test"};
        CyclicBarrier barrier = new CyclicBarrier(temp.length);
        for (int i = 0; i < temp.length; i++) {
            final String url = temp[i];
            new Thread(()->{
                //有threadLocal，所以线程里面单独设置
                HttpConfig config = HttpConfig.custom().url(url);

                try {
                    barrier.await();
                    HttpClientUtil.get(config);
                } catch (HttpProcessException | BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
