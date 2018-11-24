package com.hhli.springbootstduy.other;

import java.io.*;
import java.util.*;

/**
 * @author 李辉辉
 * @date 2018/11/23 16:15
 * @description 根据文件生成sql
 */
public class FileGenerateSql {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("applyPlus.sql"), "utf-8"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(FileGenerateSql.class.getResourceAsStream("/TaskId_DataSource_Address.csv")));

        generateSql(reader, writer);
        reader.close();

        reader = new BufferedReader(new InputStreamReader(FileGenerateSql.class.getResourceAsStream("/TaskId_DataSource_Attribute.csv")));
        generateSql(reader, writer);
        reader.close();

        reader = new BufferedReader(new InputStreamReader(FileGenerateSql.class.getResourceAsStream("/TaskId_DataSource_CompetingStore.csv")));
        generateSql(reader, writer);
        reader.close();

        reader = new BufferedReader(new InputStreamReader(FileGenerateSql.class.getResourceAsStream("/TaskId_DataSource_FeedBack.csv")));
        generateSql(reader, writer);
        reader.close();

        writer.flush();
        writer.close();
    }


    public static void generateSql(BufferedReader reader, BufferedWriter writer) throws IOException {
        String str = null;

        Map<String, List<Long>> tempMap = new HashMap<>(4);
        while ((str = reader.readLine()) != null){
            String[] temp = str.split("\t");
            Long applyId = Long.parseLong(temp[0]);
            String dataSource = temp[1];
            if(tempMap.containsKey(dataSource)){
                tempMap.get(dataSource).add(applyId);
            }else{
                List<Long> idList = new ArrayList<>();
                idList.add(applyId);
                tempMap.put(dataSource, idList);
            }

        }

        Set<String> stringSet = tempMap.keySet();
        for(String strKey : stringSet){
            List<Long> idList = tempMap.get(strKey);
            int times = idList.size() % 1000 == 0 ? idList.size() / 1000 : idList.size() / 1000 + 1;

            for(int i = 0; i<times; i++){
                StringBuilder sb  = new StringBuilder();
                sb.append("UPDATE t_tpl_apply SET data_source='").append(strKey).append("' WHERE id IN (");
                int begin =  i * 1000;
                int end = (i+1) * 1000;
                if( end > idList.size()){
                    end = idList.size();
                }
                List<Long>  subIdList = idList.subList(begin , end);
                sb.append(subIdList.toString().replace("[", "").replace("]", ""));
                sb.append(");");
                System.out.println(sb.toString());
                writer.write(sb.toString());
                writer.newLine();
            }
        }

    }
}
