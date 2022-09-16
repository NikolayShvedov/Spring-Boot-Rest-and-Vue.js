package ru.develop.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.develop.springrest.domain.Comment;
import ru.develop.springrest.domain.User;
import ru.develop.springrest.domain.view.Views;
import ru.develop.springrest.dto.EventType;
import ru.develop.springrest.dto.ObjectType;
import ru.develop.springrest.repository.CommentRepo;
import ru.develop.springrest.util.WsSender;

import java.util.function.BiConsumer;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDB = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDB);

        return commentFromDB;
    }
}
