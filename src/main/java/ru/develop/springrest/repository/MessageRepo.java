package ru.develop.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.develop.springrest.domain.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
