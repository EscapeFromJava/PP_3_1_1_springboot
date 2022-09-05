package com.example.pp_3_1_1_springboot.dao;

import com.example.pp_3_1_1_springboot.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    private final EntityManager entityManager;

    public ItemDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Item> getItemsByUserId(Long id) {
        return entityManager.createQuery("SELECT i FROM Item i WHERE i.owner = :id", Item.class)
                .setParameter("id", id)
                .getResultList();
    }
}
