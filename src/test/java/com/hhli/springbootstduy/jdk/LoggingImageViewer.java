package com.hhli.springbootstduy.jdk;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * @author 李辉辉
 * @date 2019/5/26 18:57
 * @description 将日志输出到窗口上
 */
public class LoggingImageViewer {

    public static void main(String[] args) {
        if(System.getProperty("java.util.logging.config.class")== null
                && System.getProperty("java.util.logging.config.file") != null){
            //注意报名与示例不同
            Logger.getLogger("com.hhli.springbootstduy.jdk").setLevel(Level.ALL);
            final  int LOG_ROTATION = 10;
            Handler handler = null;
            try {
                handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION);
                Logger.getLogger("com.hhli.springbootstduy.jdk").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("com.hhli.springbootstduy.jdk").log(Level.SEVERE, "can't create log handler", e);
            }

        }

        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.hhli.springbootstduy.jdk").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.hhli.springbootstduy.jdk").fine("show frame");
            frame.setVisible(Boolean.TRUE);
        });
    }
}



class ImageViewerFrame extends JFrame {

    private static final long serialVersionUID = -5209325431232445803L;

    private static final int DEFAULT_WIDTH = 300;

    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;

    private static Logger logger = Logger.getLogger("com.hhli.springbootstduy.jdk");
    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);

        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> {
            logger.fine("Exiting.");
            System.exit(0);
        });

        //use a label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);

            //set up file chooser;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            //show file choose dialog
            int r = fileChooser.showOpenDialog(ImageViewerFrame.this);
            if(r == JFileChooser.APPROVE_OPTION){
                String name = fileChooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            }else{
                logger.fine("file open dialog cancel...");
            }

            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed", e);
        }
    }
}

class WindowHandler extends StreamHandler{
    private JFrame frame;

    public WindowHandler(){
        frame = new JFrame();
        final JTextArea area = new JTextArea();
        area.setEnabled(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(area));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                area.append(new String(b, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord record){
        if(!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
