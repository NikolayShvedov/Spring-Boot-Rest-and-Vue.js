package ru.develop.springrest.json_converter;

import lombok.SneakyThrows;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import ru.develop.springrest.domain.Message;
import java.io.File;

public class MessageConverter {

    @SneakyThrows
    public static Message convertJsonToMessage(String path) {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new ClassPathResource(path).getFile();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.reader().forType(Message.class).readValue(jsonFile);
    }
}
