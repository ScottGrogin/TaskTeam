package io.github.scottgrogin.TaskTeam.Controllers;

import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
    private final ProjectRepo projectRepo;

    public ProjectController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

}
