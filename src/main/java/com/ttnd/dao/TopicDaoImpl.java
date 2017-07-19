package com.ttnd.dao;

import com.ttnd.Entity.Topic;
import com.ttnd.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public class TopicDaoImpl implements TopicDao
{

    @Override
    public Boolean createTopic(Topic topic) {
        try{
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(topic);
        session.getTransaction().commit();
        return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteTopic(Topic topic) {
        return null;
    }

    @Override
    public Topic get(int id) {
        return null;
    }
}
