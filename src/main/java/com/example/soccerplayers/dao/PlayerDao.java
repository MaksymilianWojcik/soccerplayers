package com.example.soccerplayers.dao;

import com.example.soccerplayers.model.Player;

import java.util.List;

/**
 * Created by MAKS on 10.05.2017.
 */
public interface PlayerDao {
    void save(Player player);
    List<Player> showAll();
    List<Player> findByName(String name);
    List<Player> findByPosition(String positioon);
}
