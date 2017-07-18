package com.ttnd.Services;

import com.ttnd.Entity.User;

public interface UserServices {
    public Boolean registerUser(User user);
    public User loginUser(String username,String password);
}