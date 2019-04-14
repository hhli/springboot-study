package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/14 15:43
 * @description
 */
public class GamePlayerProxy2 implements IGamePlayer{
    private IGamePlayer gamePlayer = null;

    public GamePlayerProxy2(String name) throws Exception {
        this.gamePlayer = new GamePlayer2(this, name);
    }
    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
