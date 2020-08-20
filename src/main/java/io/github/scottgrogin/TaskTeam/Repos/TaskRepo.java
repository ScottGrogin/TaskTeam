package io.github.scottgrogin.TaskTeam.Repos;

import io.github.scottgrogin.TaskTeam.Model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task,Long> {
    @Query(value = "SELECT ID FROM TASK WHERE PROJECT_ID = :pid",nativeQuery = true)
    List<Long> findByProjId(@Param("pid")Long projectId);
}
