package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019-04-12 17:47
 * @description 代练者
 */
public class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer player;

    public GamePlayerProxy(IGamePlayer player){
        this.player = player;
    }
    @Override
    public void login(String user, String password) {
        this.player.login(user, password);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
