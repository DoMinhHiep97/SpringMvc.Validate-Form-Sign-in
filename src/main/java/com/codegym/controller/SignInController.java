package com.codegym.controller;

import com.codegym.model.FormSignIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignInController {
    @GetMapping("/home")
    public String showForm(Model model){
        model.addAttribute("signIn", new FormSignIn());
        return "index";
    }

    @PostMapping("/check")
    public String checkValidation(@Valid @ModelAttribute("signIn") FormSignIn formSignIn, BindingResult bindingResult,Model model){
        new FormSignIn().validate(formSignIn,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        }else {
            model.addAttribute("firstName",formSignIn.getFirstName());
            model.addAttribute("lastName",formSignIn.getLastName());
            model.addAttribute("phoneNumber",formSignIn.getPhoneNumber());
            model.addAttribute("age",formSignIn.getAge());
            model.addAttribute("email",formSignIn.getEmail());
            return "result";
        }
    }
}
