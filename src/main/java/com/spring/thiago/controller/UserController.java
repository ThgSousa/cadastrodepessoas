package com.spring.thiago.controller;

import com.spring.thiago.model.User;
import com.spring.thiago.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/users", "/"}, method = RequestMethod.GET)
    public ModelAndView getUsers(){
        ModelAndView mv = new ModelAndView("users");
        List<User> users = userService.findALl();
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(value = "/edit_user/{id}", method = RequestMethod.GET)
    public ModelAndView getUserEditForm(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("edit_user");
        User user2 = userService.findById(id);
        mv.addObject("user2", user2);
        return mv;
    }

    @RequestMapping(value = "/edit_user/{id}", method = RequestMethod.POST)
    public String edituser(@Valid User user, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/edit_user/{id}";
        }
        user.setData(LocalDateTime.now());
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String getUserForm(){
        return "new_user";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String saveuser(@Valid User user, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/new_user";
        }
        user.setData(LocalDateTime.now());
        userService.save(user);
        return "redirect:/users";
    }
    @RequestMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
