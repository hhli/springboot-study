package com.hhli.springbootstduy.dao.impl;

import com.hhli.springbootstduy.dao.CompactDisc;
import com.hhli.springbootstduy.dao.MediaPlayer;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
