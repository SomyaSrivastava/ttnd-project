package com.ttnd.Services;

import com.ttnd.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserServices {
    public Boolean registerUser(User user);
    public User loginUser(String username,String password);
    public User getUserByEmail(String email) ;
    public void updatePassword(User user);
    public User getUserByUsername(String userName);

}