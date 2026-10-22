package org.example.fashionandlifestyle.controller;

import lombok.RequiredArgsConstructor;
import org.example.fashionandlifestyle.dto.UserDTO;
import org.example.fashionandlifestyle.entity.Users;
import org.example.fashionandlifestyle.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userSer;

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("listUsers", userSer.findAll());
        return "Users/list";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam Long id, Model model){
        model.addAttribute("user", userSer.findById(id));
        return "Users/user";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String passWord,
                        Model model){

        try{
            UserDTO entity = userSer.login(email, passWord);
            model.addAttribute("user", entity);
        }catch (RuntimeException e){
            model.addAttribute("error", e.getMessage());
            model.addAttribute("email", email);
        }
    }
}
