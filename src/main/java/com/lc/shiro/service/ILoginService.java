package com.lc.shiro.service;

import com.lc.shiro.beans.Role;
import com.lc.shiro.beans.User;

import java.util.Map;

public interface ILoginService {
    public User addUser(Map<String, Object> map);

    public Role addRole(Map<String, Object> map);

    public User findByName(String name);

}
