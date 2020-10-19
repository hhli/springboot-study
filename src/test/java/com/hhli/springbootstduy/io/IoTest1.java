package com.hhli.springbootstduy.io;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/7/20 20:53
 * @description 输入输出测试
 */
public class IoTest1 {

    public static void main(String[] args) throws IOException {
        //InputStream in = new FileInputStream(new File("D:\\github\\springboot-study\\src\\test\\resources\\example.txt"));
        //int byteAvailable = in.available();
        //System.out.println("byte length=" + byteAvailable);
        //in.close();
        //
        //String content = new String(Files.readAllBytes(Paths.get("")), StandardCharsets.UTF_8);
        //List<String> lines = Files.readAllLines(Paths.get(""));
        //Stream<String> fileStream =  Files.lines(Paths.get(""));
        //Scanner scanner = new Scanner(new File(""));
        //while (scanner.hasNextLine()){
        //    String line = scanner.nextLine();
        //}
        //
        //InputStream inputStream = new FileInputStream("");
        //try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
        //    String line;
        //    while (StringUtils.isNotBlank(line=reader.readLine())){
        //        System.out.println(line);
        //    }
        //
        //}



        while (true){
            InetAddress inetAddress = InetAddress.getByName("cms.gateway.ke.com");
            System.out.println(inetAddress.getHostAddress());

            try {
                TimeUnit.SECONDS.sleep(1);
                clearCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void clearCache() throws NoSuchFieldException, IllegalAccessException {
        //修改缓存数据开始
        Class clazz = java.net.InetAddress.class;
        final Field cacheField = clazz.getDeclaredField("addressCache");
        cacheField.setAccessible(true);
        final Object obj = cacheField.get(clazz);
        Class cacheClazz = obj.getClass();
        final Field cacheMapField = cacheClazz.getDeclaredField("cache");
        cacheMapField.setAccessible(true);
        final LinkedHashMap<String, ?> cacheMap = (LinkedHashMap<String, ?>)cacheMapField.get(obj);

        cacheMap.clear();
    }
}
