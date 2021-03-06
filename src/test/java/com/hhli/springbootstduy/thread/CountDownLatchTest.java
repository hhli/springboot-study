package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/2/18 20:37
 * @description
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        VideoConference videoConference = new VideoConference(10);
        Thread threadConference = new Thread(videoConference);
        threadConference.start();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Participant("P-" + i, videoConference));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }

}
