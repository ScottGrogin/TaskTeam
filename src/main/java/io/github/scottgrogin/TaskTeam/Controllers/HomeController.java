package io.github.scottgrogin.TaskTeam.Controllers;

import io.github.scottgrogin.TaskTeam.Model.Project;
import io.github.scottgrogin.TaskTeam.Model.User;
import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import io.github.scottgrogin.TaskTeam.Repos.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;



    public HomeController(UserRepo userRepo, ProjectRepo projectRepo){
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }
    @RequestMapping({"/","/home"})
    public String displayProjects(Project project,Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=((UserDetails)principal).getUsername();
        model.addAttribute("projects",projectRepo.findAllById(projectRepo.findByOwner(userRepo.findIdByOwner(username))));

        return "index";
    }
}
