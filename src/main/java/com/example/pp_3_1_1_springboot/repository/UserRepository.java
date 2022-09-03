package com.example.pp_3_1_1_springboot.repository;

import com.example.pp_3_1_1_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
