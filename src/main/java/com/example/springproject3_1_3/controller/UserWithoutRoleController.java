package com.example.springproject3_1_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userWithoutRole")
public class UserWithoutRoleController {
    @GetMapping
    public String getPage () {
        return "userWithoutRole";
    }
}
