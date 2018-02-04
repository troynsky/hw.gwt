package home.work.gwt.server.repository;

import home.work.gwt.common.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
