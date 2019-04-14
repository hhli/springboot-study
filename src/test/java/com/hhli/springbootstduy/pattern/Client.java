package com.hhli.springbootstduy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 李辉辉
 * @date 2019-04-12 17:35
 * @description 场景类
 */
public class Client {

    public static void main(String[] args) {
        ////定义一个痴迷的玩家
        //IGamePlayer player = new GamePlayer("张三");
        ////开始打游戏 记下时间戳
        //System.out.println("开始的时间是：2009-08-25 10：45");
        //player.login("zhangsan", "password");
        ////开始打怪
        //player.killBoss();
        ////升级
        //player.upgrade();
        ////记录游戏的结束时间
        //System.out.println("解释时间是：20099-08-26 03:40");



        ////定义一个痴迷的玩家
        //IGamePlayer player = new GamePlayer("张三");
        ////定义一个代练者
        //IGamePlayer proxy = new GamePlayerProxy(player);
        //
        ////开始打游戏 记下时间戳
        //System.out.println("开始的时间是：2009-08-25 10：45");
        //proxy.login("zhangsan", "password");
        ////开始打怪
        //proxy.killBoss();
        ////升级
        //proxy.upgrade();
        ////记录游戏的结束时间
        //System.out.println("解释时间是：20099-08-26 03:40");

        // 定义一个痴迷的玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个handler
        InvocationHandler handler = new GamePlayerIH(player);
        //开始打游戏，记录下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        //获得类的class loader
        ClassLoader c1 = player.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(c1, new Class[]{IGamePlayer.class}, handler);

        //登录
        proxy.login("zhangSan", "password");

        //开始杀怪
        proxy.killBoss();

        //升级
        proxy.upgrade();

        //记录游戏结束的时间
        System.out.println("解释时间是：20099-08-26 03:40");
    }
}
