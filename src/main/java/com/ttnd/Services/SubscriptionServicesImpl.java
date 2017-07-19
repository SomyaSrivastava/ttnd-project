package com.ttnd.Services;

import com.ttnd.Entity.Seriousness;
import com.ttnd.Entity.Topic;
import com.ttnd.Entity.User;
import com.ttnd.dao.SubscriptionDao;
import com.ttnd.dao.SubscriptionDaoImpl;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public class SubscriptionServicesImpl implements SubscriptionServices {
    public boolean subscribe(Topic topic, User user, Seriousness seriousness){
        SubscriptionDao subscriptionDao=new SubscriptionDaoImpl();
        return subscriptionDao.subscribe(topic,user,seriousness);
    }
}
