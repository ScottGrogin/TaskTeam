package io.github.scottgrogin.TaskTeam.Repos;

import io.github.scottgrogin.TaskTeam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Query(value = "SELECT ID FROM USER WHERE USERNAME = :un",nativeQuery = true)
    Long findIdByOwner(@Param("un")String username);
}
