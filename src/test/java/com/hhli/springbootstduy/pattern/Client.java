package com.hhli.springbootstduy.pattern;

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



        //定义一个痴迷的玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);

        //开始打游戏 记下时间戳
        System.out.println("开始的时间是：2009-08-25 10：45");
        proxy.login("zhangsan", "password");
        //开始打怪
        proxy.killBoss();
        //升级
        proxy.upgrade();
        //记录游戏的结束时间
        System.out.println("解释时间是：20099-08-26 03:40");

    }
}
