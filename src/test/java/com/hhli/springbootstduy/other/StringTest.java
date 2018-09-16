package com.hhli.springbootstduy.other;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hhli_yangyu on 2018/9/7.
 * @author hhli_yangyu
 * @summary
 */
@Slf4j
public class StringTest {
    public static void main(String[] args) throws Exception {
//        Map<String, String[]> tempMap = new HashMap<>();
//        String[] tempArray = new String[]{"1", "2"};
//        tempMap.put("111",  tempArray);
//
//        System.out.println(tempMap.toString());


//
//        String s = "^[[0;39m^[[33m2018/09/12-19:09:21:390^[[0;39m ^[[31m18BAA6A133C2147E4BB9EA8146A3FE0D7_6717CC8A8180D149B6944F2094020EA603^[[0;39m ^[[35m[org.springframework.kafka.KafkaListenerEndpointContainer#0-0-L-7]^[[0;39m ^[[32mWARN ^[[0;39m ^[[36mcom.lianjia.hdic.convention.message.message.ApplyMsgConsumer^[[0;39m- ^[[31mapplyId=1120034195050504的任务不存在";
//
//        System.out.println(Arrays.toString(s.split(" ")));

        try{
            String s  = null;
            s.equals("test");
        }catch (Exception e){
            log.error("exception is:", e);
            throw new Exception("test");
        }
    }
}
