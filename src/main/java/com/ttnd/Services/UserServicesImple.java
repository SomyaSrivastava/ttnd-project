package com.ttnd.Services;

import com.ttnd.Entity.User;
import com.ttnd.dao.UserDao;
import com.ttnd.dao.UserDaoImpl;
import org.springframework.stereotype.Service;

@Service
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
    @Override
    public User getUserByEmail(String email){
        userdao = new UserDaoImpl();
        return userdao.getUserByEmail(email);
    }

    @Override
    public void updatePassword(User user){
        userdao = new UserDaoImpl();
        userdao.updatePassword(user);
    }
    @Override
    public User getUserByUsername(String userName){
        userdao = new UserDaoImpl();
        return userdao.getUserByUsername(userName);
    }
}
