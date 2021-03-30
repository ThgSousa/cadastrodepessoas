package com.spring.thiago.controller;

import com.spring.thiago.model.Company;
import com.spring.thiago.serviceCompany.CompanyService;
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
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = {"/company"}, method = RequestMethod.GET)
    public ModelAndView getCompany(){
        ModelAndView mv = new ModelAndView("companies");
        List<Company> company = companyService.findALl();
        mv.addObject("company", company);
        return mv;
    }

    @RequestMapping(value = "/edit_company/{id}", method = RequestMethod.GET)
    public ModelAndView getCompanyEditForm(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("edit_company");
        Company company = companyService.findById(id);
        mv.addObject("company", company);
        return mv;
    }

    @RequestMapping(value = "/edit_company/{id}", method = RequestMethod.POST)
    public String editCompany(@Valid Company company, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/edit_company/{id}";
        }
        company.setData(LocalDateTime.now());
        companyService.save(company);
        return "redirect:/company";
    }

    @RequestMapping(value = "/new_company", method = RequestMethod.GET)
    public String getCompanyForm(){
        return "new_company";
    }

    @RequestMapping(value = "/new_company", method = RequestMethod.POST)
    public String saveCompany(@Valid Company company, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/new_company";
        }
        company.setData(LocalDateTime.now());
        companyService.save(company);
        return "redirect:/company";
    }
    @RequestMapping("/delete_company/{id}")
    public String deleteCompany(@PathVariable(name = "id") int id) {
        companyService.deleteCompany(id);
        return "redirect:/company";
    }


}
