package com.nokia.example.model;

import com.nokia.example.annotation.Game;

/**
 * @author by YingLong on 2020/10/26
 */
public class PlayGame {
    @Game(value = "LOL")
    @Game(value = "PUBG")
    @Game(value = "NFS")
    @Game(value = "Dirt4")
    public void play() {
    }
}
