package io.github.scottgrogin.TaskTeam.Repos;

import io.github.scottgrogin.TaskTeam.Model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task,Long> {
}
