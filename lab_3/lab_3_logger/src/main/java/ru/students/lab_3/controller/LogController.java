package ru.students.lab_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.students.lab_3.model.Request;


@Slf4j
@RestController
public class LogController {

    @PostMapping(value = "/feedback")
    public ResponseEntity<HttpStatus> feedback(@RequestBody Request request) {

        log.info("Request: " + request);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
