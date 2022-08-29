package ru.develop.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.develop.springrest.domain.User;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, String> {
}
