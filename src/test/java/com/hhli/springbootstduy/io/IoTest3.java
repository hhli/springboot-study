package com.hhli.springbootstduy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author 李辉辉
 * @date 2019/7/24 22:40
 * @description 正则表达式测试
 */
public class IoTest3 {

    public static void main(String[] args) throws IOException {
        //Stream<String> stream = Stream.of("1", "2", "3");
        //stream.filter(Pattern.compile("").asPredicate());

        //try(InputStream in = new BufferedInputStream(new FileInputStream(new File("testio.tmp")));
        //    OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("testout.md")))){
        //    int length;
        //    byte[] buffer = new byte[1024];
        //    while((length=in.read(buffer))!=-1){
        //        out.write(buffer, 0, length);
        //    }
        //
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //BufferedReader reader = new BufferedReader(new FileReader(new File("testio.tmp")));

        //按字符读取
        //int value;
        //while((value = reader.read()) != -1){
        //    char c = (char)value;
        //    System.out.println(c);
        //}
        //
        //System.out.println("=============");

        ////按行读取
        //String s;
        //while ((s = reader.readLine()) != null){
        //    System.out.println(s);
        //}
        //
        //reader.close();

        FileChannel in = new FileInputStream("testio.tmp").getChannel();
        FileChannel out = new FileOutputStream("testout.md").getChannel();

        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        //while (in.read(buffer) != -1){
        //    buffer.flip();
        //    out.write(buffer);
        //    buffer.clear();
        //}


        //使用零拷贝，kafka性能高的原因之一
        in.transferTo(0, in.size(), out);
    }
}
