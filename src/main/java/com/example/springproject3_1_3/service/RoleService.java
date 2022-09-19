package com.example.springproject3_1_3.service;


import com.example.springproject3_1_3.entity.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();

}
