package com.hhli.springbootstduy.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 李辉辉
 * @date 2018/12/10 12:28
 * @description 数组测试
 */
public class ArrayTest {

    public static void main(String[] args) throws IOException {
        //List<String>  stringList  = new ArrayList<>();
        //stringList.add("a");
        //stringList.add("b");
        //stringList.add("c");
        //
        //String[] strArray = new String[stringList.size()];
        //stringList.toArray(strArray);
        //
        //System.out.println(Arrays.toString(strArray));

        //for (int i = 0; i < 10; i++) {
        //    System.out.println(i);
        //
        //    for (int j = 10; j < 20; j++) {
        //        System.out.println(j);
        //        if(j==15){
        //            break;
        //        }
        //    }
        //}

        Path path = Paths.get(".", "stacktrace", LocalDate.now().toString(), DateTimeFormatter.ofPattern("HH_mm_ss_SSS").format(
                LocalDateTime.now()) + ".txt");

        BufferedWriter wt = new BufferedWriter(new FileWriter(path.toFile()));

        wt.write("111111");
        wt.newLine();
        wt.write("2222222");
    }
}
