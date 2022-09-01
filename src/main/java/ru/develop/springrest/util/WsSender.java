package ru.develop.springrest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import ru.develop.springrest.dto.WsEventDto;
import ru.develop.springrest.dto.EventType;
import ru.develop.springrest.dto.ObjectType;

import java.util.function.BiConsumer;

@Component
public class WsSender {

    private final SimpMessagingTemplate template;
    private final ObjectMapper mapper;

    public WsSender(SimpMessagingTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    // TODO: This method uses generic, lambda expression and JsonView
    public <T> BiConsumer<EventType, T> getSender(ObjectType objectType, Class view) {
        ObjectWriter writer = mapper
                .setConfig(mapper.getSerializationConfig())
                .writerWithView(view);

        return (EventType eventType, T payload) -> {
            String value = null;

            try {
                value = writer.writeValueAsString(payload);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            template.convertAndSend(
                    "/topic/activity",
                    new WsEventDto(objectType, eventType, value)
            );
        };
    }
}
