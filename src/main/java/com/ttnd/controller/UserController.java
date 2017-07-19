package com.ttnd.controller;
import com.ttnd.Entity.PasswordChangeRequest;
import com.ttnd.Entity.User;
import com.ttnd.Services.PasswordChangeRequestServices;
import com.ttnd.Services.PasswordChangeRequestServicesImpl;
import com.ttnd.Services.UserServices;
import com.ttnd.Services.UserServicesImple;
import com.ttnd.micro_services.MailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.SendFailedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserServices userServices = new UserServicesImple();
    @Autowired
    MailNotification mailNotification;
    @Autowired
    PasswordChangeRequestServices passwordChangeRequestServices=new PasswordChangeRequestServicesImpl();
//----------------------index------------------------
    @RequestMapping("/")
    ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("dashboard");
            return modelAndView;
        }

    }

//  ----------------------Dashboard------------------------
    @ResponseBody
    @RequestMapping(value = "/dashboard")
    ModelAndView dashboard(HttpServletRequest request,HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("index");
        }
        else
            return new ModelAndView("dashboard");
        }


//    --------------------Register-----------------------------
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView register(HttpServletRequest request, @ModelAttribute("User") User user, @RequestParam("file") MultipartFile file) throws Exception {

        if (!file.isEmpty()) {
            byte[] photo = null;
            photo = file.getBytes();
            user.setPhoto(photo);
        }

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (userServices.registerUser(user)) {
                request.getSession().setAttribute("user", user);
                return new ModelAndView("dashboard");

            } else {
                ModelAndView modelAndView = new ModelAndView("index");
                modelAndView.addObject("registration", "This username or email is already taken!");
                return modelAndView;
            }
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("registration", "Passwords do not match !");
            return modelAndView;

        }

    }

//    ------------------------login---------------------------------

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        User user = userServices.loginUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return new ModelAndView("dashboard");
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("LoginMessage", "Wrong credentials !");
            return modelAndView;
        }
    }

//    -----------------------password reset----------------------------

    @RequestMapping(value="/email-notification",method=RequestMethod.POST)
    public ModelAndView reset(HttpServletRequest request,@RequestParam String email){

        ModelAndView modelAndView=new ModelAndView("password-reset");

        try{
            User user=(User)userServices.getUserByEmail(email);
            if (user!=null)
            {
                String otp=mailNotification.notifyEmail(email);

                PasswordChangeRequest passwordChangeRequest=new PasswordChangeRequest();
                passwordChangeRequest.setTime(Instant.now());
                passwordChangeRequest.setEmail(email);
                passwordChangeRequest.setId(otp);
                passwordChangeRequestServices.save(passwordChangeRequest);

            modelAndView.addObject("msg","Please check your mail and click the link to update password.");
            }else {
                modelAndView.addObject("msg","This email address does not exists.");
            }
        }
        catch (Exception e){
            modelAndView.addObject("msg","This email address does not exists.");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(value="/reset")
    public ModelAndView reset(){
        return new ModelAndView("password-reset");
    }

    @RequestMapping(value = "password_update",method= RequestMethod.POST)
    public ModelAndView password_update(@RequestParam("email") String email,@RequestParam("pswd") String password){
//        --------password update----
        User user=(User)userServices.getUserByEmail(email);
        if (user!=null) {
            user.setPassword(password);
            userServices.updatePassword(user);
            return new ModelAndView("index","LoginMessage","Password updated.");
        }
        return new ModelAndView("index","LoginMessage","Password cannot be updated.");

    }



    @RequestMapping(value="/linkToChangePassword/{email}/{otp}")
    public ModelAndView accessUpdate(@PathVariable("otp") String token,@PathVariable("email") String email ){
        try{
        System.out.println(token+"-------------"+email);

        PasswordChangeRequest passwordChangeRequest=(PasswordChangeRequest)passwordChangeRequestServices.get(email,token);

        System.out.println(passwordChangeRequest);

        Instant start=passwordChangeRequest.getTime();
        Instant end=Instant.now();

        Duration dur = Duration.between(start,end);
        long mins = dur.toMinutes();


        if (mins<24)
        {
            ModelAndView modelAndView=new ModelAndView("update-password");
            modelAndView.addObject("email",email);
            passwordChangeRequestServices.delete(passwordChangeRequest);
            return modelAndView;
        }else {
            return new ModelAndView("password-reset","msg","Link expired.");
        }}catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("password-reset","msg","Link expired.");
    }

    void saveAccessToken(String email,String otp){

    }
}


