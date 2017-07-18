package com.ttnd.dao;

import com.ttnd.Entity.User;

public interface UserDao {
    public Boolean registerUser(User user);
    public User loginUser(String username,String password);
}
