package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019-04-12 17:22
 * @description 游戏者接口
 */
public interface IGamePlayer {

    /**
     * 登录游戏
     * @param user
     * @param password
     */
    void login(String user, String password);

    /**
     * 杀怪，网络游戏的主要特色
     */
    void killBoss();

    /**
     * 升级
     */
    void upgrade();
}
