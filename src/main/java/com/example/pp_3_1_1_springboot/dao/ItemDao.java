package com.example.pp_3_1_1_springboot.dao;

import com.example.pp_3_1_1_springboot.model.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getItemsByUserId(Long id);

}
