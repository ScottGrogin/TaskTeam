package io.github.scottgrogin.TaskTeam.Bootstrap;

import io.github.scottgrogin.TaskTeam.Model.Project;
import io.github.scottgrogin.TaskTeam.Model.User;
import io.github.scottgrogin.TaskTeam.Repos.ProjectRepo;
import io.github.scottgrogin.TaskTeam.Repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;

    public BootstrapData(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Set<User> owners = new HashSet<>();
        Set<Project> projects = new HashSet<>();
        User izzy = new User("Izzy",null,null,null,null,"12345","hjkg@gfdds.com");
        userRepo.save(izzy);
      //  owners.add(izzy);

        Project p1 = new Project("Task Team","Task Team is a website where you can keep track of projects that you " +
                " and your friends are working on.",null,null,null,null);
        projectRepo.save(p1);

        Project p2 = new Project("Advanced Maths","Advanced Maths is a java library that allows you to" +
                " do matrix and vector operations.",null,null,null,null);
        projectRepo.save(p2);

        projects.add(p1);
        projects.add(p2);
        izzy.setOwnedProjects(projects);
        userRepo.save(izzy);

        owners.add(izzy);
        p1.setOwners(owners);
        p2.setOwners(owners);
        projectRepo.save(p1);
        projectRepo.save(p2);
        User Lindsey = new User("Lindsey",null,null,null,
                null,"54321","hjkg@gfds.com");
        userRepo.save(Lindsey);
    }
}
