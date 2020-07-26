package com.hhli.springbootstduy.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2020-07-12 12:00
 * @description channel测试
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException, InterruptedException {
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

        //RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        //FileChannel fromChannel = fromFile.getChannel();

        //RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        //FileChannel toChannel = toFile.getChannel();
        //
        //long position = 0;
        //long count = fromChannel.size();

        //toChannel.transferFrom(fromChannel, position, count);
        //fromChannel.transferTo(position, count, toChannel);
        //
        //fromChannel.truncate(16);
        //ByteBuffer buf = ByteBuffer.allocate(48);
        //while (fromChannel.read(buf) != -1){
        //    buf.flip();
        //
        //    while (buf.hasRemaining()){
        //        System.out.print((char)buf.get());
        //    }
        //
        //    buf.clear();
        //}


        //String newData = "\r\nNew String to write to file..." + System.currentTimeMillis();
        //buf.put(newData.getBytes(StandardCharsets.UTF_8));
        //buf.flip();
        //
        //fromChannel.position(newData.length());
        //while (buf.hasRemaining()){
        //    fromChannel.write(buf);
        //}

        //fromChannel.close();

        //System.out.println(Paths.get("/Users/lihuihui/Documents", "temp"));

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm_ss_SSS");
        //System.out.println(dtf.format(LocalDateTime.now()));

        //Path path = Paths.get(".", "hdicGateway", LocalDate.now().toString());


        //try{
        //    if(!path.toFile().exists()){
        //        Files.createDirectories(path);
        //    }
        //
        //    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm_ss_SSS");
        //    path = Paths.get(path.toString(), dtf.format(LocalDateTime.now())+".txt");
        //
        //    Files.createFile(path);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}


        //new Thread(()->{
        //    synchronized (Object.class){
        //        while (true){
        //        }
        //    }
        //}).start();
        //
        //new Thread(()->{
        //    synchronized (Object.class){
        //        while (true){
        //        }
        //    }
        //}).start();
        //
        //new Thread(LockSupport::park).start();
        //
        //new Thread(()->{
        //    synchronized (Object.class){
        //        while (true){
        //
        //        }
        //    }
        //}).start();
        //
        //
        //TimeUnit.SECONDS.sleep(1000000);
        //
        //ReentrantLock lock = new ReentrantLock();
        //
        //new Thread(()->{
        //    lock.lock();
        //    try {
        //        TimeUnit.SECONDS.sleep(1000000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //
        //    lock.unlock();
        //}).start();
        //
        //
        //new Thread(()->{
        //    lock.lock();
        //    try {
        //        TimeUnit.SECONDS.sleep(1000000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //
        //    lock.unlock();
        //}).start();

        //SocketChannel channel = SocketChannel.open();
        //channel.configureBlocking(false);
        //channel.connect(new InetSocketAddress("tutorials.jenkov.com", 80));
        //
        //ByteBuffer buf = ByteBuffer.allocate(48);
        //while (channel.read(buf) != -1){
        //    buf.flip();
        //
        //    while (buf.hasRemaining()){
        //        System.out.print((char)buf.get());
        //    }
        //    System.out.println();
        //
        //    buf.clear();
        //}
        //
        //channel.close();

        //final Pipe pipe = Pipe.open();
        //new Thread(()->{
        //    String newData = "New String to write to file..." + System.currentTimeMillis();
        //
        //    ByteBuffer  buf = ByteBuffer.allocate(48);
        //    buf.put(newData.getBytes());
        //    buf.flip();
        //
        //    Pipe.SinkChannel sink = pipe.sink();
        //    while (buf.hasRemaining()){
        //        try {
        //            sink.write(buf);
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //    try {
        //        sink.close();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //
        //new Thread(()->{
        //    Pipe.SourceChannel source = pipe.source();
        //
        //    ByteBuffer  buf = ByteBuffer.allocate(48);
        //
        //    while (true){
        //        try {
        //            if (source.read(buf) == -1) break;
        //
        //            buf.flip();
        //            while (buf.hasRemaining()){
        //                System.out.print((char)buf.get());
        //            }
        //
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }finally {
        //            buf.clear();
        //        }
        //    }
        //
        //    try {
        //        source.close();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //    System.out.println();
        //}).start();
        //
        //TimeUnit.SECONDS.sleep(2);
        //System.out.println("done~~");

        //Path path = Paths.get("testio.tmp");
        //try(AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)){
        //    ByteBuffer buffer = ByteBuffer.allocate(1024);
        //
        //    long position = 0;
        //    Future<Integer> read = channel.read(buffer, position);
        //    while (!read.isDone());
        //
        //
        //    buffer.flip();
        //    byte[] data = new byte[buffer.limit()];
        //    buffer.get(data);
        //
        //    System.out.println(new String(data));
        //
        //    buffer.clear();
        //

        //Path path = Paths.get("testio.tmp");
        //AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        //long position = 0;
        //
        //channel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
        //    @Override
        //    public void completed(Integer result, ByteBuffer attachment) {
        //        System.out.println("result = " + result);
        //
        //        attachment.flip();
        //        byte[] data = new byte[attachment.limit()];
        //        attachment.get(data);
        //        System.out.println(new String(data));
        //        attachment.clear();
        //    }
        //
        //    @Override
        //    public void failed(Throwable exc, ByteBuffer attachment) {
        //
        //    }
        //});

        //Path path = Paths.get("testio.tmp");
        //try(AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE)) {
        //    ByteBuffer buffer = ByteBuffer.allocate(1024);
        //    buffer.put("test data".getBytes());
        //    buffer.flip();
        //
        //    long position = 0;
        //    Future<Integer> write = channel.write(buffer, position);
        //    while (!write.isDone()) ;
        //
        //    System.out.println("write done");
        //}

        Path path = Paths.get("testio.tmp");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("test data1111".getBytes());
        buffer.flip();

        long position = 0;

        channel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("byte writes:" + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed!!");
                exc.printStackTrace();
            }
        });

        TimeUnit.SECONDS.sleep(1);
    }
}
