package com.ttnd.micro_services;

/**
 * Created by Lenovo-1 on 18-07-2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MailNotification {
    @Autowired
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String from, String to, String subject, String msg) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);

        mailSender.send(message);
    }
    public String notifyEmail(String email){
        try{
            String sender="somya777.srivastava@gmail.com";
            String receiver=email;
            String otp  =  generateOTP();
            // save access token in db
            // add link
            String link="http://localhost:8088/linkToChangePassword/"+email+"/"+otp;
            String body="Please follow the below link to change the password.If you have'nt requested for password reset then ignore this mail.Thank you."+"        "+link;
            this.sendMail(sender,receiver,"Link Sharing - password reset",body);
            return otp;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String generateOTP()
    {
        int randomPIN = (int)(Math.random()*9000)+1000;
        String otp = String.valueOf(randomPIN);
        return otp;
    }
}
