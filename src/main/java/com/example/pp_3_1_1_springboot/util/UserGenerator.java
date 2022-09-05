package com.example.pp_3_1_1_springboot.util;

import com.example.pp_3_1_1_springboot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator {
    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String firstName = FirstName.values()[new Random().nextInt(FirstName.values().length)].name();
            String secondName = SecondName.values()[new Random().nextInt(SecondName.values().length)].name();
            String login = firstName.concat(String.valueOf(new Random().nextInt(111, 999)));
            String password = String.valueOf(new Random().nextInt(1000, 99999999));
            byte age = (byte) new Random().nextInt(18, 80);
            String email = firstName.concat(".").concat(secondName).concat("@gmail.com").toLowerCase();
            User user = new User(login, password, firstName, secondName, age, email);
            users.add(user);
        }
        return users;
    }
    enum FirstName {
        Jose,
        Earl,
        Willie,
        Jesse,
        Patrick,
        Fred,
        Steven,
        Jerry,
        Samuel,
        Gene,
    }
    enum SecondName {
        Sullivan,
        Moreno,
        Hughes,
        Lopez,
        Hale,
        Wilkerson,
        Farmer,
        Holmes,
        Wood,
        Thompson
    }
}
