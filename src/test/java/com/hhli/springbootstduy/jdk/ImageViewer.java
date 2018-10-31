package com.hhli.springbootstduy.jdk;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author 李辉辉
 * @date 2018/10/31 8:44
 * @description
 */
public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class ImageViewerFrame extends JFrame{
        private static final long serialVersionUID = -5209325431232445803L;

        private JLabel label;
        private JFileChooser chooser;
        private static  final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 400;

        public ImageViewerFrame(){
            // use a label to display images
            label = new JLabel();
            add(label);

            //set up the file chooser
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            //set up the menu bar
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu menu = new JMenu("File");
            menuBar.add(menu);

            JMenuItem openItem = new JMenuItem("open");
            menu.add(openItem);

            openItem.addActionListener(e -> {
                //show file choose dialog
                int result = chooser.showOpenDialog(null);
                //if file selected, set it as icon of the label
                if(result == JFileChooser.APPROVE_OPTION){
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));

                }
            });


            JMenuItem exitItem = new JMenuItem("exit");
            menu.add(exitItem);
            exitItem.addActionListener(e -> System.exit(0));

        }
}

