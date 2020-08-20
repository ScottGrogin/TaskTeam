package io.github.scottgrogin.TaskTeam.Bootstrap;

import io.github.scottgrogin.TaskTeam.Model.Project;
import io.github.scottgrogin.TaskTeam.Model.Status;
import io.github.scottgrogin.TaskTeam.Model.Task;
import io.github.scottgrogin.TaskTeam.Model.User;
import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import io.github.scottgrogin.TaskTeam.Repos.TaskRepo;
import io.github.scottgrogin.TaskTeam.Repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;
    private final TaskRepo taskRepo;

    public BootstrapData(UserRepo userRepo, ProjectRepo projectRepo, TaskRepo taskRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Set<User> owners = new HashSet<>();
        Set<Project> projects = new HashSet<>();
        Set<Task> tasks = new HashSet<>();

        User izzy = new User("Izzy", null, null, null, null, "12345", "hjkg@gfdds.com");
        userRepo.save(izzy);

        Project p1 = new Project("Task Team", "Task Team is a website where you can keep track of projects that you " +
                " and your friends are working on.", null, null, null, null);
        projectRepo.save(p1);

        Task task = new Task("Add Task list to project page", "project page currently only" +
                " shows project name and description. Tasks need to be added.", Status.PENDING, null, null);
        taskRepo.save(task);

        owners.add(izzy);
        projects.add(p1);
        tasks.add(task);

        task.setProject(p1);
        taskRepo.save(task);

        p1.setTasks(tasks);
        p1.setOwners(owners);
        projectRepo.save(p1);

        izzy.setOwnedProjects(projects);
        userRepo.save(izzy);

    }
}
