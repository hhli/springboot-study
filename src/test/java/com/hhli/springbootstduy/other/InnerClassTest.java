package com.hhli.springbootstduy.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author 李辉辉
 * @date 2019/5/24 9:01
 * @description
 */
public class InnerClassTest {

    public static void main(String[] args) {
        System.out.println(new Object(){}.getClass().getEnclosingClass().getName());
        /**
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        //TalkingClock.TimePrinter printer =  clock.new TimePrinter();

        JOptionPane.showMessageDialog(null, "Quit program?");

        System.exit(0);
         *
         */
    }
}

class TalkingClock{
    //private int interval;
    //
    //private boolean beep;
    //
    //public TalkingClock(int interval, boolean beep){
    //    this.interval = interval;
    //    this.beep = beep;
    //}

    public void start(int interval, boolean beep){
        //class TimePrinter implements ActionListener {
        //
        //    @Override
        //    public void actionPerformed(ActionEvent e) {
        //        System.out.println("At this tone, the time is:" + new Date());
        //        if(beep){
        //
        //        }
        //
        //        if(beep) {
        //            Toolkit.getDefaultToolkit().beep();
        //        }
        //    }
        //}
        ActionListener listener = e -> {
            System.out.println("At this tone, the time is:" + new Date());
            if(beep){

            }

            if(beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        };
        //ActionListener listener = this.new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    //class TimePrinter implements ActionListener {
    //
    //    @Override
    //    public void actionPerformed(ActionEvent e) {
    //        System.out.println("At this tone, the time is:" + new Date());
    //        if(beep){
    //
    //        }
    //
    //        if(TalkingClock.this.beep) {
    //            Toolkit.getDefaultToolkit().beep();
    //        }
    //    }
    //}
}
