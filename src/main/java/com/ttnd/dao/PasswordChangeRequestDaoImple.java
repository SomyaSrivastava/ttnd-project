package com.ttnd.dao;

import com.ttnd.Entity.PasswordChangeRequest;
import com.ttnd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public class PasswordChangeRequestDaoImple implements PasswordChangeRequestDao {
    @Override
    public Boolean save(PasswordChangeRequest passwordChangeRequest) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(passwordChangeRequest);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    public PasswordChangeRequest get(String email,String token) {
        PasswordChangeRequest passwordChangeRequest=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            passwordChangeRequest=session.get(PasswordChangeRequest.class,email);
            if (!passwordChangeRequest.getId().equals(token)){
                passwordChangeRequest=null;
            }
                session.getTransaction().commit();
            } catch (Exception e){
         e.printStackTrace();
        }
        return passwordChangeRequest;
    }

    @Override
    public void delete(PasswordChangeRequest passwordChangeRequest){

        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            session.delete(passwordChangeRequest);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}


