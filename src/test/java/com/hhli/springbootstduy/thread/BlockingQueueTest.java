package com.hhli.springbootstduy.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author 李辉辉
 * @date 2019/7/14 14:57
 * @description 阻塞队列测试
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base directory (e.g.: /usr/local/jdk1.6.0/src):");
        String directory = scanner.nextLine();

        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = scanner.nextLine();

        //final int FILE_QUEUE_SIZE = 10;
        //BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
        //
        //FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
        //new Thread(enumerator).start();
        //
        //final int SEARCH_THREADS = 100;
        //for (int i = 0; i < SEARCH_THREADS; i++) {
        //    new Thread(new SearchTask(queue, keyword)).start();
        //}
        ExecutorService pool = Executors.newCachedThreadPool();
        MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
        //FutureTask<Integer> task = new FutureTask<>(counter);
        //Thread t = new Thread(task);
        //t.start();
        Future<Integer> result = pool.submit(counter);
        try {
            System.out.println(result.get() + " matching files.");
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();

        }

        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("largest pool size=" + largestPoolSize);
    }

}

class  FileEnumerationTask implements Runnable {

    public static File DUMY = new File("");

    private BlockingQueue<File> queue;
    private File startDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File startDirectory){
        this.queue = queue;
        this.startDirectory = startDirectory;
    }


    @Override
    public void run() {
        try {
            enumerate(startDirectory);
            queue.put(DUMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if(file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }
}


class SearchTask implements Runnable{
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword){
        this.queue = queue;
        this.keyword = keyword;
    }
    @Override
    public void run() {
        try{
            boolean done = false;
            while (!done){
                File file = queue.take();
                if(file == FileEnumerationTask.DUMY){
                    queue.put(file);
                    done = true;
                }else{
                    search(file);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {

        }
    }


    private void search(File file) throws FileNotFoundException {
        try(Scanner in = new Scanner(file)){
            int lineNumber = 0;
            while (in.hasNextLine()){
                String line  = in.nextLine();
                if(line.contains(keyword)){
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}

class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool){
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }


    @Override
    public Integer call()  {
        count = 0;
        //List<FutureTask<Integer>> results = new ArrayList<>();
        List<Future<Integer>> results = new ArrayList<>();
        try{
            File[]  files = directory.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    results.add(pool.submit(counter));
                    //FutureTask<Integer> task = new FutureTask<>(counter);
                    //results.add(task);
                    //Thread t = new Thread();
                    //t.start();
                }else{
                    if(search(file)) count++;
                }
                for (Future<Integer> result : results) {
                    count += result.get();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;
    }


    private boolean search(File file) throws FileNotFoundException {
        try(Scanner in = new Scanner(file)){
            while (in.hasNextLine()){
                String line  = in.nextLine();
                if(line.contains(keyword)){
                    return true;
                }
            }
        }
        return  false;
    }
}