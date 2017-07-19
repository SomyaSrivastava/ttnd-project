package com.ttnd.Services;

import com.ttnd.Entity.Topic;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public interface TopicServices {
    public Boolean createTopic(Topic topic);
    public Boolean deleteTopic(Topic topic);
    public Topic get(int id);
}
