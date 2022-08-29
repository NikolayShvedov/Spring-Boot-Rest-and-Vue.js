package ru.develop.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.develop.springrest.domain.User;
import ru.develop.springrest.repository.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> frontendData = new HashMap<>();

        frontendData.put("profile", user);
        frontendData.put("messages", messageRepo.findAll());

        model.addAttribute("frontendData", frontendData);
        return "index";
    }
}
