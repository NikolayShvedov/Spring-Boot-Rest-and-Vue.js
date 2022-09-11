package ru.develop.springrest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.develop.springrest.domain.User;
import ru.develop.springrest.domain.view.Views;
import ru.develop.springrest.repository.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    private final MessageRepo messageRepo;

    @Value("${spring.profiles.active}")
    private String profile;
    private final ObjectWriter writer;

    @Autowired
    public MainController(MessageRepo messageRepo, ObjectMapper mapper) {
        this.messageRepo = messageRepo;

        this.writer = mapper
                .setConfig(mapper.getSerializationConfig())
                .writerWithView(Views.FullMessage.class);
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) throws JsonProcessingException {
        HashMap<Object, Object> frontendData = new HashMap<>();

        if (user != null) {
            frontendData.put("profile", user);

            String messages = writer.writeValueAsString(messageRepo.findAll());
            model.addAttribute("messages", messages);
        } else {
            model.addAttribute("messages", "[]");
        }

        model.addAttribute("frontendData", frontendData);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }
}
