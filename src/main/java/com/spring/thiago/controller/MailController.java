package com.spring.thiago.controller;

import com.spring.thiago.model.Mail;
import com.spring.thiago.model.User;
import com.spring.thiago.service.UserService;
import com.spring.thiago.serviceMail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MailController {
    @Autowired
    MailService mailService;
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/mail_user/{id}"}, method = RequestMethod.GET)
    public ModelAndView getMailId(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("mail_user");
        List<Mail> mail = mailService.findAllId(id);
        mv.addObject("mail", mail);
        return mv;
    }
    @RequestMapping("/delete_mail/{id}")
    public String deleteMail(@PathVariable(name = "id") int id) {
        mailService.deleteMail(id);
        return "redirect:/";
    }


    @RequestMapping(value = {"/mail_user/new"}, method = RequestMethod.GET)
    public ModelAndView getUsers(){
        ModelAndView mv = new ModelAndView("new_mail");
        List<User> users = userService.findALl();
        mv.addObject("users", users);
        return mv;
    }
    @RequestMapping(value = "/mail_user/new", method = RequestMethod.POST)
    public String saveMail(@Valid Mail mail, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/mail_user/new";
        }
        mailService.save(mail);
        return "redirect:/users";
    }


}
