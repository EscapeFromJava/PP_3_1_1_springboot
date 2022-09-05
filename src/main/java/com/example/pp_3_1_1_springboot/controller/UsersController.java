package com.example.pp_3_1_1_springboot.controller;

import com.example.pp_3_1_1_springboot.model.Car;
import com.example.pp_3_1_1_springboot.model.User;
import com.example.pp_3_1_1_springboot.service.CarService;
import com.example.pp_3_1_1_springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final CarService carService;

    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UsersController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("brands", carService.getAllCars()
                .stream()
                .map(Car::getBrand)
                .collect(Collectors.toSet()));
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("newUser") User newUser) {
        userService.saveUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        logger.info("test: " + user);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/generate")
    public String add10RandomUsers() {
        userService.addRandomUsers();
        return "redirect:/users";
    }

    @GetMapping("/truncate")
    public String truncateTable() {
        userService.truncateTable();
        return "redirect:/users";
    }

    @GetMapping("/filter/login")
    public String getUsersWithLogin(@RequestParam(value = "login", required = false) String login, Model model) {
        model.addAttribute("users", userService.getUsersWithLogin(login));
        return "users/filter";
    }

    @GetMapping("/filter/age")
    public String getUsersWithAgeBetweenMinAndMax(@RequestParam(value = "min") byte min,
                                                  @RequestParam(value = "max") byte max,
                                                  Model model) {
        model.addAttribute("users", userService.getUsersWithAgeBetweenMinAndMax(min, max));
        return "users/filter";
    }

}
