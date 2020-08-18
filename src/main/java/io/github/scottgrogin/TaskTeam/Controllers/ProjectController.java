package io.github.scottgrogin.TaskTeam.Controllers;

import io.github.scottgrogin.TaskTeam.Model.Project;
import io.github.scottgrogin.TaskTeam.Model.User;
import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import io.github.scottgrogin.TaskTeam.Repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class ProjectController {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;

    public ProjectController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @GetMapping("/newProject")
    public String registerPg(Project project) {

        return "newProject";
    }

    @PostMapping(value = "/newProject")
    public String registerUser(@Valid Project project, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("success", false);
            return "newProject";

        } else {
            redirectAttributes.addFlashAttribute("success", true);
            if (project.getDescription() == null || project.getDescription().isEmpty()) {
                project.setDescription("No description provided, to enter a description visit the project page.");
            }
            Set<User> owners = new HashSet<>();
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            User currentUser = userRepo.findByUsername(username);
            owners.add(currentUser);
            project.setOwners(owners);
            projectRepo.save(project);
            currentUser.getOwnedProjects().add(project);
            userRepo.save(currentUser);

        }
        redirectAttributes.addAttribute("name", project.getName());
        redirectAttributes.addAttribute("description", project.getDescription());
        return "redirect:/newProject";
    }

//TODO: input add prompts for when project is not valid and save changes to database.
    @PostMapping("/projectPage")
    public String displayProjectPage(@Valid Project project, Model model) {
        model.addAttribute("id", project.getId());
        model.addAttribute("name", project.getName());
        model.addAttribute("description", project.getDescription());
        return "/projectPage";
    }



}
