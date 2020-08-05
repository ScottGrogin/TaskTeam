package io.github.scottgrogin.TaskTeam.Controllers;

import io.github.scottgrogin.TaskTeam.Model.User;
import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import io.github.scottgrogin.TaskTeam.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserRepo userRepo;
    public RegisterController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping("/register")
    public String registerPg(User user){

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        boolean err = false;
        String persistanceErrMsg = "";
        try {
            userRepo.save(user);
        } catch (Exception e){
            err = true;
            if(e.getMessage().contains("USERNAME")){
                persistanceErrMsg = "ERROR: Username taken";
            } else if (e.getMessage().contains("EMAIL")){
                persistanceErrMsg="ERROR: Email already registered";
            }

        }
        model.addAttribute("permsg",persistanceErrMsg);
        if(bindingResult.hasErrors()||err){
            model.addAttribute("success",false);
        } else{
            model.addAttribute("success",true);
        }

        return "register";
    }
}
