package com.lc.shiro.repository;

import com.lc.shiro.beans.User;

public interface UserRepository extends BaseRepository<User,Long> {
    User findByName(String name);
}
