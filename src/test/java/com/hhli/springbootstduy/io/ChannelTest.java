package com.hhli.springbootstduy.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author 李辉辉
 * @date 2020-07-12 12:00
 * @description channel测试
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException {
        //try(RandomAccessFile aFile = new RandomAccessFile("testio.tmp", "rw")){
        //    FileChannel inChannel = aFile.getChannel();
        //
        //    ByteBuffer buf = ByteBuffer.allocate(48);
        //    int byteRed = inChannel.read(buf);
        //    while (byteRed != -1){
        //        System.out.println("Read" + byteRed);
        //        buf.flip();
        //
        //        //System.out.println((char)buf.get());
        //
        //        while (buf.hasRemaining()){
        //            System.out.print((char)buf.get());
        //            buf.rewind();
        //        }
        //
        //        //buf.clear();
        //        buf.compact();
        //        byteRed = inChannel.read(buf);
        //    }
        //}

        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        //toChannel.transferFrom(fromChannel, position, count);
        fromChannel.transferTo(position, count, toChannel);
    }
}
