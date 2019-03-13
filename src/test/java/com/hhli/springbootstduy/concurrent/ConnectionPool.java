package com.hhli.springbootstduy.concurrent;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author 李辉辉
 * @date 2019/3/12 22:22
 * @description 连接池模拟
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                // 连接释放后 需要后续通知，这样其它消费者能够感知到连接池已经归还了连接
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(Long mills) throws InterruptedException {
        synchronized (pool){
            if(mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return  pool.removeFirst();
            }else{
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;

                //这里为啥写一个循环，为啥不直接if
                while (pool.isEmpty() && remaining>0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }

                Connection connection = null;
                if(!pool.isEmpty()){
                    connection = pool.removeFirst();
                }
                return connection;
            }

        }
    }
}
