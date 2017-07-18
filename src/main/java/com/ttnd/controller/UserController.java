package com.ttnd.controller;
import com.ttnd.Entity.User;
import com.ttnd.Services.UserServices;
import com.ttnd.Services.UserServicesImple;
import com.ttnd.micro_services.MailNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class UserController {

    UserServices userServices = new UserServicesImple();

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
    public ModelAndView reset(@RequestParam String email){
        notifyEmail("email");
        return new ModelAndView("index");
    }

    @RequestMapping(value="/reset")
    public ModelAndView reset(){

        return new ModelAndView("password-reset");
    }

    public void notifyEmail(String email){
        try{
      ApplicationContext ctx=new ClassPathXmlApplicationContext("../webapp/applicationContext.xml");
        MailNotification m=(MailNotification)ctx.getBean("mail");
        String sender="somya777.srivastava@gmail.com";//write here sender gmail id
        String receiver=email;//write here receiver id
        System.out.println("notifyEmal action ::: "+m+ " :: ");
        m.sendMail(sender,receiver,"hi","welcome");}
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


