package io.github.scottgrogin.TaskTeam.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "ownedProjects")
    private Set<User> owners = new HashSet<>();
    @ManyToMany(mappedBy = "commentProjects")
    private Set<User> commenters = new HashSet<>();
    @ManyToMany(mappedBy = "viewProjects")
    private Set<User> viewers = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();


    public Project() {
    }

    public Project(String name, Set<User> owners, Set<User> commenters, Set<User> viewers, Set<Task> tasks) {
        this.name = name;
        this.owners = owners;
        this.commenters = commenters;
        this.viewers = viewers;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }

    public Set<User> getCommenters() {
        return commenters;
    }

    public void setCommenters(Set<User> commenters) {
        this.commenters = commenters;
    }

    public Set<User> getViewers() {
        return viewers;
    }

    public void setViewers(Set<User> viewers) {
        this.viewers = viewers;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return id != null ? id.equals(project.id) : project.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
