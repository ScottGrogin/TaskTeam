package io.github.scottgrogin.TaskTeam.Controllers;

import io.github.scottgrogin.TaskTeam.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String registerPg(User user){

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("success",false);
        } else{
            model.addAttribute("success",true);
            System.out.println(user.getUsername());
            System.out.println("*********************");
        }

        return "register";
    }
}
