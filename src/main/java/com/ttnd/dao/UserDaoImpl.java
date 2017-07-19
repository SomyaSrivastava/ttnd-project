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

//        ---search by username----
        user=this.getUserByUsername(username);
        if (user==null){
            user=this.getUserByEmail(username);}
        if (user!=null){
            if(user.getPassword().equals(password))
                return user;
        }
        return user;
    }
    @Override
    public User getUserByEmail(String email) {
        User user=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "FROM User U  WHERE U.email = :email";
        Query query = session.createQuery(sql);
        query.setParameter("email",email);

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
    @Override
    public void updatePassword(User user){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public User getUserByUsername(String userName){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            User user = (User) session.get(User.class, userName);
            session.getTransaction().commit();
            return user;
        }catch(Exception e){
            return null;
        }
    }

}
