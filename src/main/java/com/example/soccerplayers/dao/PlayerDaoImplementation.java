package com.example.soccerplayers.dao;

import com.example.soccerplayers.model.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MAKS on 10.05.2017.
 */

@Repository
public class PlayerDaoImplementation implements PlayerDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Player player) {
        entityManager.persist(player);
    }



    @Override
    @Transactional
    public List<Player> showAll() {
        Query query = entityManager.createQuery("Select p From Player p");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Player> findByName(String name) {
        Query query = entityManager.createQuery("Select p From Player p WHERE p.name='"+name+"'");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Player> findByPosition(String position) {
        Query query = entityManager.createQuery("Select p From Player p WHERE p.position='"+position+"'");

        return query.getResultList();
    }
}
