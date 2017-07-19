package com.ttnd.dao;

import com.ttnd.Entity.Seriousness;
import com.ttnd.Entity.Subscription;
import com.ttnd.Entity.Topic;
import com.ttnd.Entity.User;
import com.ttnd.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public class SubscriptionDaoImpl implements SubscriptionDao {
    @Override
    public boolean subscribe(Topic topic, User user, Seriousness seriousness) {
        try{
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Subscription subscription=new Subscription();
        subscription.setSeriousness(seriousness);
        subscription.setCreatedDate(new Date());
        subscription.setUser(user);
        subscription.setTopic(topic);
        session.save(subscription);
        session.getTransaction().commit();
        return true;
    } catch (Exception e){
        e.printStackTrace();
        return false;
    }
    }
}
