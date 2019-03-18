package com.hhli.springbootstduy.concurrent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李辉辉
 * @date 2019/3/16 16:36
 * @description 简单的web服务器
 */
public class SimpleHttpServer {
    //处理HttpRequest的线程池
    static DefaultThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);

    //根路径
    static String basePath;

    static ServerSocket serverSocket;
    //服务监听端口
    static int port = 8080;

    public  static  void setPort(int port){
        if(port > 0){
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath){
        if(basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    //启动SimpleHttpServer
    public  static void start() throws IOException {
        serverSocket = new ServerSocket(port);

        Socket socket = null;
        while ((socket = serverSocket.accept()) != null){
            threadPool.execute(new HttpRequestHandler(socket));
        }

        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable{
        private Socket socket;
        public HttpRequestHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                //由相对路径计算初绝对路径
                String filePath = basePath + header.split(" ")[1];
                out  = new PrintWriter(socket.getOutputStream());

                //如果请求资源的后缀为jpg或者ico，则读取资源并输出
                if(filePath.endsWith("jpg") || filePath.endsWith("ico")){
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while((i = in.read()) != -1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-type: image/jpeg");
                    out.println("Content-Length:"+ array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                }else{
                    br = new BufferedReader(new InputStreamReader((new FileInputStream(filePath))));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while((line = br.readLine()) != null){
                        out.print(line);
                    }
                }
                out.flush();
            }catch(Exception e){
                out.println("HTTP/1.1 500 ");
                out.println("");
                out.flush();
            }finally {
                {
                    close(br, in , reader, out, socket);
                }
            }
        }
        
        private static  void close(Closeable... closeables){
            if(closeables != null){
                for (Closeable closeable : closeables) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
