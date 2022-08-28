package ru.develop.springrest.controller;

import org.springframework.web.bind.annotation.*;
import ru.develop.springrest.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

    private int counter = 4;

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
       add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First Message"); }});
       add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second Message"); }});
       add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third Message"); }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

    public Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @GetMapping("{id}")
    public Map<String, String> getOneMessage(@PathVariable String id) {
        return getMessage(id);
    }

    @PostMapping
    public Map<String, String> addMessage(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));

        messages.add(message);

        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> updateMessage(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDB = getMessage(id);

        messageFromDB.putAll(message);
        messageFromDB.put("id", id);

        return messageFromDB;
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id) {
        Map<String, String> message = getMessage(id);

        messages.remove(message);
    }
}
