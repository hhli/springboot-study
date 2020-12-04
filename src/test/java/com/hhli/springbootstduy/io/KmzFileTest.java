package com.hhli.springbootstduy.io;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author 李辉辉
 * @date 2020-12-02 10:32
 * @description
 */
public class KmzFileTest {

    public static Document unzipKmzToKmal(String filePath) throws Exception {

        File file = new File(filePath);

        try(ZipFile zipFile = new ZipFile(file);ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))){
            InputStream inputStream;
            ZipEntry entry;
            Document doc = null;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String zipEntryName = entry.getName();
                //获取所需文件的节点
                if (zipEntryName.contains("track.kml")) {
                    inputStream = zipFile.getInputStream(entry);
                    SAXReader reader = new SAXReader();
                    doc = reader.read(inputStream);

                    inputStream.close();
                }
            }

            return doc;
        }
    }

    public static Document unzip(String filePath) throws Exception {

        File file = new File(filePath);

        try(ZipFile zipFile = new ZipFile(file);ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))){
            ZipEntry entry = zipInputStream.getNextEntry();
            System.out.println(entry.getName());


            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println(entry.getName());
                if(!entry.getName().contains("结构信息")){
                    continue;
                }

                if(entry.isDirectory()){

                }
                InputStream inputStream = zipFile.getInputStream(entry);
                inputStream.close();
            }
        }

        return null;
    }


    public static Date getCreateTime2(String fullFileName){
        Path path= Paths.get(fullFileName);
        BasicFileAttributeView basicview= Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS );
        BasicFileAttributes attr;
        try {
            attr = basicview.readAttributes();
            Date createDate = new Date(attr.creationTime().toMillis());
            return createDate;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.set(1970, 0, 1, 0, 0, 0);
        return cal.getTime();
    }

    public static void main(String[] args) throws Exception {
        //unzip("/Users/lihuihui/Desktop/三叉戟/湘江楼.zip");
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime2("/Volumes/My Passport/天津/安琪花园/结构信息/A/20150111_114418.jpg"));
        System.out.println(str);
    }


}
