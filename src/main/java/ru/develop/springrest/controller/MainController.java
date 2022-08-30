package ru.develop.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> frontendData = new HashMap<>();

        if (user != null) {
            frontendData.put("profile", user);
            frontendData.put("messages", messageRepo.findAll());
        }

        model.addAttribute("frontendData", frontendData);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }
}
