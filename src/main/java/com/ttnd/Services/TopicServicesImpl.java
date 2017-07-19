package com.ttnd.Services;

import com.ttnd.Entity.Topic;
import com.ttnd.dao.TopicDao;
import com.ttnd.dao.TopicDaoImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
@Service
public class TopicServicesImpl implements TopicServices {

    @Override
    public Boolean createTopic(Topic topic) {
        TopicDao topicDao=new TopicDaoImpl();
        return topicDao.createTopic(topic);
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
