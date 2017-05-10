package com.example.soccerplayers.controller;

import com.example.soccerplayers.dao.PlayerDao;
import com.example.soccerplayers.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by MAKS on 10.05.2017.
 */

@Controller
public class PlayerControler {

    @Autowired
    PlayerDao playerDao;

    @GetMapping("/player/add")
    public String addPlayer(ModelMap modelMap){
        modelMap.addAttribute("player", new Player());
        return "player/add";
    }


    @PostMapping("/player/create")
    public String createPlayer(@ModelAttribute Player player, ModelMap modelMap){
        //dodajemy do bazy danych
        playerDao.save(player);
        return "redirect:/player/success";
    }

    @GetMapping("/player/success")
    public String success(){
        return "player/success";
    }


    @GetMapping("/player/showall")
    public String showAll(ModelMap modelMap){
        modelMap.addAttribute("players", playerDao.showAll());
        return "player/showall";
    }


    @GetMapping("/player/searchbyname")
    public String searchByName(ModelMap modelMap){
        modelMap.addAttribute("player", new Player());
        return "/player/searchbyname";
    }

    @PostMapping("/player/result")
    public String result(@ModelAttribute Player player, ModelMap modelMap){
        String name = player.getName();
        List<Player> players = playerDao.findByName(name);
        modelMap.addAttribute("players", players);
        return "player/showall";
    }

    @GetMapping("/player/searchbyposition")
    public String searchByPosition(ModelMap modelMap){
        modelMap.addAttribute("player", new Player());
        return "/player/searchbyposition";
    }

    @PostMapping("player/resultbyposition")
    public String resultbyposition(@ModelAttribute Player player, ModelMap modelMap){
        String position = player.getPosition();
        List<Player> players = playerDao.findByPosition(position);
        modelMap.addAttribute("players", players);
        return "player/showall";
    }



}
