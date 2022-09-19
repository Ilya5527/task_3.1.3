package com.example.springproject3_1_3.service;

import com.example.springproject3_1_3.entity.Role;
import com.example.springproject3_1_3.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    @Override
    public Role getRoleByName(String name) {
        Optional<Role> optional = roleRepository.findByName(name);

        if (optional.isEmpty()) {
            throw new NullPointerException("Такой роли не существует!");
        }

        return optional.get();
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> optional = roleRepository.findById(id);

        if (optional.isEmpty()) {
            throw new NullPointerException("Такой роли не существует");
        }

        return optional.get();
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

}
