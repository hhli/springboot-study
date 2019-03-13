package com.hhli.springbootstduy.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author 李辉辉
 * @date 2019/3/12 8:57
 * @description
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);

        Thread printThread = new Thread(new Print(in), "printThread");
        printThread.start();

        int receive;
        try {
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
            in.close();
        }
    }

    static  class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int receive;
            try{
                while ((receive=in.read()) !=-1){
                    System.out.println((char)receive);
                }
            }catch (IOException ex){

            }
        }
    }
}
