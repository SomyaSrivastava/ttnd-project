package com.ttnd.Services;

import com.ttnd.Entity.User;
import com.ttnd.dao.UserDao;
import com.ttnd.dao.UserDaoImpl;

public class UserServicesImple implements UserServices{

    private UserDao userdao;

    @Override
    public Boolean registerUser(User user) {
        userdao=new UserDaoImpl();
        return userdao.registerUser(user);
    }
    @Override
    public User loginUser(String username,String password){
        userdao = new UserDaoImpl();
        return userdao.loginUser(username,password);
    }
}
