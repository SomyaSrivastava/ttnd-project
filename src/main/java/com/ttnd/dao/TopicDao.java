package com.ttnd.dao;

import com.ttnd.Entity.Topic;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public interface TopicDao {

   public Boolean createTopic(Topic topic);
   public Boolean deleteTopic(Topic topic);
   public Topic get(int id);
}
