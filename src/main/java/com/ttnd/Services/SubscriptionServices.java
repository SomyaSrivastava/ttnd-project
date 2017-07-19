package com.ttnd.Services;

import com.ttnd.Entity.Seriousness;
import com.ttnd.Entity.Topic;
import com.ttnd.Entity.User;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public interface SubscriptionServices {
    public boolean subscribe(Topic topic, User user, Seriousness seriousness);
}
