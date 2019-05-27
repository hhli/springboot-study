package com.hhli.springbootstduy.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author 李辉辉
 * @date 2019/5/24 8:35
 * @description 回调定时器测试
 */
public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        Timer timer = new Timer(10000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");

        System.exit(0);
    }

}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At this tone, the time is:" + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}