package ru.develop.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.develop.springrest.domain.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
