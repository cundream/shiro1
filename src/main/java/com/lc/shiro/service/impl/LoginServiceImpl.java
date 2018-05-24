package com.lc.shiro.service.impl;

import com.lc.shiro.beans.Permission;
import com.lc.shiro.beans.Role;
import com.lc.shiro.beans.User;
import com.lc.shiro.repository.RoleRepository;
import com.lc.shiro.repository.UserRepository;
import com.lc.shiro.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Role addRole(Map<String, Object> map) {
        User user = userRepository.findOne(Long.valueOf(map.get("userId").toString()));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
