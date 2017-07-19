package com.ttnd.controller;

import com.ttnd.Entity.Topic;
import com.ttnd.Entity.User;
import com.ttnd.Entity.Visibility;
import com.ttnd.Services.TopicServices;
import com.ttnd.Services.TopicServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

public class TopicController {
/*
    @Autowired
    TopicServices topicServices=new TopicServicesImpl();

    @RequestMapping("/create-topic")
    public void topicCreation(HttpServletRequest request, Topic topic, @RequestParam("visibility") String visibility){
        try {

            User user=(User)request.getSession();
            topic.setUser(user);
            topic.setDateCreated(Instant.now());
            if (visibility.equals("private")) {
                topic.setVisibility(Visibility.PRIVATE);
            } else {
                topic.setVisibility(Visibility.PUBLIC);
            }
            topicServices.createTopic(topic);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
