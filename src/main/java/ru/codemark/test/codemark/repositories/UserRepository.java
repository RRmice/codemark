package ru.codemark.test.codemark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.codemark.test.codemark.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
}
