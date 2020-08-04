package io.github.scottgrogin.TaskTeam.Repos;

import io.github.scottgrogin.TaskTeam.Model.Project;
import io.github.scottgrogin.TaskTeam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Long> {
    @Query(value = "SELECT OWNED_PROJECTS_ID FROM USER_OWNED_PROJECTS WHERE OWNERS_ID = :oid",nativeQuery = true)
    List<Long> findByOwner(@Param("oid")Long ownerID);

}
