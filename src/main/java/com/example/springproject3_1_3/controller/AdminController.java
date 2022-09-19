package com.example.springproject3_1_3.controller;

import com.example.springproject3_1_3.entity.User;
import com.example.springproject3_1_3.service.RoleService;
import com.example.springproject3_1_3.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAdminPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.allRoles());
        return "admin/adminPage";
    }

    @GetMapping("/add")
    public String newUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.allRoles());
        return "admin/newUser";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
                return "admin/newUser";
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/adminPage";
        }
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

//
//    @GetMapping("/showUsers")
//    public String usersList(ModelMap modelMap) {
//        modelMap.addAttribute("users", userService.getAllUsers());
//        modelMap.addAttribute("roles", roleService.allRoles());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        modelMap.addAttribute("authUser", (User) auth.getPrincipal());
//        return "userList";
//    }
//
//    @GetMapping("/addUser")
//    public String addUser(ModelMap model) {
//        model.addAttribute("roles", roleService.allRoles());
//        model.addAttribute("user", new User());
//        return "addUser";
//    }
//
//
//    @PostMapping()
//    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//                return "addUser";
//        }
//        userService.addUser(user);
//        return "redirect:/admin/showUsers";
//    }
//
//    @DeleteMapping("/{id}")
//    public String getUser(@PathVariable("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin/showUsers";
//    }
//
//    @GetMapping("/{id}/updateUser")
//    public String update(@PathVariable("id") long id, ModelMap model) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("roleList", roleService.allRoles());
//        return "updateUser";
//    }
//
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "updateUser";
//        }
//        userService.updateUser(user);
//        return "redirect:/admin/showUsers";
//    }
}
