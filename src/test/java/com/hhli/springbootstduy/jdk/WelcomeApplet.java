package com.hhli.springbootstduy.jdk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 李辉辉
 * @date 2018/11/3 15:54
 * @description the applet displays a greeting from the authors
 */
public class WelcomeApplet extends JApplet{

    private static final long serialVersionUID = 1820321616983523626L;

    public void init(){
        EventQueue.invokeLater(() -> {
            setLayout(new BorderLayout());

            JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 19));
            add(label, BorderLayout.CENTER);

            JPanel panel = new JPanel();

            JButton cayButton = new JButton("Cay Horstmann");
            cayButton.addActionListener(makeAction("http://www.horstmann.com"));
            panel.add(cayButton);

            JButton garyButton = new JButton("Gary Cornell");
            garyButton.addActionListener(makeAction("mailto:gray_cornell@apress.com"));

            add(panel, BorderLayout.SOUTH);
        });
    }

    private ActionListener makeAction(final String s) {
        return e -> {
            try {
                getAppletContext().showDocument(new URL(s));
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        };
    }
}
