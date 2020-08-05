package io.github.scottgrogin.TaskTeam.Model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    @Size(min=3,max=20)
    @Column(unique = true)
    private String username;



    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @OneToMany()
    private Set<User> friends = new HashSet<>();
    @ManyToMany
    private Set<Project> ownedProjects = new HashSet<>();
    @ManyToMany
    private Set<Project> commentProjects = new HashSet<>();
    @ManyToMany
    private Set<Project> viewProjects = new HashSet<>();
    @NotBlank
    @Size(min=5,max=100)
    private String hash;



    public User() {
    }

    public User( String username, Set<User> friends, Set<Project> ownedProjects,
                Set<Project> commentProjects, Set<Project> viewProjects, String hash,String email) {
        this.username = username;
        this.friends = friends;
        this.ownedProjects = ownedProjects;
        this.commentProjects = commentProjects;
        this.viewProjects = viewProjects;
        this.hash = hash;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Project> getOwnedProjects() {
        return ownedProjects;
    }

    public void setOwnedProjects(Set<Project> ownedProjects) {
        this.ownedProjects = ownedProjects;
    }

    public Set<Project> getCommentProjects() {
        return commentProjects;
    }

    public void setCommentProjects(Set<Project> commentProjects) {
        this.commentProjects = commentProjects;
    }

    public Set<Project> getViewProjects() {
        return viewProjects;
    }

    public void setViewProjects(Set<Project> viewProjects) {
        this.viewProjects = viewProjects;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }



    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
