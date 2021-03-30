package com.spring.thiago.controller;

import com.spring.thiago.model.Tell;
import com.spring.thiago.model.User;
import com.spring.thiago.service.UserService;
import com.spring.thiago.serviceTell.TellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TellController {
    @Autowired
    TellService tellService;
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/tell_user/{id}"}, method = RequestMethod.GET)
    public ModelAndView getTellId(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("phone_user");
        List<Tell> tell = tellService.findAllTellId(id);
        mv.addObject("tell", tell);
        return mv;
    }
    @RequestMapping("/delete_phone/{id}")
    public String deleteTell(@PathVariable(name = "id") int id) {
        tellService.deleteTell(id);
        return "redirect:/";
    }


    @RequestMapping(value = {"/phone_user/new"}, method = RequestMethod.GET)
    public ModelAndView newTell(){
        ModelAndView mv = new ModelAndView("new_phone");
        List<User> users = userService.findALl();
        mv.addObject("users", users);
        return mv;
    }
    @RequestMapping(value = "/phone_user/new", method = RequestMethod.POST)
    public String saveTell(@Valid Tell tell, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/phone_user/new";
        }
        tellService.save(tell);
        return "redirect:/users";
    }
}
