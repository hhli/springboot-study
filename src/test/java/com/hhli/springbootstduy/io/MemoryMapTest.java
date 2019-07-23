package com.hhli.springbootstduy.io;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * @author 李辉辉
 * @date 2019-07-23 13:22
 * @description 内存映射文件测试
 */
public class MemoryMapTest{

    public static long checksumInputStream(Path fileName) throws IOException {
        try(InputStream in = Files.newInputStream(fileName)){
            CRC32 crc  = new CRC32();

            int c;
            while ((c = in.read()) != -1){
                crc.update(c);
            }

            return crc.getValue();

        }
    }

    public static long checkBufferedInputStream(Path fileName) throws IOException {
        try(InputStream in = new BufferedInputStream(Files.newInputStream(fileName))){
            CRC32 crc = new CRC32();

            int c;
            while((c = in.read()) != -1){
                crc.update(c);
            }

            return crc.getValue();
        }
    }


    public static long checksumRandomAccessFile(Path fileName) throws IOException {
        try(RandomAccessFile file = new RandomAccessFile(fileName.toFile(), "r")){
            long length = file.length();
            CRC32 crc = new CRC32();

            for (long i = 0; i < length; i++) {
                file.seek(i);
                int c = file.readByte();
                crc.update(c);
            }

            return crc.getValue();
        }
    }


    public static  long checksumMappedFile(Path fileName) throws IOException {
        try(FileChannel channel = FileChannel.open(fileName)){
            CRC32 crc = new CRC32();
            int length = (int)channel.size();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);

            for (int i = 0; i < length; i++) {
                int c = buffer.get(i);
                crc.update(c);
            }

            return crc.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get(args[0]);

        System.out.println("Input Stream:");
        long start = System.currentTimeMillis();
        long crcValue = checksumInputStream(fileName);
        System.out.println(Long.toHexString(crcValue));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Buffered Input Stream");

    }
}
