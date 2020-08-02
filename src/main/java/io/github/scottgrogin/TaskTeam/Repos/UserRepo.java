package io.github.scottgrogin.TaskTeam.Repos;

import io.github.scottgrogin.TaskTeam.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
