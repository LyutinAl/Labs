package ru.students.lab_2.service;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.students.lab_2.model.Request;

@Service
public class MorifyRequestSystemTime implements ModifyRequestServise{
    @Override
    public void modify(Request request) {
        request.setSystemTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8082/feedback", 
        HttpMethod.POST,
        httpEntity,
        new ParameterizedTypeReference<>() {
        });
    }
}
