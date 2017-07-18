package com.ttnd.dao;

import com.ttnd.Entity.User;
import com.ttnd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public Boolean registerUser(User user) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            user.setDateCreated(new Date());
            session.save(user);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    public User loginUser(String username, String password) {
        User user=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "FROM User U  WHERE U.username = :username and  U.password =:password";
        Query query = session.createQuery(sql);
        query.setParameter("username",username);
        query.setParameter("password",password);
       try{
        Object queryResult = query.getSingleResult();
        if(queryResult!=null) {
            user = (User)queryResult;
            session.getTransaction().commit();
        }
       }catch (Exception e){
           return null;
       }
       return user;
    }
}
